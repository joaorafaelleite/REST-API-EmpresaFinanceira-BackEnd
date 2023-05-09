package com.minsait.empresaFinanceira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.empresaFinanceira.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
