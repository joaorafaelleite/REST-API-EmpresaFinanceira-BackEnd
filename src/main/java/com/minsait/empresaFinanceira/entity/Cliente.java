package com.minsait.empresaFinanceira.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {

	@Id
	@CPF
	@NotEmpty(message="CPF é um campo obrigatório")
	private String cpf;
	
	@NotEmpty(message="Nome é um campo obrigatório")
	private String nome;
	
	@NotBlank(message="Telefone é um campo obrigatório")
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private	Endereco endereco;
	
	@NotNull(message="Rendimento Mensal é um campo obrigatório")
	private BigDecimal rendimentoMensal;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Emprestimo> listEmprestimos;
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String nome, String telefone, Endereco endereco, BigDecimal rendimentoMensal,
			List<Emprestimo> listEmprestimos) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rendimentoMensal = rendimentoMensal;
		this.listEmprestimos = listEmprestimos;
	}

	public Cliente(String cpf, String nome, String telefone, Endereco endereco, BigDecimal rendimentoMensal) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rendimentoMensal = rendimentoMensal;
	}
	
    public boolean podeReceberEmprestimo(BigDecimal valorInicial) {
        BigDecimal totalDeEmprestimos = getTotalDeEmprestimos();
        BigDecimal valorMaximoDeEmprestimos = getLimiteDeEmprestimos();

        return totalDeEmprestimos.add(valorInicial).compareTo(valorMaximoDeEmprestimos) <= 0;
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

	public List<Emprestimo> getListEmprestimos() {
		return listEmprestimos;
	}

	public void setListEmprestimos(List<Emprestimo> listEmprestimos) {
		this.listEmprestimos = listEmprestimos;
	}

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        listEmprestimos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        listEmprestimos.remove(emprestimo);
    }

    private BigDecimal getTotalDeEmprestimos() {
        BigDecimal totalDeEmprestimos = BigDecimal.ZERO;

        if (listEmprestimos.isEmpty()) {
            return totalDeEmprestimos;
        }
        for (Emprestimo emprestimos : listEmprestimos) {
        	totalDeEmprestimos = totalDeEmprestimos.add(emprestimos.getValorInicial());
        }
        return totalDeEmprestimos;
    }

    private BigDecimal getLimiteDeEmprestimos() {
        return rendimentoMensal.multiply(BigDecimal.valueOf(10));
    }
	
	
}
