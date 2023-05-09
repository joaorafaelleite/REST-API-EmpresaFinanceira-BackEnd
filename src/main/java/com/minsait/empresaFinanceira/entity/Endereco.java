package com.minsait.empresaFinanceira.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonProperty("rua")
	@NotNull(message="O campo 'rua' é obrigatório")
	private String rua;
	
    @JsonProperty("numero")
	@NotBlank(message="O campo 'numero' é obrigatório")
	private String numero;
	
    @JsonProperty("cep")
    @Pattern(regexp="^[0-9]{8}$", message = "O campo 'CEP' deve conter apenas números")
	@NotBlank(message="O campo 'CEP' é obrigatório")
	private String CEP;
	
	public Endereco() {
	}

	public Endereco(Long id, String rua, String numero, String cep) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.CEP = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return CEP;
	}

	public void setCep(String cep) {
		this.CEP = cep;
	}
	
	@Override
	public String toString() {
		return rua + ", " + numero + ", CEP: " + CEP;
	}
	
	
	
}
