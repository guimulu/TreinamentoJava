import java.util.ArrayList;

public class Pessoa {
	private String senha;
	private int total;
	private static Integer[] notas = new Integer[] { 50, 20, 10, 5, 2 };
	private ArrayList<Cedula> cedulas;
	
	
	public Pessoa(){
		this.senha    = "mudar123";
		this.total    = 0;
		cedulas = new ArrayList<Cedula>();
		
		
	}
	
	public void adicionaCedula(int nomeCedula, int quantidade){
		for(Cedula cedula : cedulas)
		{
			if(cedula.getNomeCedula() == nomeCedula)
			{
				cedula.setQuantidade(cedula.getQuantidade() + quantidade);
				break;
			}
		}
	}
	
	public void removeCedula(int nomeCedula, int quantidade){
		for(Cedula cedula : cedulas)
		{
			if(cedula.getNomeCedula() == nomeCedula){
				cedula.setQuantidade(cedula.getQuantidade() - quantidade);
				break;
			}
		}
	}
	
	public void addCedulas(Cedula quantidade){
		this.cedulas.add(quantidade);
	}
	
	
	public boolean verificaSenha(String senha){
		if (this.senha.equals(senha)){
			return true;
		}
		else 
			return false;
	}
	
	public String valorDisponivel(){
		String cedulasDisponiveis = "";
		int i = 0;
		for(Cedula cedula : cedulas)
		{
				cedulasDisponiveis += notas[i] + " - " + cedula.getQuantidade() + " cédulas disponiveis" + "\n";
				i++;
		}
		return  "Total: " + totalCaixa()  + " R$ \n" +
				cedulasDisponiveis;
				
	}
	
	public int totalCaixa(){
		this.total = 0;
		for(Cedula cedula : cedulas)
		{
			this.total += cedula.calculaTudo();
		}
		return total;
	}
	
	
	public boolean verificaCedula(int nomeCedula, int divisao){
		for(Cedula cedula : cedulas)
		{
			if (cedula.verificaCedula(nomeCedula, divisao)){
				return true;
			}
		}
		return false;
	}
	
	
	public String sacar(int valorSaque){
		String mostraNota = "";
		int restoDaDivisao = 0;
		int divisao = 0;
		int ultimaCedula = 8;
		if (valorSaque == 1 || valorSaque == 3 || valorSaque >= total){
			return "Não foi possível realizar esta operação.";
		}
		for (int i = 0; i<5 ; i++) {
			if (valorSaque >= notas[i]) {
				restoDaDivisao = valorSaque % notas[i];
				divisao = valorSaque / notas[i];
				if (verificaCedula(50,divisao) || verificaCedula(20,divisao) || verificaCedula(10,divisao) || verificaCedula(5,divisao) || verificaCedula(2,divisao)){
					if (i == 0){ removeCedula(50, divisao);	ultimaCedula = i; }
					else if (i == 1){ removeCedula(20, divisao); ultimaCedula = i; }
					else if (i == 2){ removeCedula(10, divisao); ultimaCedula = i; }
					else if (i == 3){ removeCedula(5, divisao); ultimaCedula = i; }
					else if (i == 4){ removeCedula(2, divisao); ultimaCedula = i; }
					
					if (restoDaDivisao != 3 && restoDaDivisao != 1) {
						mostraNota += " " + notas[i] + " - " + (valorSaque / notas[i]) + " notas \n";
						valorSaque = valorSaque - (notas[i] * (valorSaque / notas[i]));
					}
					if (notas[i] >= 10 && restoDaDivisao == 3) {
						valorSaque = valorSaque - 5;
						mostraNota += " " + "5 - 1" + " nota \n";
						removeCedula(5, 1);;
						adicionaCedula(notas[ultimaCedula], 1);
					}
					if (notas[i] >= 10 && restoDaDivisao == 1) {
						valorSaque = valorSaque - 6;
						mostraNota += " " + "2 - 3" + " notas \n";
						removeCedula(2, 3);
						adicionaCedula(notas[ultimaCedula], 1);
					}
				}
				else return "Não foi possivel realizar esta operação.";
			}
		}
		return mostraNota;
	}
	
	public void reporNotas(int nomeCedula, int quantidade){
		for(Cedula cedula : cedulas)
		{
			if(cedula.getNomeCedula() == nomeCedula){
				cedula.setQuantidade(cedula.getQuantidade() + quantidade);
				break;
			}
		}
	}
	
}
