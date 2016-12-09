package br.com.gui.projetolocadora.dao;

import org.hibernate.Criteria;

import br.com.gui.projetolocadora.modelo.Locacao;
import br.com.gui.projetolocadora.util.PesquisaBean;

public class LocacaoDAO extends GenericoDAO<Locacao, Integer> {

	@Override
	protected void setAtributoPesq(Criteria crit, PesquisaBean pesquisaBean) throws Exception {
		Locacao o = (Locacao) pesquisaBean.getEntidade();
		
		if(o == null){
			return;
		}
	}

}
