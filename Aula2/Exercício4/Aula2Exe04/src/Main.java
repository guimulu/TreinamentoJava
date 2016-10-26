
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estoque estoque1 = new Estoque();
		estoque1.setNome("Impressora Jato de Tinta");
		estoque1.setQtdAtual(13);
		estoque1.setQtdMinima(6);
		
		Estoque estoque2 = new Estoque();
		estoque2.setNome("Monitor LCD 17 polegadas");
		estoque2.setQtdAtual(11);
		estoque2.setQtdMinima(13);
		
		Estoque estoque3 = new Estoque();
		estoque3.setNome("Mouse");
		estoque3.setQtdAtual(6);
		estoque3.setQtdMinima(2);
		
		estoque1.darBaixa(5);
		estoque2.repor(7);
		estoque3.darBaixa(4);
		System.out.println(estoque1.precisaRepor());
		System.out.println(estoque2.precisaRepor());
		System.out.println(estoque3.precisaRepor());
		System.out.println(estoque1.mostra());
		System.out.println(estoque2.mostra());
		System.out.println(estoque3.mostra());
		
		
	}

}
