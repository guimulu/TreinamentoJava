
public class AnoBisexto {
	private int ano;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String verificaAno(){
		if((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0)){
		    return "É Bissexto";
		} 
		else{
		    return "Não é Bissexto";
		}
	}
}
