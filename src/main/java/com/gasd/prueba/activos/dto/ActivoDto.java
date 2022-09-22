package com.gasd.prueba.activos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


public class ActivoDto {

	private Integer serial;

	private String nombre;
	
	private String descripcion;

	private String tipo;
	
	private Integer numIntInventario;

	private double peso;
	
	private double alto;
	
	private double ancho;
	
	private Integer valorCompra;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-dd-MM")
	private Date fechaCompra;

	public ActivoDto() {	}

	public ActivoDto(Integer serial, String nombre, String descripcion, String tipo, Integer numIntInventario,
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
