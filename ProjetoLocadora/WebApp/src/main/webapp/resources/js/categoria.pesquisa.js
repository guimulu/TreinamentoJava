
function listarCategorias() {
	var operacao = "/ControleAPI/categoriactrl/listarCategorias"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data;
			var linhaTabela = '';
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
	listarCategorias();
});
*/