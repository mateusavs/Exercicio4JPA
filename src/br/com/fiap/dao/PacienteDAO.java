package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Paciente;

public interface PacienteDAO extends GenericDAO<Paciente, Integer> {
	List<Paciente>list();
	
}
