package com.idat.android.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.android.app.dao.ReservasZonasDao;
import com.idat.android.app.model.ReservasZonas;

@Service
@Transactional
public class ReservasZonasService {
	
	@Autowired
	private ReservasZonasDao dao;
	
	public List<ReservasZonas> listar(){
		return (List<ReservasZonas>) dao.findAll();
	}
	
	
	public ReservasZonas save(ReservasZonas reservasZonas) {
		return dao.save(reservasZonas);
	}
	

}
