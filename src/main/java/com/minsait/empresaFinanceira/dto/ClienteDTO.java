package com.minsait.empresaFinanceira.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minsait.empresaFinanceira.entity.Cliente;
import com.minsait.empresaFinanceira.entity.Endereco;

import lombok.Data;

@Data
public class ClienteDTO {

    @JsonProperty("cpf")
    @Pattern(regexp="^[0-9]{11}$", message="O campo CPF precisa ter 11 dígitos.")
	private String cpf;
	
    @JsonProperty("nome")
	private String nome;
	
    @JsonProperty("telefone")
    @Pattern(regexp = "^\\d+$", message = "O campo 'telefone' deve conter apenas números")
    @Pattern(regexp = "^.{10,11}$", message = "O campo 'telefone' deve conter entre 10 e 11 números")
	private String telefone;
  
    private Endereco endereco;
	
    @JsonProperty("rendimentoMensal")
	private BigDecimal rendimentoMensal;
	
	
	public ClienteDTO() {
	}

	public ClienteDTO(String cpf, String nome, String telefone, Endereco endereco, BigDecimal rendimentoMensal) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rendimentoMensal = rendimentoMensal;
	}

	public static ClienteDTO retornaCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getRendimentoMensal());
		return clienteDTO;
	}
	
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getCpf(), clienteDTO.getNome(), clienteDTO.getTelefone(), clienteDTO.getEndereco(), clienteDTO.getRendimentoMensal());
		return cliente;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}


	
}
