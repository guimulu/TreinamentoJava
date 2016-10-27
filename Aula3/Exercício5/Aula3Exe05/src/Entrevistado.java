
public class Entrevistado {
	private int masculino;
	private int feminino;
	private int sim;
	private int nao;
	private int masculinoNao = 0;
	private int femininoSim = 0;
	
	public Entrevistado(){
		masculino = 0;
		feminino = 0;
		sim = 0;
		nao = 0;
	}

	public int getSim() {
		return sim;
	}

	public int getNao() {
		return nao;
	}

	public void totalRespostas(String resposta){
		switch(resposta){
			case "ms":
				masculino++;
				sim++;
				break;
			case "mn":
				masculino++;
				nao++;
				masculinoNao++;
				break;
			case "fs":
				feminino++;
				sim++;
				femininoSim++;
				break;
			case "fn":
				feminino++;
				nao++;
				break;
			default:
				break;
		}
	}
	
	
	public double femininoRespondeSim(){
		return (100 / 20) * femininoSim;
	}
	
	public double masculinoRespondeNao(){
		return (100 / 20) * masculinoNao;
	}
	
}
