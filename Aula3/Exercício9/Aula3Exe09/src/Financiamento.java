
public class Financiamento {
	private double salario;
	private double valorFinanc;
	
	public Financiamento(double salario, double valorFinanc){
		this.salario = salario;
		this.valorFinanc = valorFinanc;
	}

	public String verificaFinanciamento(){
		if (valorFinanc < salario || valorFinanc == salario*5){
			return "Financiamento Concedido";
		}
		else{
			return "Financiamento Negado";
		}
	}

	public String mensagem() {
		// TODO Auto-generated method stub
		return "Obrigado por nos consultar.";
	}
	
}
