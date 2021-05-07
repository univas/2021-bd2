package br.edu.univas.si5.bd2.model;

public class Curso {

	private int sigla;
	private String nome;

	public Curso() {

	}

	public Curso(int sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}

	public int getSigla() {
		return sigla;
	}

	public void setSigla(int sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Curso [sigla=" + sigla + ", nome=" + nome + "]";
	}

}
