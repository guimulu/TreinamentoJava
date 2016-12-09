package br.com.gui.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gui.projetolocadora.dao.TipoMidiaDAO;
import br.com.gui.projetolocadora.dto.TipoMidiaDTO;
import br.com.gui.projetolocadora.modelo.TipoMidia;

@Path("/tipomidiactrl")
public class TipoMidiaCtrl{
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarTipoMidia")
	public TipoMidiaDTO criarTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		TipoMidiaDAO tipoMidiaDAO = new TipoMidiaDAO();
		TipoMidia tipoMidia = new TipoMidia();
		try {
			this.validarCamposObrigatorios(tipoMidiaDTO);
			tipoMidia = this.converterDTOEmTipoMidia(tipoMidiaDTO);
			tipoMidiaDAO.criar(tipoMidia);
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar registro: mensagem detelhada: ";
			tipoMidiaDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return tipoMidiaDTO;
	}
	
	public TipoMidia converterDTOEmTipoMidia(TipoMidiaDTO tipoMidiaDTO){
		TipoMidia tipoMidia = new TipoMidia();
		
		tipoMidia.setId(tipoMidiaDTO.getId());
		tipoMidia.setDescricao(tipoMidiaDTO.getDescricao());
		
		return tipoMidia;
	}
	
	public void validarCamposObrigatorios(TipoMidiaDTO tipoMidiaDTO) throws Exception{
		if (tipoMidiaDTO.getDescricao() == null || tipoMidiaDTO.getDescricao().isEmpty()){
			throw new Exception("Campo é obrigatório.");
		}
	}

	public TipoMidiaDTO converterTipoMidiaEmDTO(TipoMidia tipoMidia){
		TipoMidiaDTO tipoMidiaDTO = new TipoMidiaDTO();
		
		tipoMidiaDTO.setId(tipoMidia.getId());
		tipoMidiaDTO.setDescricao(tipoMidia.getDescricao());
		
		return tipoMidiaDTO;
	}
	
	@GET
	@Produces("application/json")
	@Path("/listarTipoMidia")
	public List<TipoMidiaDTO> listarTipoMidia(){
		List<TipoMidiaDTO> tipoMidiasDTO = new ArrayList<TipoMidiaDTO>();
		List<TipoMidia> tipoMidias = new ArrayList<TipoMidia>();
		TipoMidiaDAO tipoMidiaDAO = new TipoMidiaDAO();
		
		try {
			tipoMidias = tipoMidiaDAO.pesq(null);
			for (TipoMidia tipoMidia : tipoMidias){
				TipoMidiaDTO tipoMidiaDTO = this.converterTipoMidiaEmDTO(tipoMidia);
				tipoMidiasDTO.add(tipoMidiaDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tipoMidiasDTO;
 	}
	
		
}
