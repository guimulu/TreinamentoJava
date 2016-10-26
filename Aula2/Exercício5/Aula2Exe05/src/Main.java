
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Porta door = new Porta(
			false, 
			"branco", 
			5, 
			5,
			5
		);
		
		door.abre();
		door.fecha();
		door.pinta("azul");
		door.pinta("verde");
		door.pinta("preto");
		door.pinta("laranja");
		door.setDimensaoX(8);
		door.setDimensaoY(8);
		door.setDimensaoZ(8);
		System.out.println(door.estaAberta());
		
		Casa casa = new Casa();
		casa.setCor("verde");
		casa.addPortas(new Porta(
				false,
				"azul",
				10,
				10,
				5
			)
		);
		casa.addPortas(new Porta(
				true,
				"amarelo", 
				5, 
				15, 
				5
			)
		);
		casa.addPortas(new Porta(
				true, 
				"cinza", 
				15,
				5,
				10
			)
		);
		System.out.println("Portas Abertas: " + casa.quantasPortasEstaoAbertas());
		
		Edificio edificio = new Edificio("bege");
		
		edificio.adicionaPorta(
			new Porta(
					false, 
					"preto",
					7, 
					4,
					9
				)
			);
		edificio.adicionaPorta(
			new Porta(
					true,
					"rosa", 
					7, 
					4, 
					9
			)
		);
		edificio.adicionaPorta(
			new Porta(
				false,
				"vermelho", 
				7, 
				4, 
				9
			)
		);
		System.out.println("Portas Abertas " + edificio.quantasPortasEstaoAbertas());
		System.out.println("Total de Portas " + edificio.totalDePortas());
		edificio.adicionarAndar(new Andar(1));
		edificio.adicionarAndar(new Andar(2));
		edificio.adicionarAndar(new Andar(3));
		System.out.println("Total de Andares " + edificio.totalDeAndares());
		
	}

}
