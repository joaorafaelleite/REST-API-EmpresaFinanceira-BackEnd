package com.minsait.empresaFinanceira.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LimiteDeEmprestimosException extends Exception{

	private static final long serialVersionUID = 1L;

    public LimiteDeEmprestimosException(String message) {
        super("Emprestimo recusado, limite de empréstimos ultrapassado: " + message);
    }
}
