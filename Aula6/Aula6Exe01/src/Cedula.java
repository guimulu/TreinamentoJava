
public class Cedula {
	private int quantidade;
	private int nomeCedula;
	
	public Cedula(int nomeCedula, int quantidade){
		this.nomeCedula = nomeCedula;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getNomeCedula() {
		return nomeCedula;
	}

	public void setNomeCedula(int nomeCedula) {
		this.nomeCedula = nomeCedula;
	}

	public boolean verificaCedula(int nomeCedula, int quantidade){
		if (this.nomeCedula == nomeCedula && this.quantidade >= quantidade ) 
			return true;
		else 
			return false;
	}
	
	public int calculaTudo(){
		return quantidade * nomeCedula;
	}
}
