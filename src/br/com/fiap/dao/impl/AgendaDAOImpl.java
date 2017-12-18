package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.AgendaDAO;
import br.com.fiap.entity.Agenda;

public class AgendaDAOImpl extends GenericDAOImpl<Agenda, Integer> implements AgendaDAO {

	public AgendaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Agenda> list() {
		TypedQuery<Agenda> query = em.createQuery("from Agenda a",Agenda.class);
		return query.getResultList();
		
	}

}
