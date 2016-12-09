function cadastrarTipoMidia() {
	var descricao = $("#descricao-tipoMidia").val();
	var tipoMidiaDTO = new Object();
	var operacao = "/ControleAPI/tipomidiactrl/criarTipoMidia"
	tipoMidiaDTO.descricao = descricao;
	
	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(tipoMidiaDTO),
		contentType: "application/json"
	}).done(function (data){
		var mensagem = '';
		var titutlo = '';
		if(data.mensagem != null && data.mensagem != '' && data.mensagem != undefined){
			titulo = 'Atenção';
			mensagem = data.mensagem;
		}else{
			titulo = 'Sucesso!';
			mensagem = 'Tipo de Midia cadastrada com sucesso!';
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

function listarTipoMidia() {
	var operacao = "/ControleAPI/tipomidiactrl/listarTipoMidia"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data;
			var linhaTabela = '<tr><td>#</td><td>Descrição</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="descricao">';
				linhaTabela += lista[i].descricao;
				linhaTabela += '</td>';
				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}

/*
$(document).ready(function(){
	listarTipoMidia();
});*/

function mostrarModal(titulo, mensagem) {
	$('#modal-title').html(titulo);
	$('#modal-mensagem').html(mensagem);
	$('#modal-mensagens').modal('show');
}