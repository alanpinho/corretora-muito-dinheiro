package com.muitodinheiro.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muitodinheiro.app.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{
}
