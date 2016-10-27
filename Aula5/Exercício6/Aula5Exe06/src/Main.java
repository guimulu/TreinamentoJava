
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moto moto = new Moto("Honda", "2016", "Preta");
		System.out.println(moto.imprimir());
		moto.marchaAcima();
		System.out.println(moto.imprimir());
		moto.marchaAcima();
		System.out.println(moto.imprimir());
		moto.marchaAbaixo();
		System.out.println(moto.imprimir());
	}

}
