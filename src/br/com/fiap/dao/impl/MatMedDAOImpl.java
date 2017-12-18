package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.MatMedDAO;
import br.com.fiap.entity.MatMed;

public class MatMedDAOImpl  extends GenericDAOImpl<MatMed, Integer> implements MatMedDAO{

	public MatMedDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<MatMed> list() {
		TypedQuery<MatMed> query = em.createQuery("from MatMed m",MatMed.class);
		return query.getResultList();
	}

	@Override
	public List<MatMed> buscarMaterialporPaciente(String idPaciente) {
		TypedQuery<MatMed>q = em.createQuery("from MatMed m where m.paciente.cpf =:idPaciente",MatMed.class);
		q.setParameter("idPaciente", idPaciente);
		return q.getResultList();
	}

}
