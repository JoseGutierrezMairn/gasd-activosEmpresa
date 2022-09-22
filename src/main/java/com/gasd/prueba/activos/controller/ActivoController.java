package com.gasd.prueba.activos.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.dto.ResponseDto;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.exception.ActivoNoEncontradoException;
import com.gasd.prueba.activos.service.IActivoService;

@RestController
@RequestMapping(path = "/api/v1/activo")
public class ActivoController {

	@Autowired
	private IActivoService activoService;
	
	private Logger log = LoggerFactory.getLogger(ActivoController.class);
	
	@GetMapping(path = "/porTipo")
	public List<ActivoDto> getActivoPorTipo( @RequestParam String tipo ){
		 return activoService.getActivoPorTipo(tipo);
	}
	
	
	@GetMapping(path = "/porFechaCompra")
	public List<ActivoDto> getActivoPorFechaCompra(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra) {
		return activoService.getArctivoPorFechaCompra(fechaCompra);
	}
	
	@GetMapping(path = "/porSerial")
	public ActivoDto getActivoPorSerial(  @RequestParam Integer serial ){	
		 return activoService.getActivoPorSerial( serial );
	}
	
	
	@PostMapping(path = "/crearActivo", consumes = "application/json", produces = "application/json")
	public ActivoDto createActivo(@RequestBody ActivoDto nuevoActivo) {
		return activoService.createActivo(nuevoActivo);
	}
	
	@PutMapping(path = "/actualizarActivo", consumes = "application/json", produces = "application/json")
	public ActivoDto updateActivo (@RequestBody ActivoDto activo) {
		return activoService.updateActivo(activo);
	}
	
	
}
