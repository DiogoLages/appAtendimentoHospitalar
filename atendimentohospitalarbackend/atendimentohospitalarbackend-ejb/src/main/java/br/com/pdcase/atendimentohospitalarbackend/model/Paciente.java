package br.com.pdcase.atendimentohospitalarbackend.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the PACIENTE database table.
 * @author Diogo Lages
 */
@Entity(name = "Paciente")
@Table(name = "PACIENTE", schema = "atendimento")
@NamedQueries({
	@NamedQuery(name = Paciente.BUSCAR_TODOS_PACIENTES, query = "select obj from Paciente obj"),
	@NamedQuery(name = Paciente.BUSCAR_POR_NOME, query = "select pa from Paciente pa where pa.nome like :nome"),
	@NamedQuery(name = Paciente.BUSCAR_POR_ID, query = "select pa from Paciente pa where pa.id = :id")
	})
public class Paciente {

	public static final String BUSCAR_POR_ID = "Paciente.listaFichaPorId";
	
	public static final String BUSCAR_POR_NOME = "Paciente.listaFichaPorNome";
	
	public static final String BUSCAR_TODOS_PACIENTES = "Paciente.listaTodosPacientes";
	
	@Id
	@Column(name = "Id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "celular", length = 15)
	private String celular;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "nome_pai", length = 100)
	private String nomePai;
	
	@Column(name = "nome_mae", length = 100)
	private String nomeMae;
	
	@Column(name = "numero_carteira")
	private String numeroCarteira;
	
	@ManyToOne()
	@JoinColumn(name = "plano")
	@JsonIgnoreProperties(value = "pacientes")
	private PlanoSaude plano;

	public Paciente() {
		super();
	}

	public Paciente(Long id) {
		super();
		setId(id);
	}

	public Paciente(Long id, String nome) {
		super();
		setId(id);
		setNome(nome);
	}
	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", celular=" + celular + ", dataNascimento=" + dataNascimento
				+ ", cpf=" + cpf + ", sexo=" + sexo + ", email=" + email + ", nomePai=" + nomePai + ", nomeMae="
				+ nomeMae + ", numeroCarteira=" + numeroCarteira + ", plano=" + plano + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/*public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}*/
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public PlanoSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoSaude plano) {
		this.plano = plano;
	}

}