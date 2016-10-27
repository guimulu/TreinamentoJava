
public class Moto {
	private String marca;
	private String modelo;
	private String cor;
	private int marcha;
	
	public Moto(String marca, String modelo, String cor, int marcha){
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.marcha = marcha;
	}
	
	public String imprimir(){
		return "Marca: " + marca + " Modelo: " + modelo + " Cor: " + cor + " Marcha: " + marcha;
	}
}
