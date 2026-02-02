package com.world.api.web.controller;

import com.world.api.domain.enums.Continent;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final WorldService worldService;

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Integer id) {
        return ResponseEntity.ok(worldService.getCityById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CityDto>> searchCities(@RequestParam String name) {
        return ResponseEntity.ok(worldService.searchCitiesByName(name));
    }

    @GetMapping("/top")
    public ResponseEntity<List<CityDto>> getTopCities(
            @RequestParam Continent continent,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(worldService.getTopCitiesByContinent(continent, limit));
    }
}