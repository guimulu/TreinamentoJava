
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Financiamento financiamento1 = new Financiamento(5000, 25000);
		System.out.println(financiamento1.verificaFinanciamento() + "\n" + financiamento1.mensagem());
		
		Financiamento financiamento2 = new Financiamento(5000, 50000);
		System.out.println(financiamento2.verificaFinanciamento() + "\n" + financiamento2.mensagem());
		
	}

}
