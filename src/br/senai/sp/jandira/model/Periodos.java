package br.senai.sp.jandira.model;

//eneum
public enum Periodos {

	MANHA("Manh�"), 
	TARDE("Tarde"), 
	NOITE("Noite"),
	SABADO("Sabado"), 
	ONLINE("Online");

	private Periodos(String descri�ao) {
     this.descricao = descri�ao; 	
		
	}

	private String descricao;

	public String getdescricao() {
		return descricao;

	}

}
