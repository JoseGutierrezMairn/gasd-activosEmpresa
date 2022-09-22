package com.gasd.prueba.activos.config;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.gasd.prueba.activos.error.ErrorCodeEnum;
import com.gasd.prueba.activos.error.InternalServerErrorException;
import com.gasd.prueba.activos.exception.ServerErrorResponseDto;

@RestControllerAdvice
public class RestControllerErrorHandler {
	@ExceptionHandler( HttpMessageNotReadableException.class )
    private ResponseEntity<String> handleHTTPMessageNotReadable( HttpMessageNotReadableException exception )
    {
        return new ResponseEntity( exception.getCause().getMessage(), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler( MissingServletRequestPartException.class )
    private ResponseEntity<String> handleMissingServletRequestPart( MissingServletRequestPartException exception )

    {
        return new ResponseEntity( exception.getCause().getMessage(), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler( InternalServerErrorException.class )
    private ResponseEntity<ServerErrorResponseDto> handleRuntimeException(InternalServerErrorException exception )

    {
        return new ResponseEntity( exception.getServerErrorResponseDto(), exception.getHttpStatus() );
    }
    
    @ExceptionHandler( MethodArgumentTypeMismatchException.class )
    private ResponseEntity<ServerErrorResponseDto> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception )

    {
        return new ResponseEntity( new ServerErrorResponseDto("Formato incorrecto", ErrorCodeEnum.ASSET_NOT_FOUND, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    
    
    @ExceptionHandler( SQLIntegrityConstraintViolationException.class )
    private ResponseEntity<ServerErrorResponseDto> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception )

    {
        return new ResponseEntity( new ServerErrorResponseDto("Violacion de restriccion en base de datos", ErrorCodeEnum.CONSTRAINT_VIOLATION, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
