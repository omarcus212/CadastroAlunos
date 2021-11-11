package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunosRepository {

	private Aluno[] turma;

	 ///construtor tem o mesmo nome da class
	public AlunosRepository() {
		turma = new Aluno[32];

	}
	
	public AlunosRepository(int quantidadealunos) {
		turma = new Aluno[quantidadealunos];

	}
      
	public void gravar(Aluno alunos, int posicao) {
		turma[posicao] = alunos;
	
	}
	
	public Aluno listaraluno(int posiçao){
		return turma[posiçao];
		
	}
	
	public Aluno[] listartodos(){
		return turma;
	}
}
