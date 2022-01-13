package com.idat.android.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.idat.android.app.dao.InvitadosDao;
import com.idat.android.app.model.Invitados;

@Service
@Transactional
public class InvitadosService {

	@Autowired
	private InvitadosDao dao;
	
	public List<Invitados> findAll(){
		return (List<Invitados>) dao.findAll();
	}
	
	public List<Invitados> findFiltrar(int num_depa,String num_edi){
		return (List<Invitados>) dao.filtrarInvitados(num_depa,num_edi);
	}
	
	public Optional<Invitados> findById(Integer id){
		return dao.findById(id);
	}
	
	public Invitados insert(Invitados invitado) {
		return dao.save(invitado);
	}
	
	public Invitados update(Invitados invitado) {
		Invitados actualInvitado = dao.findById(invitado.getId_invitados()).get();
		actualInvitado.setApellidos(invitado.getApellidos());
		actualInvitado.setAutoriza(invitado.getAutoriza());
		actualInvitado.setNombre(invitado.getNombre());
		actualInvitado.setNum_depa(invitado.getNum_depa());
		actualInvitado.setFecha_ingreso(invitado.getFecha_ingreso());
		actualInvitado.setNum_edi(invitado.getNum_edi());
		actualInvitado.setUrlFoto(invitado.getUrlFoto());

		return dao.save(actualInvitado);
	}
	
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}
