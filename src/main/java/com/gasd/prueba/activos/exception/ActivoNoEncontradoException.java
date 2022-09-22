package com.gasd.prueba.activos.exception;

import org.springframework.http.HttpStatus;

import com.gasd.prueba.activos.error.ErrorCodeEnum;
import com.gasd.prueba.activos.error.InternalServerErrorException;

public class ActivoNoEncontradoException extends InternalServerErrorException{

	public ActivoNoEncontradoException() {
		super(new ServerErrorResponseDto("El activo no fue encontrado", ErrorCodeEnum.ASSET_NOT_FOUND, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	

}
