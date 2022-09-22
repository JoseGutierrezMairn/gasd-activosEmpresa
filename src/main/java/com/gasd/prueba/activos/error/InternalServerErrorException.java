package com.gasd.prueba.activos.error;

import org.springframework.http.HttpStatus;

import com.gasd.prueba.activos.exception.ServerErrorResponseDto;

public class InternalServerErrorException extends RuntimeException
{

    private final ServerErrorResponseDto serverErrorResponseDto;


    private final HttpStatus httpStatus;

    public InternalServerErrorException( ServerErrorResponseDto serverErrorResponseDto, HttpStatus httpStatus )
    {
        this.serverErrorResponseDto = serverErrorResponseDto;
        this.httpStatus = httpStatus;
    }


    public ServerErrorResponseDto getServerErrorResponseDto()
    {
        return serverErrorResponseDto;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }
}