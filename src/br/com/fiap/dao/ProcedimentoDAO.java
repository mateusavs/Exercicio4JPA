package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Procedimento;

public interface ProcedimentoDAO extends GenericDAO<Procedimento, Integer> {
	List<Procedimento> list();
	List<Procedimento> buscarProcedimentoporPaciente(String idPaciente);
}
