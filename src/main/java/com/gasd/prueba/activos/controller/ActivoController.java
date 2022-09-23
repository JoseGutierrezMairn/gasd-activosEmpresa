package com.gasd.prueba.activos.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gasd.prueba.activos.dto.ActivoDto;

import com.gasd.prueba.activos.service.IActivoService;

@RestController
@RequestMapping(path = "/api/v1/activo")
/*
 * Esta clase es el controlador, se encarga de recibir las peticiones http realizadas por un cliente.
 * @author Jose Gutierrez Marin 
 */
public class ActivoController {

	@Autowired
	private IActivoService activoService;
	
	private Logger log = LoggerFactory.getLogger(ActivoController.class);
	
	/*
	 * End point que se encarga de procesar la solicitud de consultar un activo por su tipo.
	 * @param tipo El parámetro tipo indica el tipo de activo que se quiere consultar en la base de datos
	 * @return Una lista con todos los activos que cumplen con el tipo indicado
	 * @throws ActivoNoEncontradoException Dado el tipo no se encontró ningun activo en la base de datos
	 */
	@GetMapping(path = "/porTipo")
	public List<ActivoDto> getActivoPorTipo( @RequestParam String tipo ){
		 return activoService.getActivoPorTipo(tipo);
	}
	
	/*
	 * End point que se encarga de procesar la solicitud de consultar un activo por su fecha de compra.
	 * @param fechaCompra Es la fecha en la cual se compró el activo y por la cual se quiere filtrar la búsqueda en esta solicitud
	 * @return Una lista con todos los activos que cumplen con la fecha de compra indicada
	 * @throws ActivoNoEncontradoException Dada la fecha no se encontró ningun activo en la base de datos
	 */
	@GetMapping(path = "/porFechaCompra")
	public List<ActivoDto> getActivoPorFechaCompra(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra) {
		return activoService.getArctivoPorFechaCompra(fechaCompra);
	}
	
	/*
	 * End point que se encarga de procesar la solicitud de consultar un activo por su serial.
	 * @param serial El parámetro serial indica el serial del activo que se quiere consultar en la base de datos
	 * @return Dto que contiene la información del activo encontrado dado su serial
	 * @throws ActivoNoEncontradoException Dado el tipo no se encontró ningun activo en la base de datos
	 */
	@GetMapping(path = "/porSerial")
	public ActivoDto getActivoPorSerial(  @RequestParam Integer serial ){	
		 return activoService.getActivoPorSerial( serial );
	}
	
	/*
	 * End point que se encarga de procesar la solicitud de crear un nuevo activo.
	 * @param nuevoActivo El parámetro nuevoActivo es el nuevo activo que se quiere almacenar en la base de datos
	 * @return El Dto del activo almacenado satisfactoriamente en la base de datos
	 * @throws SQLIntegrityConstraintViolationException Se violó alguna restricción establecida en la base de datos
	 */
	@PostMapping(path = "/crearActivo", consumes = "application/json", produces = "application/json")
	public ActivoDto createActivo(@RequestBody ActivoDto nuevoActivo) {
		return activoService.createActivo(nuevoActivo);
	}
	
	/*
	 * End point que se encarga de procesar la solicitud de actualizar un activo.
	 * @param activo El parámetro activo es el activo que se quiere actualizar con los campos que se requieran cambiar actualizados
	 * @return El Dto del activo actualizado satisfactoriamente en la base de datos
	 * @throws SQLIntegrityConstraintViolationException Se violó alguna restricción establecida en la base de datos
	 * @throws ActivoNoEncontradoException Dado el activo no se encontró ningun activo en la base de datos
	 */
	@PutMapping(path = "/actualizarActivo", consumes = "application/json", produces = "application/json")
	public ActivoDto updateActivo (@RequestBody ActivoDto activo) {
		return activoService.updateActivo(activo);
	}
	
	
}
