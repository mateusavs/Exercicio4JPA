package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.entity.Procedimento;

public class ProcedimentoDAOImpl extends GenericDAOImpl<Procedimento, Integer> implements ProcedimentoDAO {

	public ProcedimentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Procedimento> list() {
		TypedQuery<Procedimento> query = em.createQuery("from Procedimento pp",Procedimento.class);
		return query.getResultList();
		
	}

	@Override
	public List<Procedimento> buscarProcedimentoporPaciente(String idPaciente) {
		TypedQuery<Procedimento>q = em.createQuery("from Procedimento p where p.paciente.cpf = :idPaciente",Procedimento.class);
		q.setParameter("idPaciente", idPaciente);
		return q.getResultList();
	}

}
