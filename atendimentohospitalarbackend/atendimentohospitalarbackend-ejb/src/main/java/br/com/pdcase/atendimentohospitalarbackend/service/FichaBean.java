package br.com.pdcase.atendimentohospitalarbackend.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.pdcase.atendimentohospitalarbackend.model.Paciente;
import br.com.pdcase.atendimentohospitalarbackend.model.PlanoSaude;

/**
 * 
 * @author Diogo Lages
 *
 */

@Stateless
@LocalBean
public class FichaBean {

	@PersistenceContext
	private EntityManager em;

//	private static ObjectMapper mapper = new ObjectMapper();
	
	//combo dos planos
	@SuppressWarnings("unchecked")
	public List<PlanoSaude> recuperarPlanoSaude(){
		Query query = em.createNamedQuery(PlanoSaude.BUSCAR_PLANOS);
		return (List<PlanoSaude>) query.getResultList();
	}

	public void salvar(Paciente paciente) {
		/*try {
			//Paciente paciente = mapper.readValue(obj.toJSONString(), Paciente.class);
			
			if(paciente.getId()!=null) {
				em.merge(paciente);
			} else {
				em.persist(paciente);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		if(paciente.getId()!=null) {
			em.merge(paciente);
		} else {
			em.persist(paciente);
			System.out.println("Salvou");
		}
	}
	
}
