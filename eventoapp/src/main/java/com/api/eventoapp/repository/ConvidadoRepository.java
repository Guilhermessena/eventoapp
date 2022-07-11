package com.api.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.eventoapp.model.Convidado;
import com.api.eventoapp.model.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento); 
	Convidado findByRg(String rg);
}
