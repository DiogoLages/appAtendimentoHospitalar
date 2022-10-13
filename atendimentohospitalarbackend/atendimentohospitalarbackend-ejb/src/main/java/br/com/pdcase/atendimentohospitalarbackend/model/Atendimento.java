package br.com.pdcase.atendimentohospitalarbackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ATENDIMENTO database table.
 * @author Diogo Lages
 */
@Entity
@Table(name = "ATENDIMENTO" , schema="atendimento")
public class Atendimento {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "IdPaciente")
	private Paciente paciente;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_atendimento")
	private Date dataAtendimento;
	
	@ManyToOne
	@JoinColumn(name = "especialidade")
	private Especialidade especialidade;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private PlanoEspecialidade planoEspecialidade;

	@Column(insertable = false, updatable = false)
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Long getId() {
		return this.id;
	} 

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Atendimento [id=" + id + ", paciente=" + paciente + ", dataAtendimento=" + dataAtendimento
				+ ", especialidade=" + especialidade + "]";
	}
	
}