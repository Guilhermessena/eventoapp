package com.api.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.eventoapp.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {
	Evento findByCodigo(long codigo);
}
