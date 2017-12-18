package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.MatMed;

public interface MatMedDAO extends GenericDAO<MatMed, Integer> {
	
	List<MatMed> list();
	List<MatMed> buscarMaterialporPaciente(String idPaciente);
}
