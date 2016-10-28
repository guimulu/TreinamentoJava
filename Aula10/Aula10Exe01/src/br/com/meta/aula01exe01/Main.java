package br.com.meta.aula01exe01;

import java.io.IOException;
import java.util.Scanner;

import br.com.meta.aula01exe01.agenda.*;

import br.com.meta.aula01exe01.agenda.contato.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean continua = true;
		String nomeAgenda;
		String opcao;
		Agenda agenda = new Agenda();
		System.out.print("DIGITE SEU NOME: ");
		nomeAgenda = input.nextLine();
		clearConsole();
		
		System.out.print("\t" + nomeAgenda + " SEJA BEM-VINDO A SUA AGENDA DE CONTATOS!");
		do{
			String nome;
			String telefone;
			String cpf_cnpj;
			System.out.print("\n\n\t\t AGENDA DE CONTATOS DO " + nomeAgenda + "!\n");
			System.out.print(" __________________________________________________\n");
			System.out.print("|[1] - Cadastrar novo Contato.                     |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[2] - Editar um contato existente.                |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[3] - Excluir um contato existente.               |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[4] - Listar todos os contatos existentes.        |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[5] - Procurar por um contato existente.          |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[6] - Exportar todos os contatos existentes.      |\n");
			System.out.print("+--------------------------------------------------+\n");
			System.out.print("|[0] - Para Sair.                                  |\n");
			System.out.print("|__________________________________________________|\n\n");
			opcao = input.nextLine();
			clearConsole();
			if (opcao.length() == 1){
				switch (opcao) {
				case "0":
					continua = false;
					break;
				//NOVO
				case "1":
					System.out.print("\nNome: ");
					nome = input.nextLine();
					System.out.print("\nTelefone: ");
					telefone = input.nextLine();
					System.out.print("\nCPF/CNPJ: ");
					cpf_cnpj = input.nextLine();
					if (!telefone.contains("^[a-Z")) {
						if (Validacoes.ValidaCPF_CNPJ(cpf_cnpj)){
							if (!agenda.validaCpfCnpjJaCadastrado(cpf_cnpj)){
								agenda.addContato(new Contato(nome, telefone, cpf_cnpj));
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCONTATO SALVO COM SUCESSO!");
							}
							else {
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCNPJ/CPF JÁ CADASTRADO!");
							}
						}
						else {
							System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCNPJ/CPF INVÁLIDO");
						}
					}
					else {
						System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nNUMERO DE TELEFONE INVÁLIDO");
					}
					break;
				//EDITAR
				case "2":
					System.out.print("\nInforme o CPF/CNPJ do contato: ");
					String cpf_cnpjVelho = input.nextLine();
					if (agenda.validaCpfCnpjJaCadastrado(cpf_cnpjVelho)){
						System.out.print("\nNome: ");
						nome = input.nextLine();
						System.out.print("\nTelefone: ");
						telefone = input.nextLine();
						System.out.print("\nCPF/CNPJ: ");
						cpf_cnpj = input.nextLine();
						if (Validacoes.ValidaCPF_CNPJ(cpf_cnpj)){
							if(agenda.editarContato(nome, telefone, cpf_cnpj, cpf_cnpjVelho))
								System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCONTATO ALTERADO COM SUCESSO!");
						}
						else {
							System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCNPJ/CPF INVÁLIDO");
						}
					}
					else {
						System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCONTATO NÃO ENCONTRADO");
					}
					break;
				//EXCLUIR	
				case "3":
					System.out.print("\nInforme o CPF/CNPJ do contato: ");
					cpf_cnpj = input.nextLine();
					if (agenda.validaCpfCnpjJaCadastrado(cpf_cnpj)){
						if (agenda.excluirContato(cpf_cnpj))
							System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCONTATO EXCLUÍDO COM SUCESSO!");
					}
					else {
						System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCONTATO NÃO ENCONTRADO");
					}
					break;
				//LISTAR	
				case "4":
					System.out.println(agenda.listarContatos());
					System.out.print("\n\n\n\n\nAPERTE ENTER PARA IR AO MENU PRINCIPAL!");
					input.nextLine();
					clearConsole();
					break;
				//PROCURAR	
				case "5":
					System.out.print("\nInforme o NOME ou o TELEFONE do contato: ");
					String nome_telefone = input.nextLine();
					System.out.println(agenda.procurarContato(nome_telefone));
					System.out.print("\n\n\n\n\n\n\n\n\nAPERTE ENTER PARA IR AO MENU PRINCIPAL!");
					input.nextLine();
					clearConsole();
					break;
				//EXPORTAR
				case "6":
					System.out.println(agenda.exportarContatos());
					System.out.print("\n\n\n\n\n\n\n\n\nAPERTE ENTER PARA IR AO MENU PRINCIPAL!");
					input.nextLine();
					clearConsole();
					break;
				//OPÇÃO INVÁLIDA
				default:
					System.out.print("\n\nOpção Inválida!");
					break;
				}
			} else System.out.print("\n\nOpção Inválida!");
		} while (continua);
		System.out.print("\n\n" + nomeAgenda + " VOCÊ SAIU DA SUA AGENDA DE CONTATOS :(");
	}
	
	public final static void clearConsole(){
		for(int i = 0; i < 100; i++)
		{
		       System.out.println("");
		}
	}

}
