package br.com.pdcase.atendimentohospitalarbackend.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pdcase.atendimentohospitalarbackend.model.Atendimento;
import br.com.pdcase.atendimentohospitalarbackend.model.AtendimentoDTO;
import br.com.pdcase.atendimentohospitalarbackend.model.Especialidade;
import br.com.pdcase.atendimentohospitalarbackend.model.Paciente;
import br.com.pdcase.atendimentohospitalarbackend.model.PlanoEspecialidade;

/**
 * 
 * @author Diogo Lages
 *
 */
@Stateless
@LocalBean
public class AtendimentoBean {

	@PersistenceContext
	private EntityManager em;

	private static ObjectMapper mapper = new ObjectMapper();

	private Boolean autorizacao;
	
	@SuppressWarnings("unchecked")
	public List<Paciente> recuperarPacientePorNome(String nome) {
		Query query = em.createNamedQuery(Paciente.BUSCAR_POR_NOME).setParameter("nome", nome + "%");
		return (List<Paciente>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> recuperarPacientes() {
		Query query = em.createNamedQuery(Paciente.BUSCAR_TODOS_PACIENTES);
		return (List<Paciente>) query.getResultList();
	}

	public boolean salvar(AtendimentoDTO obj) {
		Query query = em.createNamedQuery(Paciente.BUSCAR_POR_ID).setParameter("id", obj.getPaciente());
		Paciente paciente = (Paciente) query.getSingleResult();
		
		Query queryEspecialidade = em.createNamedQuery(Especialidade.BUSCAR_POR_ID).setParameter("id", obj.getEspecialidade());
		Especialidade especialidade = (Especialidade) queryEspecialidade.getSingleResult();
		
		Query query2 = em.createNamedQuery(PlanoEspecialidade.BUSCAR_ESPECIALIDADE_PLANO_POR_ID)
				.setParameter("idPlano", paciente.getPlano().getId())
				.setParameter("idEspecialidade", obj.getEspecialidade());
		
		Atendimento atendimento = new Atendimento();
		atendimento.setDataAtendimento(new Date());
		atendimento.setEspecialidade(especialidade);
		atendimento.setPaciente(paciente);
		
		em.persist(atendimento);
		
		
		int especialidades = query2.getResultList().size();
		
		return especialidades == 0 ? false : true;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlanoEspecialidade> recuperarPlanoSaudePorId(Long idPlano) {
		Query query = em.createNamedQuery(PlanoEspecialidade.BUSCAR_ESPECIALIDADE_PLANO_POR_ID).setParameter("idPlano", idPlano);
		return (List<PlanoEspecialidade>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Especialidade> recuperarEspecialidades(){
		Query query = em.createNamedQuery(Especialidade.BUSCAR_ESPECIALIDADES);
		return (List<Especialidade>) query.getResultList();
	}

}
