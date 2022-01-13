package com.idat.android.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.android.app.dao.PagoDao;
import com.idat.android.app.model.Pago;

@Service
@Transactional
public class PagoService {

	@Autowired
	private PagoDao dao;
	
	public List<Pago> listar(){
		return (List<Pago>) dao.findAll();
	}
	
	public Pago save(Pago pago) {
		return dao.save(pago);
	}
	
	public List<Pago> findFiltrar(int num_depa,String num_edi){
		return (List<Pago>) dao.filtrarPago(num_depa,num_edi);
	}
	
}
