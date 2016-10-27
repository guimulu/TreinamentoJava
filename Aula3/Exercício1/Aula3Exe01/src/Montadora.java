
public class Montadora {
	private int comDefeito;
	
	public int getComDefeito() {
		return comDefeito;
	}

	public void setComDefeito(int comDefeito) {
		this.comDefeito = comDefeito;
	}

	public double calculaPorcentagem(int total, int modelos){
		return (modelos*100/total);
	}
	
	public void defeitosos(int qtd){
		this.comDefeito += qtd;
	}
	
}
