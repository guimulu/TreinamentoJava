import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int modeloX = 120;
		int modeloY= 40;
		int qtd = 0;
		
		Scanner input = new Scanner(System.in);
		
		Montadora carros = new Montadora();
		System.out.println("Quantos carros do modelo X tem defeito? ");
		qtd = input.nextInt();
		System.out.println(carros.calculaPorcentagem(modeloX, qtd));
		carros.defeitosos(qtd);

		System.out.println("Quantos carros do modelo Y tem defeito? ");
		qtd = input.nextInt();
		System.out.println(carros.calculaPorcentagem(modeloY, qtd));
		carros.defeitosos(qtd);
		
		System.out.println("Porcentagem de carros no total que tem defeito: ");
		System.out.println(carros.calculaPorcentagem(modeloX + modeloY, carros.getComDefeito()));
	}

}
