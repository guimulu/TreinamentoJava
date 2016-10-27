import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
        System.out.println("Quantidade de litros (Gasolina):");
        int qtdGasolina = input.nextInt();
        
        Combustivel gasolina = new Combustivel();
		gasolina.setNomeCombustivel("Gasolina");
		gasolina.setPreco(3.39f);
		gasolina.setPrecoDesconto(3.39f);		
		
        Bico bicoGasolina = new Bico();
		bicoGasolina.setCombustivel(gasolina);
		bicoGasolina.setQtdCombustivel(qtdGasolina);			
		
		
        System.out.println("Quantidade de litros (Alcool):");
        int qtdAlcool = input.nextInt();
        
		Combustivel alcool = new Combustivel();
		alcool.setNomeCombustivel("Alcool");
		alcool.setPreco(2.57f);
		alcool.setPrecoDesconto(2.10f);
		
        Bico bicoAlcool = new Bico();
        bicoAlcool.setCombustivel(alcool);
        bicoAlcool.setQtdCombustivel(qtdAlcool);

        
        Posto posto = new Posto();
        posto.AddBicos(bicoGasolina);
        posto.AddBicos(bicoAlcool);

        System.out.println("Total a pagar: " + posto.CalcularTotal());
	}

}
