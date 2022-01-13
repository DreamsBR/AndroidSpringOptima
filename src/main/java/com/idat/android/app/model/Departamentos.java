package com.idat.android.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamentos")
public class Departamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_departamento ;
	@Column(nullable = false,length = 45)
	private String descripcion;
	@Column(nullable = false)
	private Double precio;
	@Column(nullable = false,length = 45)
	private String estado;
	@Column(length = 100)
	private String foto;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "id_edificios", nullable = false,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_edificios) references edificios(id_edificios)"))
	private Edificios edificio;
	

	
	public Departamentos() {
		// TODO Auto-generated constructor stub
	}

	public Departamentos(Integer id_departamento, String descripcion, String estado,String foto) {
		super();
		this.id_departamento = id_departamento;
		this.descripcion = descripcion;
		this.estado = estado;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Departamentos [id_departamento=" + id_departamento + ", descripcion=" + descripcion + ", precio="
				+ precio + ", estado=" + estado + ", foto=" + foto + ", edificio=" + edificio + "]";
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Edificios getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificios edificio) {
		this.edificio = edificio;
	}

	

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}