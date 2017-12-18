package br.com.fiap.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AgendaDAO;
import br.com.fiap.dao.MatMedDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.ProcedimentoDAO;
import br.com.fiap.dao.impl.AgendaDAOImpl;
import br.com.fiap.dao.impl.MatMedDAOImpl;
import br.com.fiap.dao.impl.PacienteDAOImpl;
import br.com.fiap.dao.impl.ProcedimentoDAOImpl;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MatMed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.jpautil.JpaUtil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getInstance().createEntityManager();
		
		PacienteDAO pacienteDao = new PacienteDAOImpl(em);
		AgendaDAO agendaDao = new AgendaDAOImpl(em);
		ProcedimentoDAO procedimentoDAO = new ProcedimentoDAOImpl(em);
		MatMedDAO materialDAO = new MatMedDAOImpl(em);
		
		Agenda a1 = new Agenda();
		a1.setData(LocalDate.of(2017, 12, 18));
		a1.setDescricao("Oftalmologista");
		a1.setHora(LocalTime.of(16, 00));
		
		List<Agenda>agendas = new ArrayList<Agenda>();
		agendas.add(a1);
		
		Procedimento prc = new Procedimento();
		prc.setDescricao("1- Procedimento");
		prc.setPreco(370.0);
		
		Procedimento prc2 = new Procedimento();
		prc2.setDescricao("2- Procedimento");
		prc2.setPreco(550.0);
		
		MatMed m1 = new MatMed();
		m1.setDescricao("Mesa");
		m1.setFabricante("Fabricante - 1");
		m1.setValor(2000.0);
		
		MatMed m2 = new MatMed();
		m2.setDescricao("Cadeira");
		m2.setFabricante("Fabricante - 2");
		m2.setValor(1300.0);
		
		Paciente p1 = new Paciente();
		p1.setCpf("366.788.038-33");
		p1.setDataNascimento(LocalDate.of(1997, 10, 15));
		p1.setNome("Mateus Artur Vieira Santos");
		p1.setTelefone("(11)98453-4419");
		List<Paciente>pacientes = new ArrayList<Paciente>();
		pacientes.add(p1);
		
		p1.adicionaMateriais(m1);
		p1.adicionaMateriais(m2);
		
		p1.adicionaProcedimentos(prc);
		p1.adicionaProcedimentos(prc2);
		
		
		a1.setPacientes(pacientes);
		p1.setAgendas(agendas);
		
		agendaDao.insert(a1);
		pacienteDao.insert(p1);
		
		
		List<Procedimento> procedimentos = procedimentoDAO.buscarProcedimentoporPaciente(p1.getCpf());
		List<MatMed> materiais = materialDAO.buscarMaterialporPaciente(p1.getCpf());
		
		procedimentos.forEach(System.out::println);
		materiais.forEach(System.out::println);
	}

}
