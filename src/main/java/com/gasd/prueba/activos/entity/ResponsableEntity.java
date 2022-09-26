package com.gasd.prueba.activos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsable")
public class ResponsableEntity {
	
	@Id
	@Column(name = "serial_activo")
	private Integer serialActivo;
	
	@Column(name = "id_persona")
	private Integer idPersona;
	
	@Column(name = "id_area")
	private Integer idArea;


	public ResponsableEntity() {  } 

	public ResponsableEntity(Integer serialActivo, Integer idPersona, Integer idArea) {
		this.serialActivo = serialActivo;
		this.idPersona = idPersona;
		this.idArea = idArea;
	}

	public Integer getSerialActivo() {
		return serialActivo;
	}

	public void setSerialActivo(Integer serialActivo) {
		this.serialActivo = serialActivo;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	
	
	
	
	
	
}
