package com.world.api.repository;

import com.world.api.domain.entity.Country;
import com.world.api.domain.entity.CountryLanguage;
import com.world.api.domain.entity.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    List<CountryLanguage> findByIdCountryCode(String countryCode);

    @Query("SELECT cl.country FROM CountryLanguage cl WHERE cl.id.language = :language")
    List<Country> findCountriesByLanguage(@Param("language") String language);

}