
public class Calcula {
	private int maior;
	private int menor;
	private int qtd;
	private int soma;
	
	public int getMaior() {
		return maior;
	}

	public void setMaior(int maior) {
		this.maior = maior;
	}

	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	public void verificaMaiorMenor(int num){
		if(num > maior){
			maior = num;
		}else if(num < menor){
			menor = num;
		}
		qtd++;
		soma += num;
	}
	
	public double calculaMedia(int divisor){
		return soma/divisor;
	}
	
}
