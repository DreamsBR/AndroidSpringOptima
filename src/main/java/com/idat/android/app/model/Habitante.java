package com.idat.android.app.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "habitantes")
public class Habitante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String nombres;
    @Column(length = 100)
    private String apellidoPaterno;
    @Column(length = 100)
    private String apellidoMaterno;
    @Column(length = 20)
    private String tipoDoc;
    @Column(length = 11)
    private String numDoc;
    @Column(length = 20)
    private String numEdificio;
    @Column(length = 3)
    private String numDepartamento;
    @Column(length = 100)
    private String direccion;
    @Column(length = 100)
    private String distrito;
    @Column(length = 9)
    private String telefono;
    
    private String ccv;
	
	private String fecha_v;
	
	private String n_tarjeta;
    
    @OneToOne
    private DocumentoAlmacenado foto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getNumEdificio() {
		return numEdificio;
	}
	public void setNumEdificio(String numEdificio) {
		this.numEdificio = numEdificio;
	}
	public String getNumDepartamento() {
		return numDepartamento;
	}
	public void setNumDepartamento(String numDepartamento) {
		this.numDepartamento = numDepartamento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public DocumentoAlmacenado getFoto() {
		return foto;
	}
	public void setFoto(DocumentoAlmacenado foto) {
		this.foto = foto;
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
    
    
}
