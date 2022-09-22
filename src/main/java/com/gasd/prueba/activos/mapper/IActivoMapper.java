package com.gasd.prueba.activos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gasd.prueba.activos.dto.ActivoDto;
import com.gasd.prueba.activos.entity.ActivoEntity;

@Mapper(componentModel = "spring")
public interface IActivoMapper {
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "num_int_inventario", target = "numIntInventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valor_compra", target = "valorCompra"), @Mapping(source = "fecha_compra", target = "fechaCompra")})
	public List<ActivoDto> listEntityToDto(List<ActivoEntity> listEntity);
	
	public ActivoDto entityToDto(ActivoEntity entity);
	
	
	@Mappings({@Mapping(source = "serial", target = "serial"), @Mapping(source = "nombre", target = "nombre"), @Mapping(source = "descripcion", target = "descripcion"), @Mapping(source = "tipo", target = "tipo"), @Mapping(source = "numIntInventario", target = "num_int_inventario"), @Mapping(source = "peso", target = "peso"), @Mapping(source = "alto", target = "alto"), @Mapping(source = "ancho", target = "ancho"), @Mapping(source = "valorCompra", target = "valor_compra"), @Mapping(source = "fechaCompra", target = "fecha_compra")})
	public List<ActivoEntity> listDtoToEntity(List<ActivoDto> listDto);
	
	public ActivoEntity dtoToEntity(ActivoDto dto);
}
