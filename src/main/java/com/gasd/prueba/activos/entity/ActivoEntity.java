package com.gasd.prueba.activos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "activo")
public class ActivoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serial")
	private Integer serial;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="num_int_inventario")
	private Integer numIntInventario;
	
	@Column(name="peso")
	private double peso;
	
	@Column(name="alto")
	private double alto;
	
	@Column(name="ancho")
	private double ancho;
	
	@Column(name="valor_compra")
	private Integer valorCompra;
	
	@Column(name = "fecha_compra")
	@Temporal(TemporalType.DATE)
	private Date fechaCompra;

	
	public ActivoEntity() {}


	public ActivoEntity(Integer serial, String nombre, String descripcion, String tipo, Integer numIntInventario,
			double peso, double alto, double ancho, Integer valorCompra, Date fechaCompra) {
		this.serial = serial;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.numIntInventario = numIntInventario;
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.valorCompra = valorCompra;
		this.fechaCompra = fechaCompra;
	}


	public Integer getSerial() {
		return serial;
	}




	public void setSerial(Integer serial) {
		this.serial = serial;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public Integer getNumIntInventario() {
		return numIntInventario;
	}




	public void setNumIntInventario(Integer numIntInventario) {
		this.numIntInventario = numIntInventario;
	}




	public double getPeso() {
		return peso;
	}




	public void setPeso(double peso) {
		this.peso = peso;
	}




	public double getAlto() {
		return alto;
	}




	public void setAlto(double alto) {
		this.alto = alto;
	}




	public double getAncho() {
		return ancho;
	}




	public void setAncho(double ancho) {
		this.ancho = ancho;
	}




	public Integer getValorCompra() {
		return valorCompra;
	}




	public void setValorCompra(Integer valorCompra) {
		this.valorCompra = valorCompra;
	}




	public Date getFechaCompra() {
		return fechaCompra;
	}




	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	
	
	
	
	
}
