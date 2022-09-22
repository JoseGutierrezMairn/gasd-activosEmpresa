package com.gasd.prueba.activos.service;

import java.util.Date;
import java.util.List;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.dto.ResponseDto;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.exception.ActivoExistenteException;
import com.gasd.prueba.activos.exception.ActivoNoEncontradoException;

public interface IActivoService {
	
	public List<ActivoDto> getActivoPorTipo(String tipo)throws ActivoNoEncontradoException;
	public List<ActivoDto> getArctivoPorFechaCompra(Date fechaCompra) throws ActivoNoEncontradoException;
	public ActivoDto getActivoPorSerial(Integer serial) throws ActivoNoEncontradoException;
	public ActivoDto createActivo(ActivoDto activo);
	public ActivoDto updateActivo(ActivoDto activo)throws ActivoNoEncontradoException;
	
}
