package com.tomaz.ponto.inteligente.api.response;

import java.util.List;
import java.util.Optional;

import com.tomaz.ponto.inteligente.api.dto.LancamentoDto;

import java.util.ArrayList;

public class Response<T> {

	private T data;
	private List<String> errors;
	
	public Response() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if(this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void setData(Optional<LancamentoDto> lancamentoDto) {		
	}
	
}
