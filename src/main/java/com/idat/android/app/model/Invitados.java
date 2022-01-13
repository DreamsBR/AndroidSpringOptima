package com.idat.android.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "invitados")
public class Invitados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_invitados;
	@Column(nullable = false,length = 200)
	private String nombre;
	@Column(nullable = false,length = 200)
	private String apellidos;
	@Column(nullable = false)
	private String fecha_ingreso; 
	@Column(nullable = false,length = 200)
	private String autoriza;
	@Column(nullable = false)
	private Integer num_depa;
	@Column(nullable = false)
	private String num_edi;
	@Column()
	private String urlFoto="https://raw.githubusercontent.com/Jostin16/fantastic-journey/master/user.PNG";
	
	
	public Invitados() {
		// TODO Auto-generated constructor stub
	}



	public Invitados(Integer id_invitados, String nombre, String apellidos, String fecha_ingreso, String autoriza,
			Integer num_depa, String num_edi, String urlFoto) {
		super();
		this.id_invitados = id_invitados;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_ingreso = fecha_ingreso;
		this.autoriza = autoriza;
		this.num_depa = num_depa;
		this.urlFoto = urlFoto;
		this.num_edi = num_edi;
	}



	public Integer getId_invitados() {
		return id_invitados;
	}

	public void setId_invitados(Integer id_invitados) {
		this.id_invitados = id_invitados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}



	public String getAutoriza() {
		return autoriza;
	}



	public void setAutoriza(String autoriza) {
		this.autoriza = autoriza;
	}



	public Integer getNum_depa() {
		return num_depa;
	}



	public void setNum_depa(Integer num_depa) {
		this.num_depa = num_depa;
	}


	public String getNum_edi() {
		return num_edi;
	}



	public void setNum_edi(String num_edi) {
		this.num_edi = num_edi;
	}



	public String getUrlFoto() {
		return urlFoto;
	}



	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
}
