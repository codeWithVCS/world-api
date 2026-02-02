package com.world.api.web.controller;

import com.world.api.domain.enums.Continent;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import com.world.api.web.dto.LanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CountryController {

    private final WorldService worldService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountrySummaryDto>> getAllCountries() {
        return ResponseEntity.ok(worldService.getAllCountries());
    }

    @GetMapping("/countries/{code}")
    public ResponseEntity<CountryResponseDto> getCountryByCode(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getCountryByCode(code));
    }

    @GetMapping("/countries/search")
    public ResponseEntity<List<CountrySummaryDto>> searchCountries(@RequestParam String name) {
        return ResponseEntity.ok(worldService.searchCountriesByName(name));
    }

    @GetMapping("/continents/{continent}/countries")
    public ResponseEntity<List<CountrySummaryDto>> getCountriesByContinent(@PathVariable Continent continent) {
        return ResponseEntity.ok(worldService.getCountriesByContinent(continent));
    }

    @GetMapping("/countries/{code}/cities")
    public ResponseEntity<List<CityDto>> getCitiesByCountry(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getCitiesByCountry(code));
    }

    @GetMapping("/countries/{code}/languages")
    public ResponseEntity<List<LanguageDto>> getLanguagesByCountry(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getLanguagesByCountry(code));
    }

    @GetMapping("/languages/{language}/countries")
    public ResponseEntity<List<CountrySummaryDto>> getCountriesByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(worldService.getCountriesByLanguage(language));
    }

}