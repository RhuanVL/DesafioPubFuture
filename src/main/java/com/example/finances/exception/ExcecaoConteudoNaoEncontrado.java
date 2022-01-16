package com.example.finances.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExcecaoConteudoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcecaoConteudoNaoEncontrado(String message) {
		super(message);
	}
}
