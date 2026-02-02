package com.world.api.web.controller;

import com.world.api.service.WorldService;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final WorldService worldService;

    @GetMapping
    public ResponseEntity<List<CountrySummaryDto>> getAllCountries() {
        List<CountrySummaryDto> countrySummaryDtoList = worldService.getAllCountries();
        return ResponseEntity.status(HttpStatus.OK).body(countrySummaryDtoList);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CountryResponseDto> getCountryByCode(@PathVariable String code) {
        CountryResponseDto countryResponseDto = worldService.getCountryByCode(code);
        return ResponseEntity.status(HttpStatus.OK).body(countryResponseDto);
    }

}
