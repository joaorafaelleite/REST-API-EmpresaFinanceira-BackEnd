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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.empresaFinanceira.dto.ClienteDTO;
import com.minsait.empresaFinanceira.entity.Cliente;
import com.minsait.empresaFinanceira.exception.ClienteDuplicadoException;
import com.minsait.empresaFinanceira.exception.ClienteNaoEncontradoException;
import com.minsait.empresaFinanceira.service.ClienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/financeira/clientes")
public class ClienteController {

	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO cadastrarCliente(@Valid @RequestBody Cliente cliente) throws ClienteDuplicadoException {
		return clienteService.cadastrarCliente(cliente);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> retornaTodosOsClientes(){
		List<Cliente> retorno = this.clienteService.retornaTodosOsClientes();
		return retorno;
	}
	
	@GetMapping("/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteDTO retornaCliente(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		Cliente clienteEncontrado = this.clienteService.retornaCliente(cpf);		
		return ClienteDTO.retornaCliente(clienteEncontrado);
	}
	
	@PutMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
	public ClienteDTO alterarCliente(@PathVariable String cpf, @Valid @RequestBody ClienteDTO clienteDTO) throws ClienteNaoEncontradoException, ClienteDuplicadoException{
		Cliente clienteRequest = ClienteDTO.retornaCliente(clienteDTO);
		
		Cliente clienteAlterado = this.clienteService.alterarCliente(cpf, clienteRequest);
		
		return ClienteDTO.retornaCliente(clienteAlterado);
	}
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		this.clienteService.deletarCliente(cpf);
	}
}
