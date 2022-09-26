package com.gasd.prueba.activos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gasd.prueba.activos.entity.ResponsableEntity;

public interface IResponsableRepository extends JpaRepository<ResponsableEntity, Integer>{

}
