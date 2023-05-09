package com.minsait.empresaFinanceira.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.empresaFinanceira.dto.ClienteDTO;
import com.minsait.empresaFinanceira.entity.Cliente;
import com.minsait.empresaFinanceira.exception.ClienteDuplicadoException;
import com.minsait.empresaFinanceira.exception.ClienteNaoEncontradoException;
import com.minsait.empresaFinanceira.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ClienteDTO cadastrarCliente(Cliente cliente) throws ClienteDuplicadoException {
		if(!clienteRepository.existsById(cliente.getCpf())) {
			ClienteDTO clienteRequest = ClienteDTO.retornaCliente(cliente);
			clienteRepository.save(cliente);
			return clienteRequest;
		}
		
		throw new ClienteDuplicadoException(cliente.getCpf());
	}

	public List<Cliente> retornaTodosOsClientes() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente retornaCliente(String cpf) throws ClienteNaoEncontradoException {
		if(this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.getReferenceById(cpf); 
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
	
    public Cliente alterarCliente(String cpf, @Valid Cliente cliente) throws ClienteNaoEncontradoException {
    	if(this.clienteRepository.existsById(cpf)) {
    		
    		Cliente clienteASerAlterado = this.clienteRepository.findById(cpf).get();
    		
    		cliente.setCpf(cpf);
    		
			if(cliente.getNome() == null) {
				cliente.setNome(clienteASerAlterado.getNome());
			}
			if(cliente.getTelefone() == null) {
				cliente.setTelefone(clienteASerAlterado.getTelefone());
			}
			if(cliente.getEndereco() == null) {
				cliente.setEndereco(clienteASerAlterado.getEndereco());
			}
			if(cliente.getRendimentoMensal() == null) {
				cliente.setRendimentoMensal(clienteASerAlterado.getRendimentoMensal());
			}
			
			return this.clienteRepository.save(cliente);
       }
		throw new ClienteNaoEncontradoException(cpf);
    }
    
	public void deletarCliente(String cpf) throws ClienteNaoEncontradoException {
		try{
			if(this.clienteRepository.existsById(cpf)) {
				this.clienteRepository.deleteById(cpf);
			}
		}
		catch(Exception e) {
			throw new ClienteNaoEncontradoException(cpf);
		}
	}

}
