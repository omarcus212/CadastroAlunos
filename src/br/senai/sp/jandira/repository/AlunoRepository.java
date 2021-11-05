package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {

	private Aluno[] turma;

	public AlunoRepository() {
		turma = new Aluno[32];

	}
	
	public AlunoRepository(int quantidadealunos) {
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
