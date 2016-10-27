import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Candidato objCand = new Candidato();
		System.out.println("Informe o numero do candidato:");
		int codigoCandidato = input.nextInt();
		objCand.setCodigoCandidato(codigoCandidato);

		System.out.println("Informe o ano de nascimento");
		int anoNascimento = input.nextInt();
		objCand.setAnoNascimento(anoNascimento);

		System.out.println("Informe a nota da primeira etapa:");
		int notaPrimeiraEtapa = input.nextInt();
		objCand.setNotaPrimeiraEtapa(notaPrimeiraEtapa);

		System.out.println("Informe o numero de horas em curso de qualificacao:");
		int horasQualificacao = input.nextInt();
		objCand.setHorasQualificacao(horasQualificacao);

		System.out.println("Tempo de experiência em um cargo semelhante");
		int tempoCargoSemelhante = input.nextInt();
		objCand.setTempoCargoSemelhante(tempoCargoSemelhante);

		System.out.println(objCand.exibirResultados());
	}

}
