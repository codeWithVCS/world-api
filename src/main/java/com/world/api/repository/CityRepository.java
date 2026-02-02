package com.world.api.repository;

import com.world.api.domain.entity.City;
import com.world.api.domain.enums.Continent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByCountryCode(String countryCode);

    List<City> findByNameContainingIgnoreCase(String name);

    @Query("SELECT c FROM City c WHERE c.country.continent = :continent ORDER BY c.population DESC")
    List<City> findTopCitiesByContinent(@Param("continent") Continent continent, Pageable pageable);

}