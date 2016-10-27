
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Letra letra = new Letra();
		System.out.println(letra.vogalConsoante('a'));
		System.out.println(letra.ehVogal('e'));
		System.out.println(letra.ehConsoante('b'));
		
		System.out.println(letra.vogalConsoante(97));
		System.out.println(letra.ehVogal(101));
		System.out.println(letra.ehConsoante(98));
	}

}
