
public class Pessoa {
	private String nome;
	private int idadeInicial;

	public Pessoa(String nome, int idadeInicial){
		this.nome = nome;
		this.idadeInicial = idadeInicial;
	}
		
	public void fazAniversario(){
		idadeInicial++;
	}
	
	public String retornaNomeIdade(){
		return nome + " " + idadeInicial;
	}
	
	
}
