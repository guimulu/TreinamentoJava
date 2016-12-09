package br.com.gui.projetolocadora.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gui.projetolocadora.dao.EnderecoDAO;
import br.com.gui.projetolocadora.dto.EnderecoDTO;
import br.com.gui.projetolocadora.modelo.Endereco;

@Path("/enderecoctrl")
public class EnderecoCtrl {
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/criarEndereco")
	public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO){
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = new Endereco();
		try {
			this.validarCamposObrigatorios(enderecoDTO);
			endereco = this.converterDTOEmEndereco(enderecoDTO);
			enderecoDAO.criar(endereco);
		} catch (Exception e) {
			String mensagemErro = "Problemas ao criar endereço: mensagem detelhada: ";
			enderecoDTO.setMensagem(mensagemErro + e.getMessage());
		}
		
		return enderecoDTO;
	}
	
	public Endereco converterDTOEmEndereco(EnderecoDTO enderecoDTO){
		Endereco endereco = new Endereco();
		
		endereco.setId(enderecoDTO.getId());
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setEstado(enderecoDTO.getEstado());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());
		
		return endereco;
	}
	
	public void validarCamposObrigatorios(EnderecoDTO enderecoDTO) throws Exception{
		if (enderecoDTO.getCep() == null || enderecoDTO.getCep().isEmpty()){
			throw new Exception("Campo CEP é obrigatório.");
		}
		if (enderecoDTO.getBairro() == null || enderecoDTO.getBairro().isEmpty()){
			throw new Exception("Campo BAIRRO é obrigatório.");
		}
		if (enderecoDTO.getRua() == null || enderecoDTO.getRua().isEmpty()){
			throw new Exception("Campo RUA é obrigatório.");
		}
		if (enderecoDTO.getNumero() == null || enderecoDTO.getNumero() <= 0){
			throw new Exception("Campo NÚMERO é obrigatório.");
		}
		if (enderecoDTO.getCidade() == null || enderecoDTO.getCidade().isEmpty()){
			throw new Exception("Campo CIDADE é obrigatório.");
		}
		if (enderecoDTO.getEstado() == null || enderecoDTO.getEstado().isEmpty()){
			throw new Exception("Campo ESTADO é obrigatório.");
		}
	}
	
	
	@GET
	@Produces("application/json")
	@Path("/listarEnderecos")
	public List<EnderecoDTO> listarEnderecos(){
		List<EnderecoDTO> enderecosDTO = new ArrayList<EnderecoDTO>();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		try {
			enderecos = enderecoDAO.pesq(null);
			for (Endereco endereco : enderecos){
				EnderecoDTO enderecoDTO = this.converteEnderecoEmDTO(endereco);
				enderecosDTO.add(enderecoDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return enderecosDTO;
	}
	
	public EnderecoDTO converteEnderecoEmDTO(Endereco endereco){
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setId(endereco.getId());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setEstado(endereco.getEstado());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setRua(endereco.getRua());
		
		
		
		return enderecoDTO;
	}
	
}
