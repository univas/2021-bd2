package br.edu.univas.si5.bd2.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION")
public class Cargo implements Serializable {

	@Id
	@Column(name = "CODE")
	private Integer codigo;

	@Column(name = "NAME")
	private String nome;

	@Column(name = "WAGE")
	private float salario;

	@OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER) // o padrão do fetch é LAZY
	private Set<Funcionario> funcionarios;

	public Cargo() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Cargo [codigo=" + codigo + ", nome=" + nome + ", salario=" + salario + "]";
	}

}
