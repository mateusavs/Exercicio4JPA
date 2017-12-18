package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Paciente;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO {

	public PacienteDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Paciente> list() {
		TypedQuery<Paciente> query = em.createQuery("from Paciente p",Paciente.class);
		return query.getResultList();
	}

	
	

}
