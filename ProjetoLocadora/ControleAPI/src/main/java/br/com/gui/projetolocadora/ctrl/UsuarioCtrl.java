package br.com.gui.projetolocadora.ctrl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gui.projetolocadora.dao.ClienteDAO;
import br.com.gui.projetolocadora.dao.FuncionarioDAO;
import br.com.gui.projetolocadora.dao.UsuarioDAO;
import br.com.gui.projetolocadora.dto.BaseDTO;
import br.com.gui.projetolocadora.dto.CategoriaDTO;
import br.com.gui.projetolocadora.dto.ClienteDTO;
import br.com.gui.projetolocadora.dto.EnderecoDTO;
import br.com.gui.projetolocadora.dto.FuncionarioDTO;
import br.com.gui.projetolocadora.dto.ListClienteDTO;
import br.com.gui.projetolocadora.dto.ListFuncionarioDTO;
import br.com.gui.projetolocadora.modelo.Cliente;
import br.com.gui.projetolocadora.modelo.Endereco;
import br.com.gui.projetolocadora.modelo.Funcionario;
import br.com.gui.projetolocadora.modelo.Usuario;

@Path("/usuario")
public class UsuarioCtrl extends BaseDTO {
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarCliente")
	public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();

		try {
			this.validarCamposObrigatoriosCliente(clienteDTO);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = converterClienteDTOParaUsuario(clienteDTO);
			usuarioDAO.criar(usuario);
			
			cliente = this.converterDTOEmCliente(clienteDTO);
			cliente.setUsuario(usuario);
			clienteDAO.criar(cliente);
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem detalhada: ";
			clienteDTO.setMensagem(mensagem + e.getMessage());
		}

