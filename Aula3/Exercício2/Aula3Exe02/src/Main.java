import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int qtd;
		
		Scanner input = new Scanner(System.in);
		
		Calcula calcula = new Calcula();
		System.out.println("Quantos numeros irao ser lidos? ");
		qtd = input.nextInt();
		int i = 0;
		while (i < qtd){
			if (i == 0){
				int num;
				System.out.println("Digite um numero: ");
				num = input.nextInt(); 
				calcula.setMenor(num);
				calcula.setMaior(num);
				calcula.verificaMaiorMenor(num);
				i++;
			}
			else{
				System.out.println("Digite o proximo numero: ");
				calcula.verificaMaiorMenor(input.nextInt());
				i++;
			}
		}
		
		System.out.println("Maior numero digitado: " + calcula.getMaior());
		System.out.println("Menor numero digitado: " + calcula.getMenor());
		System.out.println("Media dos numeros: " + calcula.calculaMedia(qtd));

	}

}
