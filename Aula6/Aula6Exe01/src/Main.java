import java.util.Scanner;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int quemEh;
		boolean transacao = false;
		boolean jaRepos = false;
		Scanner input = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		
		do {
			System.out.println("Digite 1 para Usuário do Banco ou 2 para Cliente? ");
			quemEh = input.nextInt();
			input.nextLine();
			switch (quemEh){
				case 1:
					System.out.println("Digite a senha: ");
					String senha = input.nextLine();
					if (pessoa.verificaSenha(senha)){
						System.out.println(pessoa.valorDisponivel());
						System.out.println("\n Deseja repor cédulas? (s/n)");
						String escolha = input.nextLine();
						if (escolha.equals("s")){
							
							System.out.println("Quantidade de cédulas de 50: ");
							int cedula50 = input.nextInt();
							System.out.println("Quantidade de cédulas de 20: ");
							int cedula20 = input.nextInt();
							System.out.println("Quantidade de cédulas de 10: ");
							int cedula10 = input.nextInt();
							System.out.println("Quantidade de cédulas de  5: ");
							int cedula5 = input.nextInt();
							System.out.println("Quantidade de cédulas de  2: ");
							int cedula2 = input.nextInt();
							input.nextLine();
							
							if (!jaRepos){
								pessoa.addCedulas(new Cedula(50, cedula50));
								pessoa.addCedulas(new Cedula(20, cedula20));
								pessoa.addCedulas(new Cedula(10, cedula10));
								pessoa.addCedulas(new Cedula(5 , cedula5));
								pessoa.addCedulas(new Cedula(2 , cedula2));
								System.out.println(pessoa.valorDisponivel());
								jaRepos = true;
							}
							else{
								pessoa.reporNotas(50, cedula50);
								pessoa.reporNotas(20, cedula20);
								pessoa.reporNotas(10, cedula10);
								pessoa.reporNotas(5, cedula5);
								pessoa.reporNotas(2, cedula2);
							}
						}
					}
					System.out.println("Deseja continuar no banco? (s/n)");
					String escolha = input.nextLine();
					if (escolha.equals("s"))
						transacao = true;
					else 
						transacao = false;
					break;
				case 2:
					System.out.println(pessoa.valorDisponivel());
					
					System.out.println("Digite o valor do saque: ");
					int valorSaque = input.nextInt();
					input.nextLine();
					System.out.println(pessoa.sacar(valorSaque));
					System.out.println(pessoa.valorDisponivel());
					
					
					System.out.println("Deseja continuar no banco? (s/n)");
					String escolha2 = input.nextLine();
					if (escolha2.equals("s"))
						transacao = true;
					else 
						transacao = false;
					break;
				
				default:
					transacao = true;
					break;
			}
		} while (transacao);
	}
}