		return clienteDTO;
	}
	
	private Usuario converterClienteDTOParaUsuario(ClienteDTO clienteDTO) {
		Usuario usuario = new Usuario();
		
		usuario.setTelefone(clienteDTO.getTelefone());
		usuario.setNome(clienteDTO.getNome());
		usuario.setEmail(clienteDTO.getEmail());
		usuario.setCelular(clienteDTO.getCelular());
		usuario.setId(clienteDTO.getId());
		
		Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(clienteDTO.getEnderecoDTO());
		usuario.setEndereco(endereco);
		
		return usuario;
	}

	public Cliente converterDTOEmCliente(ClienteDTO clienteDTO){		
		Cliente cliente = new Cliente();
		
		cliente.setId(clienteDTO.getId());
		cliente.setUsuario(converterClienteDTOParaUsuario(clienteDTO));
		
		return cliente;
	}

	public void validarCamposObrigatoriosCliente(ClienteDTO clienteDTO) throws Exception{
		
		if (clienteDTO.getNome() == null || clienteDTO.getNome().isEmpty()){
			throw new Exception("Campo Nome é obrigatório.");
		}
		if (clienteDTO.getCelular() == null || clienteDTO.getCelular().isEmpty()){
			throw new Exception("Campo Celular é obrigatório.");
		}
		if (clienteDTO.getEmail() == null || clienteDTO.getEmail().isEmpty()){
			throw new Exception("Campo Email é obrigatório.");
		}
		if (clienteDTO.getTelefone() == null || clienteDTO.getTelefone().isEmpty()){
			throw new Exception("Campo Telefone é obrigatório.");
		}
		if (clienteDTO.getEnderecoDTO() == null || clienteDTO.getEnderecoDTO().getId() < 1){
			throw new Exception("Campo Endereço é obrigatório.");
		}
	}


	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrarFuncionario")
	public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		try {
			this.validarCamposObrigatoriosCliente(funcionarioDTO);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = converterFuncionarioDTOParaUsuario(funcionarioDTO);
			usuarioDAO.criar(usuario);
			
			funcionario = this.converterDTOEmFuncionario(funcionarioDTO);
			funcionario.setUsuario(usuario);
			funcionarioDAO.criar(funcionario);
		} catch (Exception e) {
			String mensagem = "Problema ao criar registro na base. Mensagem detalhada: ";
			funcionarioDTO.setMensagem(mensagem + e.getMessage());
		}

		return funcionarioDTO;
	}

	private Usuario converterFuncionarioDTOParaUsuario(FuncionarioDTO funcionarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setTelefone(funcionarioDTO.getTelefone());
		usuario.setNome(funcionarioDTO.getNome());
		usuario.setEmail(funcionarioDTO.getEmail());
		usuario.setCelular(funcionarioDTO.getCelular());
		usuario.setId(funcionarioDTO.getId());
		Endereco endereco = new EnderecoCtrl().converterDTOEmEndereco(funcionarioDTO.getEnderecoDTO());
		usuario.setEndereco(endereco);
		
		return usuario;
	}

	public Funcionario converterDTOEmFuncionario(FuncionarioDTO funcionarioDTO){		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(funcionarioDTO.getId());
		funcionario.setLogin(funcionarioDTO.getLogin());
		funcionario.setSenha(funcionarioDTO.getSenha());
		BigDecimal big = new BigDecimal(funcionarioDTO.getSalario());
		funcionario.setSalario(big);
		funcionario.setUsuario(converterFuncionarioDTOParaUsuario(funcionarioDTO));
		
		return funcionario;
	}

	public void validarCamposObrigatoriosCliente(FuncionarioDTO funcionarioDTO) throws Exception{
		
		if (funcionarioDTO.getNome() == null || funcionarioDTO.getNome().isEmpty()){
			throw new Exception("Campo Nome é obrigatório.");
		}
		if (funcionarioDTO.getCelular() == null || funcionarioDTO.getCelular().isEmpty()){
			throw new Exception("Campo Celular é obrigatório.");
		}
		if (funcionarioDTO.getEmail() == null || funcionarioDTO.getEmail().isEmpty()){
			throw new Exception("Campo Email é obrigatório.");
		}
		if (funcionarioDTO.getTelefone() == null || funcionarioDTO.getTelefone().isEmpty()){
			throw new Exception("Campo Telefone é obrigatório.");
		}
		if (funcionarioDTO.getEnderecoDTO() == null || funcionarioDTO.getEnderecoDTO().getId() < 1){
			throw new Exception("Campo Endereço é obrigatório.");
		}
		if (funcionarioDTO.getLogin() == null || funcionarioDTO.getLogin().isEmpty()){
			throw new Exception("Campo Login é obrigatório.");
		}
		if (funcionarioDTO.getSenha() == null || funcionarioDTO.getSenha().isEmpty()){
			throw new Exception("Campo Senha é obrigatório.");
		}
		if (funcionarioDTO.getSalario() == null || funcionarioDTO.getSalario() == 0){
			throw new Exception("Campo Salário é obrigatório.");
		}
	}
	
	
	@GET
	@Produces("application/json")
	@Path("/listarCliente")
	public ListClienteDTO listarClientes(){
		ListClienteDTO listClienteDTO = new ListClienteDTO();
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteDAO clienteDAO = new ClienteDAO();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();		
		
		try {
			clientes = clienteDAO.pesq(null);
			
			for (Cliente cliente : clientes){
				ClienteDTO clienteDTO = new ClienteDTO();
				clienteDTO = this.converterClienteEmDTO(cliente);
				clientesDTO.add(clienteDTO);
			}
			
			listClienteDTO.setRetorno(clientesDTO);
			
		} catch (Exception e) {
			String mensagem = "Erro ao listar filmes. Mensagem detalhada: ";
			listClienteDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return listClienteDTO;
	}

	private ClienteDTO converterClienteEmDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setIdCliente(cliente.getId());
		clienteDTO.setNome(cliente.getUsuario().getNome());
		clienteDTO.setCelular(cliente.getUsuario().getCelular());
		clienteDTO.setEmail(cliente.getUsuario().getEmail());
		clienteDTO.setId(cliente.getId());
		clienteDTO.setTelefone(cliente.getUsuario().getTelefone());
		
		EnderecoDTO enderecoDTO = new EnderecoCtrl().converteEnderecoEmDTO(cliente.getUsuario().getEndereco());
		clienteDTO.setEnderecoDTO(enderecoDTO);
		
		// TODO Auto-generated method stub
		return clienteDTO;
	}
	
	
	@GET
	@Produces("application/json")
	@Path("/listarFuncionario")
	public ListFuncionarioDTO listarFuncionarios(){
		ListFuncionarioDTO listFuncionarioDTO = new ListFuncionarioDTO();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<FuncionarioDTO> funcionariosDTO = new ArrayList<FuncionarioDTO>();		
		
		try {
			funcionarios = funcionarioDAO.pesq(null);
			
			for (Funcionario funcionario : funcionarios){
				FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
				funcionarioDTO = this.converterFuncionarioEmDTO(funcionario);
				funcionariosDTO.add(funcionarioDTO);
			}
			
			listFuncionarioDTO.setRetorno(funcionariosDTO);
			
		} catch (Exception e) {
			String mensagem = "Erro ao listar filmes. Mensagem detalhada: ";
			listFuncionarioDTO.setMensagem(mensagem + e.getMessage());
		}
		
		return listFuncionarioDTO;
	}

	private FuncionarioDTO converterFuncionarioEmDTO(Funcionario funcionario) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		
		funcionarioDTO.setIdFuncionario(funcionario.getId());
		funcionarioDTO.setLogin(funcionario.getLogin());
		funcionarioDTO.setSenha(funcionario.getSenha());
		funcionarioDTO.setSalario(funcionario.getSalario().doubleValue());
		funcionarioDTO.setNome(funcionario.getUsuario().getNome());
		funcionarioDTO.setCelular(funcionario.getUsuario().getCelular());
		funcionarioDTO.setEmail(funcionario.getUsuario().getEmail());
		funcionarioDTO.setId(funcionario.getId());
		funcionarioDTO.setTelefone(funcionario.getUsuario().getTelefone());
		
		EnderecoDTO enderecoDTO = new EnderecoCtrl().converteEnderecoEmDTO(funcionario.getUsuario().getEndereco());
		funcionarioDTO.setEnderecoDTO(enderecoDTO);
		
		
		return funcionarioDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
