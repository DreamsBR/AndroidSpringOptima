package com.idat.android.app.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservas_zonas")
public class ReservasZonas implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String habitante;
	@Column
	private String celular;
	@Column
	private String motivo;
	@Column
	private String zona_comun;
	@Column
	private String fecha;
	@Column
	private String hora;
	@Column
	private String fotoReserva="https://raw.githubusercontent.com/Jostin16/fantastic-journey/master/reserva.png";
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHabitante() {
		return habitante;
	}
	public void setHabitante(String habitante) {
		this.habitante = habitante;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getZona_comun() {
		return zona_comun;
	}
	public void setZona_comun(String zona_comun) {
		this.zona_comun = zona_comun;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFotoReserva() {
		return fotoReserva;
	}
	public void setFotoReserva(String fotoReserva) {
		this.fotoReserva = fotoReserva;
	}
	
	
}
