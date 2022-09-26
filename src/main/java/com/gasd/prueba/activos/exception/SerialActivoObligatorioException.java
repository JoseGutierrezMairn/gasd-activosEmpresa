package com.gasd.prueba.activos.exception;

import org.springframework.http.HttpStatus;

import com.gasd.prueba.activos.error.ErrorCodeEnum;
import com.gasd.prueba.activos.error.InternalServerErrorException;

public class SerialActivoObligatorioException extends InternalServerErrorException{

	public SerialActivoObligatorioException() {
		super(new ServerErrorResponseDto("El campo serial del activo es obligatorio", ErrorCodeEnum.EMPTY_DATA, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
	
}
