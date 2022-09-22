package com.gasd.prueba.activos.exception;

import org.springframework.http.HttpStatus;

import com.gasd.prueba.activos.error.ErrorCodeEnum;
import com.gasd.prueba.activos.error.InternalServerErrorException;

public class ActivoExistenteException extends InternalServerErrorException {

	public ActivoExistenteException() {
		super(new ServerErrorResponseDto("El activo ya existe", ErrorCodeEnum.ASSET_ALREADY_EXISTS, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
