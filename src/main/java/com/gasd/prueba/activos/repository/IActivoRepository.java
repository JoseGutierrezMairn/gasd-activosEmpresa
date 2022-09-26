package com.gasd.prueba.activos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gasd.prueba.activos.entity.ActivoEntity;


public interface IActivoRepository extends JpaRepository<ActivoEntity, Integer> {
	
	
	@Query(nativeQuery = true, value = "select *  from activo left join responsable on ( activo.serial = responsable.serial_activo  ) where activo.serial = :serial")
	public ActivoEntity findBySerial(@Param("serial")Integer serial);
	
	@Query(nativeQuery = true, value = "select *  from activo left join responsable on ( activo.serial = responsable.serial_activo  ) where activo.tipo = :tipo")
	public List<ActivoEntity> findByTipo(@Param("tipo")String tipo);
	
	@Query(nativeQuery = true, value = "select *  from activo left join responsable on ( activo.serial = responsable.serial_activo  ) where activo.fecha_compra = :fecha_compra")
	public List<ActivoEntity> findByFechaCompra(@Param("fecha_compra") Date fechaCompra);
	
}
