
public class Lampada {
	private boolean ligada;

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		this.ligada = ligada;
	}
	
	public void liga(){
		ligada = true;
	}
	
	public void desliga(){
		ligada = false;
	}
	
	public String observa(){
		String situacao;
		if (ligada == true){
			situacao = "Ligada";
		}else
		{
			situacao = "Desligada";
		}
		return situacao;
	}
	
	
}
