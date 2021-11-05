package br.senai.sp.jandira.model;

public class Aluno {

	private String nome;
	private String matricula;
	private Periodos periodo;

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public void setPeriodo(Periodos periodo) {
		this.periodo = periodo;
	}

	public Periodos getPeriodo() {
		return periodo;
	}

}
