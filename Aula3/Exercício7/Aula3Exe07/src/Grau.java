
public class Grau {
	private int fahren;
	
	public Grau(){
		this.fahren = 50;
	}
		
	public int getFahren() {
		return fahren;
	}
	
	public double converteGrau(double fahren){
		return (fahren-32) * 5 / 9;
	}
	
	
}
