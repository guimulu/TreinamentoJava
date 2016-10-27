
public class Curso {
	private String codCurso;
	private int numeroVagas;
	private int cadidatoHomem;
	private int candidatoMulher;
	 
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public int getNumeroVagas() {
		return numeroVagas;
	}
	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	public int getCadidatoHomem() {
		return cadidatoHomem;
	}
	public void setCadidatoHomem(int cadidatoHomem) {
		this.cadidatoHomem = cadidatoHomem;
	}
	public int getCandidatoMulher() {
		return candidatoMulher;
	}
	public void setCandidatoMulher(int candidatoMulher) {
		this.candidatoMulher = candidatoMulher;
	}
	public Curso(String codCurso, int numeroVagas, int cadidatoHomem, int candidatoMulher) {
		this.codCurso = codCurso;
		this.numeroVagas = numeroVagas;
		this.cadidatoHomem = cadidatoHomem;
		this.candidatoMulher = candidatoMulher;
	}
}
