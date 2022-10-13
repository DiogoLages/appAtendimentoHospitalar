package br.com.pdcase.atendimentohospitalarbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ESPECIALIDADE database table.
 * @author Diogo Lages
 */
@Entity
@Table(name = "ESPECIALIDADE", schema="atendimento")
@NamedQueries({
	@NamedQuery(name = Especialidade.BUSCAR_ESPECIALIDADES,
			query = "SELECT obj FROM Especialidade obj order by obj.descricao"),
	@NamedQuery(name = Especialidade.BUSCAR_POR_ID, query = "select obj from Especialidade obj where obj.id = :id")
})
public class Especialidade {
	
	public static final String BUSCAR_ESPECIALIDADES = "Especialidade.buscarEspecialidades";
	public static final String BUSCAR_POR_ID = "Especialidade.buscarPorId";

	@Id
	@Column(name = "Id")
	@GeneratedValue
	private Long id;

	@Column(name = "descricao", length = 50)
	private String descricao;
	
	public Especialidade() {
		
	}
	
	public Especialidade(Long id) {
		this.id = id;
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
		return "Especialidade [id=" + id + ", descricao=" + descricao + "]";
	}

}