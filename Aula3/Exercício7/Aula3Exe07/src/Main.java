
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grau grau = new Grau();
		int fahren = grau.getFahren();
		while (fahren <= 150){
			System.out.println(grau.converteGrau(fahren));
			fahren += 2;
		}
	}	
}
