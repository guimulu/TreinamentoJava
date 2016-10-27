
public class Candidato {
	private int codigoCandidato;
	private int anoNascimento;
	private int notaPrimeiraEtapa;
	private int horasQualificacao;
	private int tempoCargoSemelhante;

	public int getCodigoCandidato() {
		return codigoCandidato;
	}

	public void setCodigoCandidato(int codigoCandidato) {
		this.codigoCandidato = codigoCandidato;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	} 

	public int getNotaPrimeiraEtapa () {
		return notaPrimeiraEtapa;
	}

	public void setNotaPrimeiraEtapa(int notaPrimeiraEtapa) {
		this.notaPrimeiraEtapa = notaPrimeiraEtapa;
	} 
	public int getHorasQualificacao () {
		return horasQualificacao;
	}

	public void setHorasQualificacao(int horasQualificacao) {
		this.horasQualificacao = horasQualificacao;
	}

	public int getTempoCargoSemelhante () {
		return tempoCargoSemelhante;
	}

	public void setTempoCargoSemelhante(int tempoCargoSemelhante) {
		this.tempoCargoSemelhante = tempoCargoSemelhante;
	}

	public String exibirResultados(){
		int idade = 2016 - anoNascimento;
		
		if (tempoCargoSemelhante >= 2 && idade <= 30 || horasQualificacao >= 1000 || notaPrimeiraEtapa >= 8){
			return "Codigo: " + codigoCandidato + "Idade: " + idade + " Situacao: Aprovado para a Terceira etapa";
		}
		else{
			return "Codigo: " + codigoCandidato + "Idade: " + idade + " Situacao: Reprovado";
		}
	}

}
