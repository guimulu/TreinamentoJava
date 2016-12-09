package br.com.gui.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gui.projetolocadora.dao.MidiaDAO;
import br.com.gui.projetolocadora.dto.BaseDTO;
import br.com.gui.projetolocadora.dto.FilmeDTO;
import br.com.gui.projetolocadora.dto.ListMidiaDTO;
import br.com.gui.projetolocadora.dto.MidiaDTO;
import br.com.gui.projetolocadora.dto.TipoMidiaDTO;
import br.com.gui.projetolocadora.modelo.Filme;
import br.com.gui.projetolocadora.modelo.Midia;
import br.com.gui.projetolocadora.modelo.TipoMidia;

@Path("/midia")
public class MidiaCtrl extends BaseDTO {

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarMidia")
	public MidiaDTO cadastrarMidia(MidiaDTO midiaDTO) {
		Midia midia = new Midia();
		MidiaDAO midiaDAO = new MidiaDAO();

		try {
			this.validarCamposObrigatorios(midiaDTO);
			midia = this.converterDTOEmMidia(midiaDTO);
			midiaDAO.criar(midia);
			midiaDTO.setId(midia.getId());
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem detalhada: ";
			midiaDTO.setMensagem(mensagem + e.getMessage());
		}

		return midiaDTO;
	}

	public Midia converterDTOEmMidia(MidiaDTO midiaDTO) {
		Midia midia = new Midia();

		midia.setId(midiaDTO.getId());
		midia.setInutilizada(new Boolean(midiaDTO.getInutilizada()));
		TipoMidia tipoMidia = new TipoMidiaCtrl().converterDTOEmTipoMidia(midiaDTO.getTipoMidiaDTO());
		midia.setTipoMidia(tipoMidia);
		Filme filme = new FilmeCtrl().converterDTOEmFilme(midiaDTO.getFilmeDTO());
		midia.setFilme(filme);

		return midia;
	}

	public void validarCamposObrigatorios(MidiaDTO midiaDTO) throws Exception {
		
		if (midiaDTO.getFilmeDTO().getId() == null || midiaDTO.getFilmeDTO().getId() < 1) {
			throw new Exception("Selecione o Filme.");
		}

		if (midiaDTO.getTipoMidiaDTO().getId() == null || midiaDTO.getTipoMidiaDTO().getId() < 1) {
			throw new Exception("Selecione a Midia.");
		}

	}
	
	@GET
	@Produces("application/json")
	@Path("/listarMidia")
	public ListMidiaDTO listarMidias() {
		ListMidiaDTO listMidiaDTO = new ListMidiaDTO();
		List<Midia> midias = new ArrayList<Midia>();
		MidiaDAO midiaDAO = new MidiaDAO();
		List<MidiaDTO> midiasDTO = new ArrayList<MidiaDTO>();
		
		try {
			midias = midiaDAO.pesq(null);
			
			for (Midia midia : midias) {
				MidiaDTO midiaDTO = new MidiaDTO();
				midiaDTO = this.converterMidiasEmDTO(midia);
				midiasDTO.add(midiaDTO);
			}
			
			listMidiaDTO.setRetorno(midiasDTO);
			
		} catch (Exception e) {
			String mensagem = "Erro ao listar filmes. Mensagem detalhada: ";
			listMidiaDTO.setMensagem(mensagem + e.getMessage());
		}
		
		
		return listMidiaDTO;
	}

	private MidiaDTO converterMidiasEmDTO(Midia midia) {
		MidiaDTO midiaDTO = new MidiaDTO();
		
		midiaDTO.setId(midia.getId());
		midiaDTO.setInutilizada(midia.getInutilizada().toString());
		
		FilmeDTO filmeDTO = new FilmeCtrl().converterFilmeEmDTO(midia.getFilme());
		midiaDTO.setFilmeDTO(filmeDTO);
		
		TipoMidiaDTO tipoMidiaDTO = new TipoMidiaCtrl().converterTipoMidiaEmDTO(midia.getTipoMidia());
		midiaDTO.setTipoMidiaDTO(tipoMidiaDTO);
		
		return midiaDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
