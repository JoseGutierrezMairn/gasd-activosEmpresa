package com.gasd.prueba.activos;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.error.ErrorCodeEnum;
import com.gasd.prueba.activos.exception.ActivoNoEncontradoException;
import com.gasd.prueba.activos.repository.IActivoRepository;
import com.gasd.prueba.activos.service.impl.ActivoService;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class ActivosApplicationTests {
	
	@MockBean
	private IActivoRepository activoRepository;
	
	@Autowired
	private ActivoService activoService;
	
	private ActivoEntity activo;
	
		

	
	@Test
	void findBySerial() {
		activo = new ActivoEntity(1, "Escritorio", "Escritorio de cocobolo", "a", 5, 50.0, 60, 30, 1000000, new Date());
		when(activoRepository.findBySerial(any(Integer.class) ) )
		.thenReturn(activo);
		Assertions.assertNotNull(activoService.getActivoPorSerial(1));
		Assertions.assertEquals(activoService.getActivoPorSerial(1).getSerial()
				, activo.getSerial());
	}
	
	@Test
	void findByTipo() {
		activo = new ActivoEntity(1, "Escritorio", "Escritorio de cocobolo", "a", 5, 50.0, 60, 30, 1000000, new Date());
		when(activoRepository.findByTipo(any(String.class) ) )
		.thenReturn(Arrays.asList(activo));
		Assertions.assertNotNull(activoService.getActivoPorTipo("a"));
		Assertions.assertTrue(activoService.getActivoPorTipo("a").size() == 1);
		Assertions.assertEquals(activoService.getActivoPorTipo("a").get(0).getNombre(), activo.getNombre());
		Assertions.assertEquals(activoService.getActivoPorTipo("a").get(0).getDescripcion(), activo.getDescripcion());
	}
	
	@Test
	void findByFechaCompra() {
		activo = new ActivoEntity(1, "Escritorio", "Escritorio de cocobolo", "a", 5, 50.0, 60, 30, 1000000, new Date());
		when(activoRepository.findByFechaCompra(any(Date.class) ) )
		.thenReturn(Arrays.asList(activo));
		Assertions.assertNotNull(activoService.getArctivoPorFechaCompra(new Date()));
		Assertions.assertTrue(activoService.getArctivoPorFechaCompra(new Date()).size() == 1);
		Assertions.assertEquals(activoService.getArctivoPorFechaCompra(new Date()).get(0).getNombre(), activo.getNombre());
		Assertions.assertEquals(activoService.getArctivoPorFechaCompra(new Date()).get(0).getDescripcion(), activo.getDescripcion());
	}
	
	@Test
	void findByTipoThrowsExceptionAssetNotFound(){
		ActivoNoEncontradoException excepcion = null;
		when(activoRepository.findByTipo(any(String.class) ) )
		.thenReturn(Arrays.asList());
		try {
			activoService.getActivoPorTipo("a");
		} catch (ActivoNoEncontradoException e) {
			excepcion = e;
		}
		Assertions.assertNotNull(excepcion);
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getMessage(), "El activo no fue encontrado");
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getHttpStatus(), HttpStatus.NOT_FOUND.value());
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getErrorCode(), ErrorCodeEnum.ASSET_NOT_FOUND);
	}
	
	
	@Test
	void findByFechaCompraThrowsExceptionAssetNotFound(){
		ActivoNoEncontradoException excepcion = null;
		when(activoRepository.findByFechaCompra(any(Date.class) ) )
		.thenReturn(Arrays.asList());
		try {
			activoService.getArctivoPorFechaCompra(new Date());
		} catch (ActivoNoEncontradoException e) {
			excepcion = e;
		}
		Assertions.assertNotNull(excepcion);
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getMessage(), "El activo no fue encontrado");
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getHttpStatus(), HttpStatus.NOT_FOUND.value());
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getErrorCode(), ErrorCodeEnum.ASSET_NOT_FOUND);
	}
	
	
	@Test
	void findBySerialThrowsExceptionAssetNotFound(){
		ActivoNoEncontradoException excepcion = null;
		when(activoRepository.findBySerial(any(Integer.class) ) )
		.thenReturn(null);
		try {
			activoService.getActivoPorSerial(1);
		} catch (ActivoNoEncontradoException e) {
			excepcion = e;
		}
		Assertions.assertNotNull(excepcion);
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getMessage(), "El activo no fue encontrado");
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getHttpStatus(), HttpStatus.NOT_FOUND.value());
		Assertions.assertEquals(excepcion.getServerErrorResponseDto().getErrorCode(), ErrorCodeEnum.ASSET_NOT_FOUND);
	}
}
