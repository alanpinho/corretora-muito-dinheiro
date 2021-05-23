package com.muitodinheiro.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muitodinheiro.app.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
