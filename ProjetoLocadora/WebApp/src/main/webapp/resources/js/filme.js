function listarFilme() {
	var operacao = "/ControleAPI/filme/listar"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data.retorno;
			var linhaTabela = '<tr><td>#</td><td>Ano</td><td>Classificação</td><td>Descrição</td><td>Duração</td><td>Resumo</td><td>Categoria</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="ano">';
				linhaTabela += lista[i].ano;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="classificacao">';
				linhaTabela += lista[i].classificacao;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="descricao">';
				linhaTabela += lista[i].descricao;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="duracao">';
				linhaTabela += lista[i].duracao;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="resumo">';
				linhaTabela += lista[i].resumo;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="categoria">';
				linhaTabela += lista[i].categoriaDTO.descricao;
				linhaTabela += '</td>';

				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}

function preencherDropdownCategoria() {
	var operacao = "/ControleAPI/categoriactrl/listarCategorias"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data;
			var linhaTabela = '';
			
			$('#dropdown-categoria').html('');
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<option value="'+lista[i].id+'" >';
				linhaTabela += lista[i].descricao;
				linhaTabela += '</option>';
			}
			$('#dropdown-categoria').append(linhaTabela);
			
		});
		
}

function cadastrarFilme() {
	var descricao = $("#descricao-filme").val();
	var resumo = $("#resumo-filme").val();
	var duracao = $("#duracao-filme").val();
	var ano = $("#ano-filme").val();
	var classificacao = $("#classificacao-filme").val();
	var categoria = $("#dropdown-categoria").val();
	
	var filmeDTO = new Object();
	var operacao = "/ControleAPI/filme/cadastrar"
	filmeDTO.descricao = descricao;
	filmeDTO.resumo = resumo;
	filmeDTO.duracao = duracao;
	filmeDTO.ano = ano;
	filmeDTO.classificacao = classificacao;
	filmeDTO.categoriaDTO = new Object() 
	filmeDTO.categoriaDTO.id = categoria;
	
	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(filmeDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titutlo = '';
		if(data.mensagem != null && data.mensagem != '' && data.mensagem != undefined){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = 'Sucesso!';
			mensagem = 'Endereço cadastrado com sucesso!';
			resetaCampos();
		}
		mostrarModal(titulo, mensagem);
	});

}

function resetaCampos(){
	 $(":text").each(function () {
         $(this).val("");
     });
}

function mostrarModal(titulo, mensagem) {
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	$('#modal-mensagens').modal('show');
}