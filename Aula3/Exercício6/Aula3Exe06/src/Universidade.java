import java.util.ArrayList;

public class Universidade {
	private ArrayList<Curso> cursos;
	
	public Universidade(){
		cursos = new ArrayList<Curso>();
	}
	
	public void addCursos(Curso curso){
		this.cursos.add(curso);
	}
	
	public double getPorcentagem(String nome){
		for (Curso curso : cursos){
			if (curso.getCodCurso() == nome){
				return (100 * curso.getCandidatoMulher()) / (curso.getCadidatoHomem() + curso.getCandidatoMulher());
			}
		}
		return 0;
	}
	
	public double candidatoVaga(String nome){
		for (Curso curso : cursos){
			if (curso.getCodCurso() == nome){
				double numeroDeCandidato = (double) (curso.getCadidatoHomem() + curso.getCandidatoMulher()) / curso.getNumeroVagas();
				return numeroDeCandidato;
			}
		}
		return 0;
	}
	
	public String maiorCadidatoVaga(){
		double maior = 0;
		String texto = "";
		for (Curso curso : cursos){
			if (candidatoVaga(curso.getCodCurso()) > maior)
				maior = candidatoVaga(curso.getCodCurso());
				texto = "\nId Curso: " + curso.getCodCurso() + " - Candidatos por Vaga: " + maior;
		}
		
		return texto;
	}
	
	public String estatisticasCursos(){
		String texto = "";
		for (Curso curso : cursos){
			texto +="\n\n" +"Curso: "+ curso.getCodCurso() + " Cadidatos por vaga: " + candidatoVaga(curso.getCodCurso()) + " Porcentagem de mulher: " + getPorcentagem(curso.getCodCurso());
		}
		
		return texto;
	}	
	
	public int totalDeCandidatos(){
		int total = 0;
		for (Curso curso : cursos){
			total += (curso.getCadidatoHomem() + curso.getCandidatoMulher());
		}
		return total;
	}
}
