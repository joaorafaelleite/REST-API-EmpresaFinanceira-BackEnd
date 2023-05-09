package com.minsait.empresaFinanceira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minsait.empresaFinanceira.entity.Cliente;
import com.minsait.empresaFinanceira.enums.Relacionamento;

import lombok.Data;

@Data
public class EmprestimoDTO {
	
	private Long emprestimoId;
	
	private String cpfCliente;

    @JsonProperty("valorInicial")
    @NotNull(message = "O campo 'ValorInicial' é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo 'ValorInicial' deve ser maior que 0")
    private BigDecimal valorInicial;

    @JsonProperty("dataInicial")
    @NotNull(message = "O campo 'dataInicial' é obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;

    @JsonProperty("dataFinal")
    @NotNull(message = "O campo 'dataFinal' é obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;

    @JsonProperty("relacionamento")
    @NotNull(message = "O campo 'relacionamento' é obrigatório")
    private Relacionamento relacionamento;

    @JsonProperty("ValorFinal")
    private BigDecimal valorFinal;
	
    private Cliente cliente;
    
	public EmprestimoDTO() {
	}

	public EmprestimoDTO(Long emprestimoId, String cpfCliente, BigDecimal valorInicial,  BigDecimal valorFinal, Relacionamento relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
		this.emprestimoId = emprestimoId;
		this.cpfCliente = cpfCliente;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Long getEmprestimoId() {
		return emprestimoId;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
