package br.com.meta.aula01exe01.agenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import br.com.meta.aula01exe01.agenda.contato.*;

public class Agenda {
	private ArrayList<Contato> contatos;
	
	public Agenda(){
		contatos = new ArrayList<Contato>();
	}
	
	public void addContato(Contato contato){
		this.contatos.add(contato);
	}
	
	public boolean validaCpfCnpjJaCadastrado(String cpf_cnpj){
		for (Contato contato : contatos){
			if (contato.getCpf_cnpj().equals(cpf_cnpj))
				return true;
		}
		return false;
	}
	
	public boolean editarContato(String nome, String telefone, String cpf_cnpjNovo, String cpf_cnpjVelho){
		for (Contato contato : contatos){
			if (contato.getCpf_cnpj().equals(cpf_cnpjVelho)){
				contato.setNome(nome);
				contato.setTelefone(telefone);
				contato.setCpf_cnpj(cpf_cnpjNovo);
				return true;
			}
		}
		return false;
	}
	
	public boolean excluirContato(String cpf_cnpj){
		for (Contato contato : contatos){
			if (contato.getCpf_cnpj().equals(cpf_cnpj)){
				contatos.remove(contato);
				return true;
			}
		}
		return false;
	}
	
	public String listarContatos(){
		String texto = "";
		for (Contato contato : contatos){
			texto += "\n\n\n" + "Nome: " + contato.getNome() + "\nTelefone: " + contato.getTelefone() + "\nCPF/CNPJ: " + contato.getCpf_cnpj();
		}
		if (texto.length() < 2)
			return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nAGENDA VAZIA!";
		else
			return texto;
	}
	
	public String procurarContato(String nome_telefone){
		String texto = "";
		for (Contato contato : contatos){
			if (contato.getNome().equals(nome_telefone)){
				texto += "\n\n" + " Telefone do " + contato.getNome() + " é: " + contato.getTelefone();
			}
			else if (contato.getTelefone().equals(nome_telefone)){
				texto += "\n\n" + " O número " + contato.getTelefone() + " é do " + contato.getNome();
			}
		}
		if (texto.length() < 2)
			return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nNÃO FOI ENCONTRADO NENHUM CONTATO COM ESSES PARAMETROS!";
		else
			return texto;
	}
	
	public String exportarContatos() throws IOException{
		String texto = listarContatos();
		FileWriter arq = new FileWriter("Contatos.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.print(texto);
		gravarArq.close();
		return "DADOS EXPORTADOS COM SUCESSO!";
	}

}
