package com.gasd.prueba.activos.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.entity.ActivoGuardarEntity;
import com.gasd.prueba.activos.entity.ResponsableEntity;
import com.gasd.prueba.activos.exception.ActivoExistenteException;
import com.gasd.prueba.activos.exception.ActivoNoEncontradoException;
import com.gasd.prueba.activos.exception.SerialActivoObligatorioException;
import com.gasd.prueba.activos.mapper.IActivoMapper;
import com.gasd.prueba.activos.repository.IActivoGuardarRepository;
import com.gasd.prueba.activos.repository.IActivoRepository;
import com.gasd.prueba.activos.repository.IResponsableRepository;
import com.gasd.prueba.activos.service.IActivoService;

/*
 * Esta clase es el servicio, se encarga de llevar a cabo la logica de las solicitudes del cliente..
 * @author Jose Gutierrez Marin 
 */
@Service
public class ActivoService implements IActivoService {

	
	@Autowired
	private IActivoRepository repository;
	
	@Autowired
	private IActivoGuardarRepository guardarRepo;
	
	@Autowired
	private IResponsableRepository responsableRepo;
	
	@Autowired
	private IActivoMapper mapper;
	
	private Logger log = LoggerFactory.getLogger(ActivoService.class);
	
	
	/*
	 * Realiza la consulta en la base de datos según el tipo de activo especificado
	 * @param tipo El parámetro tipo indica el tipo de activo que se quiere consultar en la base de datos
	 * @return Una lista con todos los activos que cumplen con el tipo indicado
	 * @throws ActivoNoEncontradoException Dado el tipo no se encontró ningun activo en la base de datos
	 */
	@Override
	public List<ActivoDto> getActivoPorTipo(String tipo) {
		log.info("Ejecutando consulta a base de datos");
		List<ActivoEntity> answ = repository.findByTipo(tipo);
		if(!(answ.size() > 0)) {throw new ActivoNoEncontradoException();}
		
		return mapper.listEntityToDto(answ) ;
	}

	
	/*
	 * Realiza la consulta en la base de datos según la fecha de compra del activo
	 * @param fechaCompra Es la fecha en la cual se compró el activo y por la cual se quiere filtrar la búsqueda en esta solicitud
	 * @return Una lista con todos los activos que cumplen con la fecha de compra indicada
	 * @throws ActivoNoEncontradoException Dada la fecha no se encontró ningun activo en la base de datos
	 */
	@Override
	public List<ActivoDto> getArctivoPorFechaCompra(Date fechaCompra) {
		log.info("Ejecutando consulta a base de datos");
		List<ActivoEntity> answ = repository.findByFechaCompra(fechaCompra);
		if(!(answ.size() > 0)) {throw new ActivoNoEncontradoException();}
		return mapper.listEntityToDto(answ);
	}
	
	/*
	 * Realiza la consulta en la base de datos según el serial especificado
	 * @param serial El parámetro serial indica el serial del activo que se quiere consultar en la base de datos
	 * @return Dto que contiene la información del activo encontrado dado su serial
	 * @throws ActivoNoEncontradoException Dado el tipo no se encontró ningun activo en la base de datos
	 */
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

	
	/*
	 * Realiza la petición de almacenar un nuevo activo a la base de datos
	 * @param nuevoActivo El parámetro nuevoActivo es el nuevo activo que se quiere almacenar en la base de datos
	 * @return El Dto del activo almacenado satisfactoriamente en la base de datos
	 * @throws SQLIntegrityConstraintViolationException Se violó alguna restricción establecida en la base de datos
	 */
	@Override
	public ActivoDto createActivo(ActivoDto activo) {
		log.info("Ejecutando consulta a base de datos");
		return mapper.guardarEntityToDto(guardarRepo.save(mapper.dtoToGuardarEntity(activo)));
	}

	
	/*
	 * Realiza la petición de actualizar un activo a la base de datos
	 * @param activo El parámetro activo es el activo que se quiere actualizar con los campos que se requieran cambiar actualizados
	 * @return El Dto del activo actualizado satisfactoriamente en la base de datos
	 * @throws SQLIntegrityConstraintViolationException Se violó alguna restricción establecida en la base de datos
	 * @throws ActivoNoEncontradoException Dado el activo no se encontró ningun activo en la base de datos
	 */
	@Override
	public ActivoDto updateActivo(ActivoDto activo) {
		ActivoEntity entity = existeActivo(activo.getSerial());
		if( !(entity != null) )  { 
			if( activo.getSerial() != null ) { throw new ActivoNoEncontradoException(); }
			throw new SerialActivoObligatorioException();
			}
		activo = actualizarData(activo, entity);
		log.info("Ejecutando consulta a base de datos");
		guardarRepo.save( mapper.dtoToGuardarEntity( activo)  );
		System.out.println("hola k ase");
		if( activo.getSerialActivo() != null && activo.getSerialActivo() == activo.getSerial()) {
			ResponsableEntity responsable = responsableRepo.save(mapper.dtoToResponsableEntity(activo));
			activo.setIdPersona( responsable.getIdPersona() );
			activo.setIdArea( responsable.getIdArea() );
			activo.setSerialActivo( responsable.getSerialActivo() );
		}
		return activo;
	}
	
	/*
	 * Realiza consulta en la base de datos para validar si un activo existe
	 * @param serial El serial del activo del cual se quiere validar su exsitencia
	 * @return Entidad si la entidad no existe retorna null
	 */
	private ActivoEntity existeActivo(Integer serial)  {
		log.info("Validando existencia de activo");
		return repository.findBySerial(serial);
	}
	
	
	
	/*
	 * Se encarga de mapear la información valida de una entidad a un dto
	 * @param dto el dto del que se quiere mapear la información
	 * @param entity la entidad a la que se quiere mapear la información del dto
	 * @return  el dto con los datos ya mapeados
	 */
	private ActivoDto actualizarData(ActivoDto dto, ActivoEntity entity) {
		log.info("Actualizando data de entidad");
		dto.setNombre( dto.getNombre() != null ? dto.getNombre() : entity.getNombre() );
		dto.setDescripcion( dto.getDescripcion() != null ? dto.getDescripcion() : entity.getDescripcion() );
		dto.setTipo( dto.getTipo() != null ? dto.getTipo() : entity.getTipo() );
		dto.setNumIntInventario( dto.getNumIntInventario() != null ? dto.getNumIntInventario() : entity.getNumIntInventario() );
		dto.setPeso( dto.getPeso() != null ? dto.getPeso() : entity.getPeso() );
		dto.setAlto( dto.getAlto() != null ? dto.getAlto() : entity.getAlto() );
		dto.setAncho( dto.getAncho() != null ? dto.getAncho() : entity.getAncho() );
		dto.setValorCompra( dto.getValorCompra() != null ? dto.getValorCompra() : entity.getValorCompra() );
		dto.setFechaCompra( dto.getFechaCompra() != null ? dto.getFechaCompra() : entity.getFechaCompra() );
		
		return dto;
	}


}
