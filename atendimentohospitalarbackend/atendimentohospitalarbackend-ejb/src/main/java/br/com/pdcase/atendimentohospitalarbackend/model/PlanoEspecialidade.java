package br.com.pdcase.atendimentohospitalarbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PLANO_ESPECIALIDADE database table.
 * @author Diogo Lages
 */
@Entity
@Table(name = "PLANO_ESPECIALIDADE", schema="atendimento")
@NamedQueries({
	@NamedQuery(name = PlanoEspecialidade.BUSCAR_ESPECIALIDADE_PLANO_POR_ID,
			query = "SELECT pe FROM PlanoEspecialidade pe WHERE pe.planoSaude.id = :idPlano AND pe.especialidade.id = :idEspecialidade")
})
//SELECT pe.* FROM PLANO_ESPECIALIDADE pe WHERE pe.plano_Id = 1 AND pe.especialidade_Id = 10
public class PlanoEspecialidade {

	public static final String BUSCAR_ESPECIALIDADE_PLANO_POR_ID = "PlanoEspecialidade.buscaEspecialidadePlanoPorId";
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "especialidade_Id")
	private Especialidade especialidade;
	
	@ManyToOne
	@JoinColumn(name = "plano_Id")
	private PlanoSaude planoSaude;
	
	public PlanoEspecialidade() {
		super();
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
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
		return "PlanoEspecialidade [id=" + id + ", especialidade=" + especialidade + ", planoSaude=" + planoSaude + "]";
	}

}