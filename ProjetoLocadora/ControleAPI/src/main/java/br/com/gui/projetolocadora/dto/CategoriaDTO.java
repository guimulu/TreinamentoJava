package br.com.gui.projetolocadora.dto;

public class CategoriaDTO extends BaseDTO{

	private Integer id;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
