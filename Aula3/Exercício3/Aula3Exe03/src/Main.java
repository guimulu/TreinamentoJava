
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loja loja = new Loja();
		
		loja.addMercadoria(new Mercadoria("Mouse", 10, 12));
		loja.addMercadoria(new Mercadoria("Caneta", 1, 1.5));
		loja.addMercadoria(new Mercadoria("Monitor", 600, 659));
		loja.addMercadoria(new Mercadoria("Switch", 120, 125));
		loja.addMercadoria(new Mercadoria("Cadeira", 80, 82));
		
		System.out.println(loja.lucro());
		System.out.println(loja.lucroTotal());
		
	}
}
