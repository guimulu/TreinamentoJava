function abrirPropriedadesDoUsuario() {
	var url = "/WebApp/usuario/funcionario.html";
	$.get(url, '', function(data) {
		$('#conteudo-secundario').html(data);
	})
}

function fecharPropriedadesDoUsuario() {
	var url = "/WebApp/usuario/cliente.html";
	$.get(url, '', function(data) {
		$('#conteudo-secundario').html(data);
	})
}

function mostrarListaCliente() {
	var url = "/WebApp/usuario/listaClienteFuncionario.html";
	$.get(url, '', function(data) {
		 listarCliente();
		$('#conteudo-secundario').html(data);
	})
}

function mostrarListaFuncionario() {
	var url = "/WebApp/usuario/listaClienteFuncionario.html";
	$.get(url, '', function(data) {
		 listarFuncionario();
		$('#conteudo-secundario').html(data);
	})
}

function cadastrarUsuario() {
	var tipoUsuario = $('input[name=tipo-usuario]:checked').val();

	if (tipoUsuario === undefined) {
		mostrarModal('Atenção', 'Selecione o tipo de usuário');
	} else if (tipoUsuario == 0) {
		cadastrarUsuarioCliente();
	} else if (tipoUsuario == 1) {
		cadastrarUsuarioFuncionario();
	}
}

function cadastrarUsuarioCliente() {
	var nome = $("#nome-usuario").val();
	var email = $("#email-usuario").val();
	var celular = $("#celular-usuario").val();
	var telefone = $("#telefone-usuario").val();
	var endereco = $("#endereco-usuario").val();

	var clienteDTO = new Object();
	var operacao = "/ControleAPI/usuario/cadastrarCliente"
	clienteDTO.nome = nome;
	clienteDTO.email = email;
	clienteDTO.celular = celular;
	clienteDTO.telefone = telefone;
	clienteDTO.enderecoDTO = new Object();
	clienteDTO.enderecoDTO.id = endereco;

	$.ajax({
		method : "POST",
		url : operacao,
		data : JSON.stringify(clienteDTO),
		contentType : "application/json"
	}).done(
			function(data) {
				var mensagem = '';
				var titutlo = '';
				if (data.mensagem != null && data.mensagem != ''
						&& data.mensagem != undefined) {
					titulo = 'Atenção';
					mensagem = data.mensagem;
				} else {
					titulo = 'Sucesso!';
					mensagem = 'Cliente cadastrado com sucesso!';
					resetaCampos();
				}
				mostrarModal(titulo, mensagem);
			});

}

function cadastrarUsuarioFuncionario() {
	var nome = $("#nome-usuario").val();
	var email = $("#email-usuario").val();
	var celular = $("#celular-usuario").val();
	var telefone = $("#telefone-usuario").val();
	var endereco = $("#endereco-usuario").val();
	var login = $("#login-funcionário").val();
	var senha = $("#senha-funcionario").val();
	var salario = $("#salario-funcionario").val();
	
	var funcionarioDTO = new Object();
	var operacao = "/ControleAPI/usuario/cadastrarFuncionario"
	funcionarioDTO.nome = nome;
	funcionarioDTO.email = email;
	funcionarioDTO.celular = celular;
	funcionarioDTO.telefone = telefone;
	funcionarioDTO.enderecoDTO = new Object();
	funcionarioDTO.enderecoDTO.id = endereco;
	funcionarioDTO.login = login;
	funcionarioDTO.senha = senha;
	funcionarioDTO.salario = salario;

	$.ajax({
		method : "POST",
		url : operacao,
		data : JSON.stringify(funcionarioDTO),
		contentType : "application/json"
	}).done(
			function(data) {
				var mensagem = '';
				var titutlo = '';
				if (data.mensagem != null && data.mensagem != ''
						&& data.mensagem != undefined) {
					titulo = 'Atenção';
					mensagem = data.mensagem;
				} else {
					titulo = 'Sucesso!';
					mensagem = 'Funcionário cadastrado com sucesso!';
					resetaCampos();
				}
				mostrarModal(titulo, mensagem);
			});

}

function resetaCampos() {
	$(":text").each(function() {
		$(this).val("");
	});
}

function mostrarModal(titulo, mensagem) {
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	$('#modal-mensagens').modal('show');
}

function listarCliente() {
	var operacao = "/ControleAPI/usuario/listarCliente"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data.retorno;
			var linhaTabela = '<tr><td>#</td><td>Nome</td><td>E-mail</td><td>Celular</td><td>Telefone</td><td>Endereço</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="nome">';
				linhaTabela += lista[i].nome;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="email">';
				linhaTabela += lista[i].email;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="celular">';
				linhaTabela += lista[i].celular;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="telefone">';
				linhaTabela += lista[i].telefone;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="endereco">';
				linhaTabela += lista[i].endereco;
				linhaTabela += '</td>';

				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}

function listarFuncionario() {
	var operacao = "/ControleAPI/usuario/listarFuncionario"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data.retorno;
			var linhaTabela = '<tr><td>#</td><td>Nome</td><td>E-mail</td><td>Celular</td><td>Telefone</td><td>Endereço</td><td>Login</td><td>Salario</td><td>Senha</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="nome">';
				linhaTabela += lista[i].nome;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="email">';
				linhaTabela += lista[i].email;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="celular">';
				linhaTabela += lista[i].celular;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="telefone">';
				linhaTabela += lista[i].telefone;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="endereco">';
				linhaTabela += lista[i].endereco;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="login">';
				linhaTabela += lista[i].login;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="salario">';
				linhaTabela += lista[i].salario;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="senha">';
				linhaTabela += lista[i].senha;
				linhaTabela += '</td>';

				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}
