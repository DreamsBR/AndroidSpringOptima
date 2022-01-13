package com.idat.android.app.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id_pago;
	
	private String habitante;
	
	private String ccv;
	
	private String fecha_v;
	
	private String n_tarjeta;
	
	private String dni;
	
	private String celular;
	
	private String num_depa;
	
	private String num_edi;
	
	private String tipo_pago;
	
	private Double monto_pagar;

	public Integer getId_pago() {
		return id_pago;
	}

	public void setId_pago(Integer id_pago) {
		this.id_pago = id_pago;
	}

	public String getHabitante() {
		return habitante;
	}

	public void setHabitante(String habitante) {
		this.habitante = habitante;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public String getFecha_v() {
		return fecha_v;
	}

	public void setFecha_v(String fecha_v) {
		this.fecha_v = fecha_v;
	}

	public String getN_tarjeta() {
		return n_tarjeta;
	}

	public void setN_tarjeta(String n_tarjeta) {
		this.n_tarjeta = n_tarjeta;
	}

	public Double getMonto_pagar() {
		return monto_pagar;
	}


	public void setMonto_pagar(Double monto_pagar) {
		this.monto_pagar = monto_pagar;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNum_depa() {
		return num_depa;
	}

	public void setNum_depa(String num_depa) {
		this.num_depa = num_depa;
	}

	public String getNum_edi() {
		return num_edi;
	}

	public void setNum_edi(String num_edi) {
		this.num_edi = num_edi;
	}

	public String getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}
	
	
}
