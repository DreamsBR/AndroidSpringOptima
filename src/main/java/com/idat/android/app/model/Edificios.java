package com.idat.android.app.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "edificios")
public class Edificios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_edificios;
	@Column(nullable = false, length = 45)
	private String nombre_edificio;
	@Column(nullable = false, length = 45)
	private String direccion;
	
	@JsonBackReference(value = "listaDepa")
	@OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Departamentos> listaDepartamentos;
	

	public Edificios() {
		// TODO Auto-generated constructor stub
	}


	public Edificios(Integer id_edificios, String nombre_edificios, String direccion) {
		super();
		this.id_edificios = id_edificios;
		this.nombre_edificio = nombre_edificios;
		this.direccion = direccion;
	}


	public Integer getId_edificios() {
		return id_edificios;
	}


	public void setId_edificios(Integer id_edificios) {
		this.id_edificios = id_edificios;
	}


	public String getNombre_edificios() {
		return nombre_edificio;
	}

	public void setNombre_edificios(String nombre_edificios) {
		this.nombre_edificio = nombre_edificios;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Departamentos> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
}
