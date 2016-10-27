
public class Moto {
	private String marca;
	private String modelo;
	private String cor;
	private int marcha;
	private int menorMarcha;
	private int maiorMarcha;
	
	public int getMenorMarcha() {
		return menorMarcha;
	}

	public void setMenorMarcha(int menorMarcha) {
		this.menorMarcha = menorMarcha;
	}

	public int getMaiorMarcha() {
		return maiorMarcha;
	}

	public void setMaiorMarcha(int maiorMarcha) {
		this.maiorMarcha = maiorMarcha;
	}

	public Moto(String marca, String modelo, String cor){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = 0;
	}
	
	public String imprimir(){
		return "Marca: " + marca 
				+ " Modelo: " + modelo 
				+ " Cor: " + cor 
				+ " Marcha: " + marcha
				+ " Maior Marcha: " + maiorMarcha
				+ " Menor Marcha: " + menorMarcha;
	}
	
	public String marchaAcima(){
		return marchaAcima(1);
	}
	
	public String marchaAcima(int qtdMarcha){
		if (marcha+qtdMarcha > maiorMarcha || qtdMarcha == 0){
			return "Impossível trocar de marcha";
		}
		else
		{
			marcha += qtdMarcha;
			return "A moto está na marcha: " + marcha;
		}
	}
	
	public String marchaAbaixo(){
		return marchaAbaixo(1);
	}
	
	public String marchaAbaixo(int qtdMarcha){
		if (marcha-qtdMarcha < menorMarcha || qtdMarcha == 0){
			return "Impossível trocar de marcha";
		}
		else
		{
			marcha-=qtdMarcha;
			return "A moto está na marcha: " + marcha;
		}
	}
	
}
