package com.gasd.prueba.activos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gasd.prueba.activos.entity.ActivoEntity;


public interface IActivoRepository extends JpaRepository<ActivoEntity, Integer> {
	
	public ActivoEntity findBySerial(@Param("serial")Integer serial);
	public List<ActivoEntity> findByTipo(@Param("tipo")String tipo);
	public List<ActivoEntity> findByFechaCompra(@Param("fecha_compra") Date fechaCompra);
	
}
