function abrirTelaCadastroCategoria() {
	var url = "/WebApp/categoria/cadastro.html";
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarCategorias() {
	var url = "/WebApp/categoria/pesquisa.html";
	$.get(url, '', function(data){
		listarCategorias();
		$('#conteudo-principal').html(data);
	})
}	

function abrirTelaCadastrarEnderecos() {
	var url = "/WebApp/endereco/cadastro.html";
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarEnderecos() {
	var url = "/WebApp/endereco/lista.html";
	$.get(url, '', function(data){
		listarEnderecos();
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastrarTipoMidia() {
	var url = "/WebApp/tipo_midia/cadastro.html";
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarTipoMidia() {
	var url = "/WebApp/tipo_midia/lista.html";
	$.get(url, '', function(data){
		listarTipoMidia();
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastrarFilme() {
	var url = "/WebApp/filme/cadastro.html";
	$.get(url, '', function(data){
		preencherDropdownCategoria();
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarFilme() {
	var url = "/WebApp/filme/lista.html";
	$.get(url, '', function(data){
		listarFilme();
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaCadastrarUsuario() {
	var url = "/WebApp/usuario/cadastro.html";
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarUsuario() {
	var url = "/WebApp/usuario/lista.html";
	$.get(url, '', function(data){
		$('#conteudo-principal').html(data);
	})
}
function abrirTelaCadastrarMidia() {
	var url = "/WebApp/midia/cadastro.html";
	$.get(url, '', function(data){
		preencherDropdownFilme();
		preencherDropdownTipoMidia();		
		$('#conteudo-principal').html(data);
	})
}

function abrirTelaListarMidia() {
	var url = "/WebApp/midia/lista.html";
	$.get(url, '', function(data){
		listarMidia();
		$('#conteudo-principal').html(data);
	})
}