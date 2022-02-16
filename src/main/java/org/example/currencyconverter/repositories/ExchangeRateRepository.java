package org.example.currencyconverter.repositories;

import org.example.currencyconverter.models.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    //поиск курса по Id
    @Query(value = "SELECT * FROM exchangerates WHERE exch_id = ?", nativeQuery = true)
    ExchangeRate findRateById(Long Id);
}
