package com.example.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finances.model.Receitas;

@Repository
public interface RepositorioReceitas extends JpaRepository<Receitas, Long> {

}