
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lampada luz = new Lampada();
		luz.isLigada();
		
		luz.liga();
		System.out.println(luz.observa());
		
		luz.desliga();
		System.out.println(luz.observa());
		luz.liga();
		System.out.println(luz.observa());
		luz.desliga();
		System.out.println(luz.observa());
		
	}

}
