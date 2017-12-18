package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Agenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private LocalDate data;
		private LocalTime hora;
		private String descricao;
		@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		@JoinTable(name="agenda_paciente",
		joinColumns= {
				@JoinColumn(name="AGENCIA_ID",nullable=false,updatable=true,insertable=true)
		},inverseJoinColumns = {
				@JoinColumn(name="PACIENTE_CPF",nullable=false,updatable=true,insertable=true)
		})
		
		private List<Paciente>pacientes;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LocalDate getData() {
			return data;
		}
		public void setData(LocalDate data) {
			this.data = data;
		}
		public LocalTime getHora() {
			return hora;
		}
		public void setHora(LocalTime hora) {
			this.hora = hora;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public List<Paciente> getPacientes() {
			return pacientes;
		}
		public void setPacientes(List<Paciente> pacientes) {
			this.pacientes = pacientes;
		}
		public Agenda(int id, LocalDate data, LocalTime hora, String descricao, List<Paciente> pacientes) {
			super();
			this.id = id;
			this.data = data;
			this.hora = hora;
			this.descricao = descricao;
			this.pacientes = pacientes;
		}
		public Agenda() {
			super();
		}	
}
