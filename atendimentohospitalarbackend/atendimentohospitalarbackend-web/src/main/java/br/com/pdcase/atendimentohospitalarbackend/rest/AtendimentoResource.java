package br.com.pdcase.atendimentohospitalarbackend.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONObject;

import br.com.pdcase.atendimentohospitalarbackend.model.AtendimentoDTO;
import br.com.pdcase.atendimentohospitalarbackend.model.Especialidade;
import br.com.pdcase.atendimentohospitalarbackend.model.Paciente;
import br.com.pdcase.atendimentohospitalarbackend.service.AtendimentoBean;
/**
 * 
 * @author Diogo Lages
 *
 */
@Path("/atendimento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AtendimentoResource {

	@EJB
	private AtendimentoBean atendimentoBean;

	@POST
	@Path("/salvarAtendimento")
	public Response salvarAtendimentoPaciente(AtendimentoDTO obj) {
		boolean possuiAutorizacao = atendimentoBean.salvar(obj);
		return Response.ok(possuiAutorizacao).build();
	}
	
	@GET
	@Path("/buscarPaciente/{nome}")
	public Response buscarPaciente(@PathParam("nome") String nome) {
		List<Paciente> pacientes = null;
		if (nome != null && !nome.isEmpty()) {
			pacientes = this.atendimentoBean.recuperarPacientePorNome(nome.concat("%"));
		}			

		return Response.ok(pacientes).build();
	}
	
	@GET
	@Path("/buscarPaciente")
	public Response buscarPaciente() {
		List<Paciente> pacientes = null;
		pacientes = this.atendimentoBean.recuperarPacientes();
		return Response.ok(pacientes).build();
	}
	
	@GET
	@Path("/buscarEspecialidades")
	public Response buscarPlanoSaude() {
		List<Especialidade> ficha = this.atendimentoBean.recuperarEspecialidades();
		return Response.ok(ficha).build();
	}
	
}
