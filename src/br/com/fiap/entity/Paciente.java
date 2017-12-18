package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	private String telefone;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="pacientes")
	private List<Agenda>agendas;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="paciente")
	private List<Procedimento>procedimentos;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="paciente")
	private List<MatMed>materiais;

	public void adicionaMateriais(MatMed material) {
		materiais.add(material);
		material.setPaciente(this);
	}
	
	public void adicionaProcedimentos(Procedimento procedimento) {
		
		procedimentos.add(procedimento);
		procedimento.setPaciente(this);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<MatMed> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<MatMed> materiais) {
		this.materiais = materiais;
	}

	public Paciente(String cpf, String nome, LocalDate dataNascimento, String telefone, List<Agenda> agendas,
			List<Procedimento> procedimentos, List<MatMed> materiais) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.agendas = agendas;
		this.procedimentos = procedimentos;
		this.materiais = materiais;
	}

	public Paciente() {
		procedimentos = new ArrayList<Procedimento>();
		materiais = new ArrayList<MatMed>();
	}
}
