package br.com.pdcase.atendimentohospitalarbackend.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.pdcase.atendimentohospitalarbackend.model.Paciente;
import br.com.pdcase.atendimentohospitalarbackend.model.PlanoSaude;
import br.com.pdcase.atendimentohospitalarbackend.service.FichaBean;
/**
 * 
 * @author Diogo Lages
 *
 */
@Path("/ficha")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FichaResource {

	@EJB
	private FichaBean fichaBean;

	@GET
	@Path("/buscarPlanoSaude")
	public Response buscarPlanoSaude() {
		List<PlanoSaude> ficha = this.fichaBean.recuperarPlanoSaude();
		return Response.ok(ficha).build();
	}
	
	@POST
	@Path("/salvarFichaPaciente")
	public Response salvarFichaPaciente(Paciente paciente) {
		fichaBean.salvar(paciente);
		return Response.ok(Status.OK).build();
	}
	
}
