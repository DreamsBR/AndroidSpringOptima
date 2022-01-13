package com.idat.android.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.android.app.model.Pago;

@Repository
public interface PagoDao extends CrudRepository<Pago, Integer> {
	
	@Query(value = "select p.id_pago, p.habitante, p.ccv, p.fecha_v, p.n_tarjeta, p.dni, p.celular, p.num_edi, p.num_depa, p.tipo_pago, p.monto_pagar from pagos p join habitantes h on p.num_depa=h.num_departamento where p.num_depa=:num_depa and p.num_edi=:num_edi", nativeQuery = true)
	public List<Pago> filtrarPago(Integer num_depa, String num_edi);
	
}
