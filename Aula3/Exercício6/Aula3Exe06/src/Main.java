
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universidade universidade = new Universidade();
		
		universidade.addCursos(new Curso("1", 30, 50, 6));
		universidade.addCursos(new Curso("2", 30, 25, 60));
		universidade.addCursos(new Curso("3", 30, 40, 55));
		universidade.addCursos(new Curso("4", 30, 15, 20));
		
		System.out.println(universidade.estatisticasCursos());
		System.out.println(universidade.maiorCadidatoVaga());
		System.out.println("\nTotal de Candidatos: " + universidade.totalDeCandidatos());
	}

}
