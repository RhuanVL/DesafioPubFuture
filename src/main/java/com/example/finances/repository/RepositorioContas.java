package com.example.finances.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.finances.model.Contas;

@Repository
@Transactional
public interface RepositorioContas extends JpaRepository<Contas, Long> {

}