import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String simNao;
		String mascFemi;
		Scanner input = new Scanner(System.in);
		
		Entrevistado pessoa = new Entrevistado();
		for (int i=0;i<20;i++){
			System.out.println("Informe o sexo (f/m): ");
			mascFemi = input.nextLine();
			System.out.println("Informe a resposta (s/n): ");
			simNao = input.nextLine();
			pessoa.totalRespostas(mascFemi+simNao);
		}
		
		System.out.println("Numero de pessoas que responderam sim: " + pessoa.getSim());
		System.out.println("Numero de pessoas que responderam nao: " + pessoa.getNao());
		System.out.println("Porcentagem de pessoas do sexo feminino que responderam sim: " + pessoa.femininoRespondeSim());
		System.out.println("Porcentagem de pessoas do sexo masculino que responderam nao: " + pessoa.masculinoRespondeNao());
	}

}

