import java.util.ArrayList;

public class Edificio {
	private String cor;
	private ArrayList<Porta> portas;
	private ArrayList<Andar> andares;
	
	
	public Edificio(){
		portas = new ArrayList<Porta>();
		andares = new ArrayList<Andar>();
	}
	
	public Edificio(String cor){
		this();
		this.cor = cor;		
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void pinta(String cor){
		this.cor = cor;
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
	
	public void adicionaPorta(Porta p){
		this.portas.add(p);
	}

	public int totalDePortas(){
		int totalPortas = 0;
		
		for(Porta porta : portas)
		{
			if (porta != null){
				totalPortas++;
			}
		}
		
		return totalPortas;	
	}
	
	public void adicionarAndar(Andar a){
		this.andares.add(a);
	}
	
	public int totalDeAndares(){
		int totalAndares = 0;
		
		for(Andar andar : andares)
		{
			if (andar != null){
				totalAndares++;
			}
		}
		
		return totalAndares;
	}
	
	
	
	
	
	

}
