package com.adriano.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adriano.eventoapp.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {

}
