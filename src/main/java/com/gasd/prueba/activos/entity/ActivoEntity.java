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

/*
 * Esta clase es entidad de los datos almacenados en la base de datos
 * @author Jose Gutierrez Marin 
 */
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


	/*
	 * Metodo que retorna el valor del serial
	 * @return El valor del serial del activo
	 */
	public Integer getSerial() {
		return serial;
	}




	/*
	 * Metodo que cambia el valor del serial
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}



	/*
	 * Metodo que retorna el valor del nombre del activo
	 * @return El valor del nombre del activo
	 */
	public String getNombre() {
		return nombre;
	}



	/*
	 * Metodo que cambia el valor del nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/*
	 * Metodo que retorna el valor de la descripcion
	 * @return El valor de la descripcion del activo
	 */
	public String getDescripcion() {
		return descripcion;
	}



	/*
	 * Metodo que cambia el valor de la descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/*
	 * Metodo que retorna el valor del tipo
	 * @return El valor del tipo del activo
	 */
	public String getTipo() {
		return tipo;
	}



	/*
	 * Metodo que cambia el valor del tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	/*
	 * Metodo que retorna el valor del numero interno de inventario
	 * @return El valor del numero interno de inventario del activo
	 */
	public Integer getNumIntInventario() {
		return numIntInventario;
	}



	/*
	 * Metodo que cambia el valor del numero interno de inventario
	 */
	public void setNumIntInventario(Integer numIntInventario) {
		this.numIntInventario = numIntInventario;
	}



	/*
	 * Metodo que retorna el valor del peso
	 * @return El valor del peso del activo
	 */
	public double getPeso() {
		return peso;
	}



	/*
	 * Metodo que cambia el valor del peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}



	/*
	 * Metodo que retorna el valor del alto del activo
	 * @return El valor del alto del activo
	 */
	public double getAlto() {
		return alto;
	}



	/*
	 * Metodo que cambia el valor del alto
	 */
	public void setAlto(double alto) {
		this.alto = alto;
	}



	/*
	 * Metodo que retorna el valor del ancho del activo
	 * @return El valor del ancho del activo
	 */
	public double getAncho() {
		return ancho;
	}



	/*
	 * Metodo que cambia el valor del ancho
	 */
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}



	/*
	 * Metodo que retorna el valor del valor de compra
	 * @return El valor del valor de compra del activo
	 */
	public Integer getValorCompra() {
		return valorCompra;
	}



	/*
	 * Metodo que cambia el valor del valor de compra
	 */
	public void setValorCompra(Integer valorCompra) {
		this.valorCompra = valorCompra;
	}



	/*
	 * Metodo que retorna el valor de la fecha de compra
	 * @return El valor de la fecha de compra del activo
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}



	/*
	 * Metodo que cambia el valor de la fecha de compra del activo
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	
	
	
	
	
}
