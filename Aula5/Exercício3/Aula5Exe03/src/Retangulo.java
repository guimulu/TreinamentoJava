
public class Retangulo {
	private double comprimento;
	private double largura;
	private double area; 
	private double perimetro;
	
	public Retangulo(double comprimento, double largura){
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public double calculaArea(){
		area = comprimento * largura;
		return area;
	}
	
	public double calcularPerimitro(){
		perimetro = (2*comprimento)+(2*largura);
		return perimetro;
	}
	
	public String imprimir(){
		return "Comprimento: " +comprimento 
				+ " Largura: " + largura 
				+ " Area: " + area 
				+ " Perimetro: " + perimetro;
	}
	
	public void setDados(double comprimento, double largura){
		this.comprimento = comprimento;
		this.largura = largura;
	}
	
	public void setDados(double comprimento){
		this.comprimento = comprimento;
	}
	
	public void setDados(int largura){
		this.largura = largura;
	}
	
	public void setDados(){
		this.comprimento = 0;
		this.largura = 0;
	}
	
	
	public String calcularTudo(){
		return "Area: " + calculaArea() + " Perimetro: " +calcularPerimitro();
	}
	
}
