package com.idat.android.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.android.app.model.Invitados;

@Repository
public interface InvitadosDao extends CrudRepository<Invitados, Integer> {

	@Query(value = "select i.id_invitados, i.nombre, i.apellidos, i.fecha_ingreso, i.autoriza, i.num_depa, i.url_foto, i.num_edi from invitados i join habitantes h on i.num_depa=h.num_departamento where i.num_depa=:num_depa and i.num_edi=:num_edi", nativeQuery = true)
	public List<Invitados> filtrarInvitados(Integer num_depa, String num_edi);
	
}
