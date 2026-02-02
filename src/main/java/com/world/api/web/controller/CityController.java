package com.world.api.web.controller;

import com.world.api.domain.enums.Continent;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
@Tag(name = "Cities", description = "Operations related to individual city data and urban population statistics")
public class CityController {

    private final WorldService worldService;

    @Operation(summary = "Get city by ID", description = "Fetches specific details for a city using its unique numeric identifier.")
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Integer id) {
        return ResponseEntity.ok(worldService.getCityById(id));
    }

    @Operation(summary = "Search cities by name", description = "Performs a global search for cities by name, regardless of country.")
    @GetMapping("/search")
    public ResponseEntity<List<CityDto>> searchCities(@RequestParam String name) {
        return ResponseEntity.ok(worldService.searchCitiesByName(name));
    }

    @Operation(summary = "Get top populous cities", description = "Retrieves the most populous cities within a specific continent, limited by the provided count.")
    @GetMapping("/top")
    public ResponseEntity<List<CityDto>> getTopCities(
            @RequestParam Continent continent,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(worldService.getTopCitiesByContinent(continent, limit));
    }
}