package br.com.gui.projetolocadora.dto;

import java.util.Calendar;

public class FilmeDTO extends BaseDTO{
	private Integer id;
	private String descricao;
	private Calendar anoCalendar;
	private String ano;
	private String resumo;
	private Integer classificacao;
	private Calendar duracaoCalendar;
	private String duracao;
	private CategoriaDTO categoriaDTO;
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getAnoCalendar() {
		return anoCalendar;
	}
	public void setAnoCalendar(Calendar anoCalendar) {
		this.anoCalendar = anoCalendar;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Integer getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Calendar getDuracaoCalendar() {
		return duracaoCalendar;
	}
	public void setDuracaoCalendar(Calendar duracaoCalendar) {
		this.duracaoCalendar = duracaoCalendar;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}
	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}
		
}
