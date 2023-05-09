package com.minsait.empresaFinanceira.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String cpf) {
		super(String.format("O CPF %s não foi encontrado", cpf));
	}
}
