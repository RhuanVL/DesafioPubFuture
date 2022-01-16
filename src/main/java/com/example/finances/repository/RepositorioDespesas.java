package com.example.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finances.model.Despesas;

@Repository
public interface RepositorioDespesas extends JpaRepository<Despesas, Long> {

}
