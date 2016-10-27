
public class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;
	
	public Pessoa(String nome, String endereco, String telefone){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String imprimir(){
		return nome + " " + endereco + " " + telefone;
	}
}
