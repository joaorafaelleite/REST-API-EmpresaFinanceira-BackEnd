package com.minsait.empresaFinanceira.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClienteDuplicadoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
    public ClienteDuplicadoException(String cpf) {
        super(String.format("Cliente com o CPF: %s já cadastrado", cpf));
    }
}
