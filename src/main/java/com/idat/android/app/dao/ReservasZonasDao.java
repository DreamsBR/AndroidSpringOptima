package com.idat.android.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idat.android.app.model.ReservasZonas;

@Repository
public interface ReservasZonasDao extends CrudRepository<ReservasZonas, Integer> {

}
