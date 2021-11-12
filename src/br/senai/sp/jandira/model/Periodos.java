package br.senai.sp.jandira.model;

//eneum
public enum Periodos {

	MANHA("Manhã"), 
	TARDE("Tarde"), 
	NOITE("Noite"),
	SABADO("Sabado"), 
	ONLINE("Online");

	private Periodos(String descriçao) {
     this.descricao = descriçao; 	
		
	}

	private String descricao;

	public String getdescricao() {
		return descricao;

	}

}
