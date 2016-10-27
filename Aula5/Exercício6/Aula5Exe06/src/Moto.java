
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
		if (marcha >= 5){
			return "Impossível trocar de marcha";
		}
		else
		{
			marcha++;
			return "A moto está na marcha: " + marcha;
		}
	}
	
	public String marchaAbaixo(){
		if (marcha < 1){
			return "Impossível trocar de marcha";
		}
		else
		{
			marcha--;
			return "A moto está na marcha: " + marcha;
		}
	}
	
}
