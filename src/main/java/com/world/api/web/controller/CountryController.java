package com.world.api.web.controller;

import com.world.api.domain.enums.Continent;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import com.world.api.web.dto.LanguageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Country & Geography", description = "Operations related to countries, continents, and global language distribution")
public class CountryController {

    private final WorldService worldService;

    @Operation(summary = "List all countries", description = "Retrieves a summary list containing basic information for every country.")
    @GetMapping("/countries")
    public ResponseEntity<List<CountrySummaryDto>> getAllCountries() {
        return ResponseEntity.ok(worldService.getAllCountries());
    }

    @Operation(summary = "Get detailed country profile", description = "Returns full data for a specific country, including its internal cities and official languages, using its 3-letter code.")
    @GetMapping("/countries/{code}")
    public ResponseEntity<CountryResponseDto> getCountryByCode(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getCountryByCode(code));
    }

    @Operation(summary = "Search countries by name", description = "Finds countries whose names contain the provided search string (case-insensitive).")
    @GetMapping("/countries/search")
    public ResponseEntity<List<CountrySummaryDto>> searchCountries(@RequestParam String name) {
        return ResponseEntity.ok(worldService.searchCountriesByName(name));
    }

    @Operation(summary = "Filter countries by continent", description = "Retrieves all countries located within a specific continent.")
    @GetMapping("/continents/{continent}/countries")
    public ResponseEntity<List<CountrySummaryDto>> getCountriesByContinent(@PathVariable Continent continent) {
        return ResponseEntity.ok(worldService.getCountriesByContinent(continent));
    }

    @Operation(summary = "Get cities by country", description = "Retrieves a list of all cities belonging to a specific country code.")
    @GetMapping("/countries/{code}/cities")
    public ResponseEntity<List<CityDto>> getCitiesByCountry(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getCitiesByCountry(code));
    }

    @Operation(summary = "Get languages by country", description = "Retrieves all languages spoken in a specific country, including their official status and percentage.")
    @GetMapping("/countries/{code}/languages")
    public ResponseEntity<List<LanguageDto>> getLanguagesByCountry(@PathVariable String code) {
        return ResponseEntity.ok(worldService.getLanguagesByCountry(code));
    }

    @Operation(summary = "Find countries by language", description = "Returns a list of countries where a specific language is spoken.")
    @GetMapping("/languages/{language}/countries")
    public ResponseEntity<List<CountrySummaryDto>> getCountriesByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(worldService.getCountriesByLanguage(language));
    }
}