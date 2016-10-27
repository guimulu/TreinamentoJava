import java.util.ArrayList;

public class Loja {
	private ArrayList<Mercadoria> mercadorias;
	
	public Loja(){
		mercadorias = new ArrayList<Mercadoria>();
	}
	
	public void addMercadoria(Mercadoria mercadoria){
		this.mercadorias.add(mercadoria);
	}
	
	public boolean lucroMenor10(String nome){
		double valorPorcentagem = 0;
		
		for(Mercadoria mercadoria : mercadorias)
		{
			if (mercadoria.getNome() == nome){
				valorPorcentagem = (mercadoria.getPrecoVenda() * 10) / 100;
				if (mercadoria.getPrecoVenda() - mercadoria.getPrecoCompra() <= valorPorcentagem ){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean lucroMaior20(String nome){
		double valorPorcentagem = 0;
		
		for(Mercadoria mercadoria : mercadorias)
		{
			if (mercadoria.getNome() == nome){
				valorPorcentagem = (mercadoria.getPrecoVenda() * 10) / 100;
				if (mercadoria.getPrecoVenda() - mercadoria.getPrecoCompra() >= valorPorcentagem ){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean lucroMaior10Menor20(String nome){
		double valorPorcentagem = 0;
		
		for(Mercadoria mercadoria : mercadorias)
		{
			if (mercadoria.getNome() == nome){
				valorPorcentagem = (mercadoria.getPrecoVenda() * 10) / 100;
				if (mercadoria.getPrecoVenda() - mercadoria.getPrecoCompra() > valorPorcentagem && mercadoria.getPrecoVenda() - mercadoria.getPrecoCompra() < valorPorcentagem){
					return true;
				}
			}
		}
		return false;
	}
	
	public String lucro(){
		int menor10 = 0;
		int maior20 = 0;
		int maior10Menor20 = 0;
		for(Mercadoria mercadoria : mercadorias){
			if (lucroMenor10(mercadoria.getNome())){
				menor10++;
			} 
			else if (lucroMaior20(mercadoria.getNome())){
				maior20++;
			}
			else if (lucroMaior10Menor20(mercadoria.getNome())){
				maior10Menor20++;
			}
		}
		
		return "Lucro menor 10%: " + menor10 + "\n"
				+ "Lucro entre 10% e 20%: " + maior10Menor20 + "\n"
				+ "Lucro maior que 20%: " + maior20;
	}
	
	public String lucroTotal(){
		double compra = 0;
		double venda = 0;
		
		for (Mercadoria mercadoria : mercadorias){
			compra += mercadoria.getPrecoCompra();
			venda += mercadoria.getPrecoVenda();
		}
		return "Preço de Compra: " + compra + "\n"
				+ "Preço de Venda: " + venda + "\n"
				+ "Lucro Total: " + (venda - compra);
	}
	
	
}
