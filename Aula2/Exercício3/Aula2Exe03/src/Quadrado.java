
public class Quadrado {
	private double lado;
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double area(){
		return lado * lado;
	}
	
	public double perimetro(){
		return 4 * lado;
	}
	
	
}
