package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Agenda;

public interface AgendaDAO extends GenericDAO<Agenda, Integer> {
	
	List<Agenda> list();
}
