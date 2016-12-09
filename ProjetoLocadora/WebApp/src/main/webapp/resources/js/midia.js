function listarMidia() {
	var operacao = "/ControleAPI/midia/listarMidia"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data.retorno;
			var linhaTabela = '<tr><td>#</td><td>Inutlizada</td><td>Filme</td><td>Tipo Midia</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="inutlizada">';
				linhaTabela += (lista[i].inutilizada == 'true') ? 'Sim' : 'Não';
				linhaTabela += '</td>';
				
				console.log(lista[i].inutilizada);
				
				linhaTabela += '<td class="filme">';
				linhaTabela += lista[i].filmeDTO.descricao;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="tipoMidia">';
				linhaTabela += lista[i].tipoMidiaDTO.descricao;
				linhaTabela += '</td>';

				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}

function preencherDropdownFilme() {
	var operacao = "/ControleAPI/filme/listar"
		$.ajax({
			url: operacao
		}).done(function (data){
			var lista = data.retorno;
			var linhaTabela = '';
			
			$('#dropdown-filme').html('');
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<option value="'+lista[i].id+'" >';
				linhaTabela += lista[i].descricao;
				linhaTabela += '</option>';
			}
			$('#dropdown-filme').append(linhaTabela);
			
		});	
}

function preencherDropdownTipoMidia() {
	var operacao = "/ControleAPI/tipomidiactrl/listarTipoMidia"
		$.ajax({
			url: operacao
		}).done(function (data){
			var lista = data;
			var linhaTabela = '';
			
			$('#dropdown-tipoMidia').html('');
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<option value="'+lista[i].id+'" >';
				linhaTabela += lista[i].descricao;
				linhaTabela += '</option>';
			}
			$('#dropdown-tipoMidia').append(linhaTabela);
			
		});	
}

function cadastrarMidia() {
	var inutilizada = $('input[name=inutilizada]:checked').val();
	var filme = $("#dropdown-filme").val();
	var tipoMidia = $("#dropdown-tipoMidia").val();
	
	var midiaDTO = new Object();
	var operacao = "/ControleAPI/midia/cadastrarMidia"
	midiaDTO.inutilizada = inutilizada;
	midiaDTO.filmeDTO = new Object();
	midiaDTO.filmeDTO.id = filme
	midiaDTO.tipoMidiaDTO = new Object();
	midiaDTO.tipoMidiaDTO.id = tipoMidia;

	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(midiaDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titutlo = '';
		if(data.mensagem != null && data.mensagem != '' && data.mensagem != undefined){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = 'Sucesso!';
			mensagem = 'Midia cadastrada com sucesso!';
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