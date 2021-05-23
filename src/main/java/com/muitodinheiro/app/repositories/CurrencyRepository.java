package com.muitodinheiro.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muitodinheiro.app.entities.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String>{

}
