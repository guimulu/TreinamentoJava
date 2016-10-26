import java.util.ArrayList;

public class Casa {
	private String cor;
	private ArrayList<Porta> portas;
	
	public Casa(){
		portas = new ArrayList<Porta>();
	}
	
	public void addPortas(Porta porta){
		this.portas.add(porta);
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void pinta(String s){
		
	}
	
	public int quantasPortasEstaoAbertas(){
		int totalPortasAbertas = 0;
		
		for(Porta porta : portas)
		{
			if(porta.isAberta()){
				totalPortasAbertas++;
			}	
		}
		
		return totalPortasAbertas;	
	}
	
	public int totalDePortasFechadas(){
		int totalPortasFechadas = 0;
		
		for(Porta porta : portas)
		{
			if(porta.isAberta()){
				totalPortasFechadas++;
			}	
		}
		
		return totalPortasFechadas;
		
	}

	
	
}
