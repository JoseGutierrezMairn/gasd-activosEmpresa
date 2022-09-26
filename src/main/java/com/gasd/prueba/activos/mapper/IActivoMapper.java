package com.gasd.prueba.activos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.entity.ActivoEntity;
import com.gasd.prueba.activos.entity.ActivoGuardarEntity;
import com.gasd.prueba.activos.entity.ResponsableEntity;

@Mapper(componentModel = "spring")
public interface IActivoMapper {
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "num_int_inventario", target = "numIntInventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valor_compra", target = "valorCompra"), @Mapping(source = "fecha_compra", target = "fechaCompra"), @Mapping(source = "id_persona", target = "idPersona"), @Mapping(source = "id_area", target = "idArea"), @Mapping(source = "serial_activo", target = "serialActivo")})                                                                     
	public List<ActivoDto> listEntityToDto(List<ActivoEntity> listEntity);
	
	public ActivoDto entityToDto(ActivoEntity entity);
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "numIntInventario", target = "num_int_inventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valorCompra", target = "valor_compra"), @Mapping(source = "fechaCompra", target = "fecha_compra"), @Mapping(source = "idPersona", target = "id_persona"), @Mapping(source = "idArea", target = "id_area"), @Mapping(source = "serialActivo", target = "serial_activo")})
	public List<ActivoEntity> listDtoToEntity(List<ActivoDto> listDto);
	
	public ActivoEntity dtoToEntity(ActivoDto dto);
	
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "num_int_inventario", target = "numIntInventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valor_compra", target = "valorCompra"), @Mapping(source = "fecha_compra", target = "fechaCompra")})                                                                     
	public List<ActivoDto> listGuardarEntityToDto(List<ActivoGuardarEntity> listGuardarEntity);
	
	public ActivoDto guardarEntityToDto(ActivoGuardarEntity guardarEntity);
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "numIntInventario", target = "num_int_inventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valorCompra", target = "valor_compra"), @Mapping(source = "fechaCompra", target = "fecha_compra")})
	public List<ActivoGuardarEntity> listDtoToGuardarEntity(List<ActivoDto> listDto);
	
	public ActivoGuardarEntity dtoToGuardarEntity(ActivoDto dto);
	
	
	@Mappings({ @Mapping(source = "idPersona", target = "id_persona"), @Mapping(source = "idArea", target = "id_area"), @Mapping(source = "serialActivo", target = "serial_activo")})
	public List<ResponsableEntity> listDtoToResponsableEntity(List<ActivoDto> listDto);
	
	public ResponsableEntity dtoToResponsableEntity(ActivoDto dto);
	
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "num_int_inventario", target = "num_int_inventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valor_compra", target = "valor_compra"), @Mapping(source = "fecha_compra", target = "fecha_compra")})                                                                     
	public List<ActivoGuardarEntity> listEntityToGuardarEntity(List<ActivoEntity> listEntity);
	
	public ActivoGuardarEntity entityToGuardarEntity(ActivoEntity entity);
	
	
}
