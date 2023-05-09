package com.minsait.empresaFinanceira.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.empresaFinanceira.entity.Emprestimo;
import com.minsait.empresaFinanceira.exception.ClienteNaoEncontradoException;
import com.minsait.empresaFinanceira.exception.EmprestimoNaoEncontradoException;
import com.minsait.empresaFinanceira.exception.LimiteDeEmprestimosException;
import com.minsait.empresaFinanceira.service.EmprestimoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/financeira/clientes/{cpf}/emprestimos")
public class EmprestimoController {

	private EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo cadastrarEmprestimo(@PathVariable String cpf, @Valid @RequestBody Emprestimo emprestimo) throws ClienteNaoEncontradoException, LimiteDeEmprestimosException {
		return emprestimoService.cadastrarEmprestimo(cpf, emprestimo);
	}

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public List<Emprestimo> retornaTodosOsEmprestimos(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		return emprestimoService.retornaTodosOsEmprestimos(cpf);
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Emprestimo retornaEmprestimo(@PathVariable String cpf, @PathVariable Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException{
		return emprestimoService.retornaEmprestimo(cpf, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarEmprestimo(@PathVariable String cpf, @PathVariable Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException{
		emprestimoService.deletarEmprestimo(cpf, id);
	}
	
}
