
public class Moto {
	private String marca;
	private String modelo;
	private String cor;
	private int marcha;
	
	public Moto(String marca, String modelo, String cor){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = 0;
	}
	
	public String imprimir(){
		return "Marca: " + marca + " Modelo: " + modelo + " Cor: " + cor + " Marcha: " + marcha;
	}
	
	public String marchaAcima(){
		return marchaAcima(1);
	}
	
	public String marchaAcima(int qtdMarcha){
		if (marcha+qtdMarcha > 5 || qtdMarcha == 0){
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
		if (marcha-qtdMarcha < 0 || qtdMarcha == 0){
			return "Impossível trocar de marcha";
		}
		else
		{
			marcha-=qtdMarcha;
			return "A moto está na marcha: " + marcha;
		}
	}
	
}
