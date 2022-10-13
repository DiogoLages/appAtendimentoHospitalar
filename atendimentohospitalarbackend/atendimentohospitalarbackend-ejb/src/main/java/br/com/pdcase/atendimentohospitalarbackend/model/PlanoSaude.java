package br.com.pdcase.atendimentohospitalarbackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the PLANO_SAUDE database table.
 * @author Diogo Lages
 */
@Entity
@Table(name = "PLANO_SAUDE", schema="atendimento")
@NamedQueries({
	@NamedQuery(name = PlanoSaude.BUSCAR_PLANOS,
			query = "SELECT obj FROM PlanoSaude obj order by obj.descricao")
})
public class PlanoSaude {

	public static final String BUSCAR_PLANOS = "PlanoSaude.buscarPlanoSaude";
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descricao", length = 50)
	private String descricao;
	
	@OneToMany(mappedBy = "plano")
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public PlanoSaude() {
		super();
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return "PlanoSaude [id=" + id + ", descricao=" + descricao + "]";
	}

}