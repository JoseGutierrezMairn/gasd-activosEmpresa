package com.gasd.prueba.activos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gasd.prueba.activos.entity.ActivoGuardarEntity;

public interface IActivoGuardarRepository extends JpaRepository<ActivoGuardarEntity, Integer>{

}
