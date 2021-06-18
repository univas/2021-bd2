package br.edu.univas.si5.bd2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regSeqGen")
	@SequenceGenerator(name = "regSeqGen", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
	private Integer registro;
	private String nome;
	private String sexo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date nascimento;
	@Transient
	private int idade;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_FK")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY) //o padrão do fetch é EAGER
	@JoinColumn(name = "CARGO_FK")
	private Cargo cargo;

	public Funcionario() {
	}

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [registro=" + registro + ", nome=" + nome + ", sexo=" + sexo + ", nascimento=" + nascimento
				+ "]";
	}

}
