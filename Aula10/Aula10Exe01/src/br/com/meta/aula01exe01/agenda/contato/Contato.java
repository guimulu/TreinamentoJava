package br.com.meta.aula01exe01.agenda.contato;

public class Contato {
	private String nome;
	private String telefone;
	private String cpf_cnpj;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public Contato(String nome, String telefone, String cpf_cnpj) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf_cnpj = cpf_cnpj;
	}  
	
}
