package com.gasd.prueba.activos.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.dto.ResponseDto;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.exception.ActivoExistenteException;
import com.gasd.prueba.activos.exception.ActivoNoEncontradoException;
import com.gasd.prueba.activos.mapper.IActivoMapper;
import com.gasd.prueba.activos.repository.IActivoRepository;
import com.gasd.prueba.activos.service.IActivoService;

@Service
public class ActivoService implements IActivoService {

	
	@Autowired
	private IActivoRepository repository;
	
	@Autowired
	private IActivoMapper mapper;
	
	private Logger log = LoggerFactory.getLogger(ActivoService.class);
	
	@Override
	public List<ActivoDto> getActivoPorTipo(String tipo) {
		log.info("Ejecutando consulta a base de datos");
		List<ActivoEntity> answ = repository.findByTipo(tipo);
		if(!(answ.size() > 0)) {throw new ActivoNoEncontradoException();}
		
		return mapper.listEntityToDto(answ) ;
	}

	@Override
	public List<ActivoDto> getArctivoPorFechaCompra(Date fechaCompra) {
		log.info("Ejecutando consulta a base de datos");
		List<ActivoEntity> answ = repository.findByFechaCompra(fechaCompra);
		return mapper.listEntityToDto(answ);
	}

	@Override
	public ActivoDto getActivoPorSerial( Integer serial ) {
		log.info("Ejecutando consulta a base de datos");
		ActivoEntity answ = repository.findBySerial(serial);
		if( answ != null) {
			return mapper.entityToDto(answ) ;
			}else {
				throw new ActivoNoEncontradoException();
			}
		
	}

	@Override
	public ActivoDto createActivo(ActivoDto activo) {
		return mapper.entityToDto(repository.save(mapper.dtoToEntity(activo)));
	}

	@Override
	public ActivoDto updateActivo(ActivoDto activo) {
		if( ! existeActivo(activo.getSerial()) ) { throw new ActivoNoEncontradoException() ;}
		return mapper.entityToDto( repository.save(mapper.dtoToEntity(activo)) );
	}
	
	
	private boolean existeActivo(Integer serial)  {
		//ActivoEntity response = repository.findBySerial(activo.getSerial());
		return repository.findBySerial(serial) != null;
	}


}
