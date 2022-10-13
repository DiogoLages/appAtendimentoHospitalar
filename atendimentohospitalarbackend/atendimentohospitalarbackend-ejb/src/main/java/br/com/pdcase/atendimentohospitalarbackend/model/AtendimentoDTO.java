package br.com.pdcase.atendimentohospitalarbackend.model;

import java.util.Date;

public class AtendimentoDTO {
	
	private Long paciente;
	private Date dataAtendimento;
	private Long especialidade;
	
	public Long getPaciente() {
		return paciente;
	}
	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}
	public Date getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public Long getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Long especialidade) {
		this.especialidade = especialidade;
	}
	
	
}
