package br.com.gui.projetolocadora.ctrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gui.projetolocadora.dao.FilmeDAO;
import br.com.gui.projetolocadora.dto.BaseDTO;
import br.com.gui.projetolocadora.dto.CategoriaDTO;
import br.com.gui.projetolocadora.dto.FilmeDTO;
import br.com.gui.projetolocadora.dto.ListFilmeDTO;
import br.com.gui.projetolocadora.modelo.Categoria;
import br.com.gui.projetolocadora.modelo.Filme;

@Path("/filme")
public class FilmeCtrl extends BaseDTO {
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public FilmeDTO cadastrarFilme(FilmeDTO filmeDTO) {

		Filme filme = new Filme();
		FilmeDAO filmeDAO = new FilmeDAO();

		try {
			this.validarCamposObrigatorios(filmeDTO);
			filme = this.converterDTOEmFilme(filmeDTO);
			filmeDAO.criar(filme);
			filmeDTO.setId(filme.getId());
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem detalhada: ";
			filmeDTO.setMensagem(mensagem + e.getMessage());
		}

		return filmeDTO;
	}

	public Filme converterDTOEmFilme(FilmeDTO filmeDTO) {
		Calendar anoCalendar = Calendar.getInstance();
		Calendar duracaoCalendar = Calendar.getInstance();

		if (filmeDTO.getAno() != null) {
			try {
				SimpleDateFormat sdfDuracao = new SimpleDateFormat("hh:mm");
				anoCalendar.set(Integer.parseInt(filmeDTO.getAno()), 0, 1, 0, 0, 0);
				duracaoCalendar.setTime(sdfDuracao.parse(filmeDTO.getDuracao()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Filme filme = new Filme();

		filme.setId(filmeDTO.getId());
		filme.setDescricao(filmeDTO.getDescricao());
		filme.setAno(anoCalendar);
		filme.setResumo(filmeDTO.getResumo());
		filme.setClassificao(filmeDTO.getClassificacao());
		filme.setDuracao(duracaoCalendar);

		if (filmeDTO.getCategoriaDTO() != null) {
			Categoria categoria = new CategoriaCtrl().converterDTOEmCategoria(filmeDTO.getCategoriaDTO());
			filme.setCategoria(categoria);
		}

		return filme;

	}

	public void validarCamposObrigatorios(FilmeDTO filmeDTO) throws Exception {

		if (filmeDTO.getDescricao() == null || filmeDTO.getDescricao().isEmpty()) {
			throw new Exception("Campo Descrição é obrigatório.");
		}

		if (filmeDTO.getCategoriaDTO() == null || filmeDTO.getCategoriaDTO().getId() == null) {
			throw new Exception("Campo obrigatório.");
		}

	}

	@GET
	@Produces("application/json")
	@Path("/listar")
	public ListFilmeDTO listarFilmes() {
		ListFilmeDTO listFilmeDTO = new ListFilmeDTO();
		List<Filme> filmes = new ArrayList<Filme>();
		FilmeDAO filmeDAO = new FilmeDAO();
		List<FilmeDTO> filmesDTO = new ArrayList<FilmeDTO>();

		try {
			filmes = filmeDAO.pesq(null);

			for (Filme filme : filmes) {
				FilmeDTO filmeDTO = new FilmeDTO();
				filmeDTO = this.converterFilmeEmDTO(filme);
				filmesDTO.add(filmeDTO);

			}

			listFilmeDTO.setRetorno(filmesDTO);
		} catch (Exception e) {
			String mensagem = "Erro ao listar filmes. Mensagem detalhada: ";
			listFilmeDTO.setMensagem(mensagem + e.getMessage());
		}
		return listFilmeDTO;
	}

	public FilmeDTO converterFilmeEmDTO(Filme filme) {
		FilmeDTO filmeDTO = new FilmeDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

		filmeDTO.setId(filme.getId());
		filmeDTO.setDescricao(filme.getDescricao());
		filmeDTO.setAno(String.valueOf(filme.getAno().get(Calendar.YEAR)));
		filmeDTO.setResumo(filme.getResumo());
		filmeDTO.setClassificacao(filme.getClassificao());
		filmeDTO.setDuracao(sdf.format(filme.getDuracao().getTime()));

		CategoriaDTO categoriaDTO = new CategoriaCtrl().converterCategoriaEmDTO(filme.getCategoria());
		filmeDTO.setCategoriaDTO(categoriaDTO);

		return filmeDTO;
	}

}
