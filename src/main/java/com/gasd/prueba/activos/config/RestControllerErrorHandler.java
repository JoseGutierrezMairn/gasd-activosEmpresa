package com.gasd.prueba.activos.config;

import java.net.ConnectException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

import org.hibernate.exception.SQLGrammarException;
import org.hibernate.id.IdentifierGenerationException;
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
    	ServerErrorResponseDto dto = buildSqlResponse(exception);
        return new ResponseEntity( dto, dto.getHttpStatus() == 400 ? HttpStatus.BAD_REQUEST :  HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler(ConnectException.class )
    private ResponseEntity<ServerErrorResponseDto> handleConnectException(ConnectException exception )

    {
    	return new ResponseEntity( new ServerErrorResponseDto("No hay conexión a la base de datos", ErrorCodeEnum.CONNECTION_REFUSED, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    /*
    @ExceptionHandler(SQLSyntaxErrorException.class)
    private ResponseEntity<ServerErrorResponseDto> handleSQLSyntaxErrorException(SQLSyntaxErrorException exception )

    {
    	return new ResponseEntity( new ServerErrorResponseDto(exception.getMessage(), ErrorCodeEnum.MYSQL_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    @ExceptionHandler(SQLGrammarException.class)
    private ResponseEntity<ServerErrorResponseDto> handleSQLGrammarException(SQLGrammarException exception )

    {
    	return new ResponseEntity( new ServerErrorResponseDto(exception.getMessage(), ErrorCodeEnum.MYSQL_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }*/
    
    
    @ExceptionHandler(SQLException.class)
    private ResponseEntity<ServerErrorResponseDto> handleSQLException(SQLException exception )

    {
    	return new ResponseEntity( new ServerErrorResponseDto(exception.getMessage(), ErrorCodeEnum.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    
    @ExceptionHandler(IdentifierGenerationException.class)
    private ResponseEntity<ServerErrorResponseDto> handleIdentifierGenerationException(IdentifierGenerationException exception )

    {
    	return new ResponseEntity( new ServerErrorResponseDto("No se encontró un identificador en la solcitud", ErrorCodeEnum.ID_MISSING, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    private ServerErrorResponseDto buildSqlResponse(SQLIntegrityConstraintViolationException exception) {
    	return exception.getErrorCode() == 1048 ? new ServerErrorResponseDto("Todos los campos son obligatorios", ErrorCodeEnum.EMPTY_DATA, HttpStatus.BAD_REQUEST) : 
    		new ServerErrorResponseDto("Violacion de restriccion en base de datos", ErrorCodeEnum.CONSTRAINT_VIOLATION, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
