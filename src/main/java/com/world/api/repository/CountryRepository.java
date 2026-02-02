package com.world.api.repository;

import com.world.api.domain.entity.Country;
import com.world.api.domain.enums.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT c FROM Country c " +
            "LEFT JOIN FETCH c.cities " +
            "LEFT JOIN FETCH c.languages " +
            "WHERE c.code = :code")
    Optional<Country> findByCodeWithDetails(@Param("code") String code);

    List<Country> findByContinent(Continent continent);
}