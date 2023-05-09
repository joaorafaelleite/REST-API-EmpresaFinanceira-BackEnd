package com.minsait.empresaFinanceira.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.empresaFinanceira.entity.Cliente;
import com.minsait.empresaFinanceira.entity.Emprestimo;
import com.minsait.empresaFinanceira.exception.ClienteNaoEncontradoException;
import com.minsait.empresaFinanceira.exception.EmprestimoNaoEncontradoException;
import com.minsait.empresaFinanceira.exception.LimiteDeEmprestimosException;
import com.minsait.empresaFinanceira.repository.ClienteRepository;
import com.minsait.empresaFinanceira.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	private ClienteRepository clienteRepository;
	
	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.emprestimoRepository = emprestimoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public Emprestimo cadastrarEmprestimo(String cpf, Emprestimo emprestimo) throws ClienteNaoEncontradoException, LimiteDeEmprestimosException  {
		if(clienteRepository.existsById(cpf)) {
			Cliente cliente = clienteRepository.findByCpf(cpf);
			emprestimo.setCliente(cliente);
			BigDecimal valorInicial = emprestimo.getValorInicial();
			
			if(cliente.podeReceberEmprestimo(valorInicial)) {
				return manterEmprestimo(cliente, emprestimo);
			}
			throw new LimiteDeEmprestimosException(cliente.getCpf());
		}
		throw new ClienteNaoEncontradoException(cpf);
	}

	public List<Emprestimo> retornaTodosOsEmprestimos(String cpf) throws ClienteNaoEncontradoException {
		if(clienteRepository.existsById(cpf)) {			
			return this.emprestimoRepository.findAll();
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	public Emprestimo retornaEmprestimo(String cpf, Long emprestimoId) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException {
		if(clienteRepository.existsById(cpf)) {
			if(emprestimoRepository.existsById(emprestimoId)) {
				Emprestimo emprestimo = emprestimoRepository.getReferenceById(emprestimoId);
				return emprestimo;
			}
			throw new EmprestimoNaoEncontradoException(emprestimoId);
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
	
    private Emprestimo manterEmprestimo(Cliente cliente, Emprestimo emprestimo) {
        emprestimo.setCliente(cliente);
        emprestimo.atualizarValorFinal();
        cliente.adicionarEmprestimo(emprestimo);
        emprestimoRepository.save(emprestimo);
        return emprestimo;
    }

	public void deletarEmprestimo(String cpf, Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException {
		if(clienteRepository.existsById(cpf)) {
			if(emprestimoRepository.existsById(id)) {
				this.emprestimoRepository.deleteById(id);
				return;
			}
			throw new EmprestimoNaoEncontradoException(id);
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
		
}
