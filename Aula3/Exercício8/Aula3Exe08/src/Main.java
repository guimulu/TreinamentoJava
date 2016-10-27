import java.util.Scanner;

public class Main {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		AnoBisexto year = new AnoBisexto();
		
		System.out.println("Informe o ANO: ");
		year.setAno(input.nextInt());
		
		System.out.println("O Ano Informado " + year.verificaAno());
		
	}

}