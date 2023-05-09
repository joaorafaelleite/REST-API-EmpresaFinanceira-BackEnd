package com.minsait.empresaFinanceira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.empresaFinanceira.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Cliente findByCpf(String cpf);

    boolean existsByCpf(String cpf);
	
}
