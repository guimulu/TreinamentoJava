
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moto moto = new Moto("Honda", "2016", "Preta");
		moto.setMenorMarcha(0);
		moto.setMaiorMarcha(5);
		System.out.println(moto.imprimir());
		moto.marchaAcima(8);
		System.out.println(moto.imprimir());
		moto.marchaAcima(3);
		System.out.println(moto.imprimir());
		moto.marchaAbaixo(1);
		System.out.println(moto.imprimir());
	}

}
