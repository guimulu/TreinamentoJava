function cadastrarEndereco() {
	var bairro = $("#bairro-endereco").val();
	var cep = $("#cep-endereco").val();
	var cidade = $("#cidade-endereco").val();
	var complemento = $("#complemento-endereco").val();
	var estado = $("#estado-endereco").val();
	var numero = $("#numero-endereco").val();
	var rua = $("#rua-endereco").val();
	
	var enderecoDTO = new Object();
	var operacao = "/ControleAPI/enderecoctrl/criarEndereco"
	enderecoDTO.bairro = bairro;
	enderecoDTO.cep = cep;
	enderecoDTO.cidade = cidade;
	enderecoDTO.estado = estado;
	enderecoDTO.numero = numero;
	enderecoDTO.rua = rua;
	
	$.ajax({
		method: "POST",
		url: operacao,
		data: JSON.stringify(enderecoDTO),
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


function listarEnderecos() {
	var operacao = "/ControleAPI/enderecoctrl/listarEnderecos"
		$.ajax({
			url: operacao,
		}).done(function (data){
			var lista = data;
			var linhaTabela = '<tr><td>#</td><td>CEP</td><td>Bairro</td><td>Rua</td><td>Numero</td><td>Complemento</td><td>Cidade</td><td>Estado</td></tr>';
			
			$('#lista').html('');
			
			
			for(i = 0; i < lista.length; i++){
				linhaTabela += '<tr>';
				linhaTabela += '<td class="id">';
				linhaTabela += lista[i].id;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="cep">';
				linhaTabela += lista[i].cep;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="bairro">';
				linhaTabela += lista[i].bairro;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="rua">';
				linhaTabela += lista[i].rua;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="numero">';
				linhaTabela += lista[i].numero;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="complemento">';
				linhaTabela += lista[i].complemento;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="cidade">';
				linhaTabela += lista[i].cidade;
				linhaTabela += '</td>';
				
				linhaTabela += '<td class="estado">';
				linhaTabela += lista[i].estado;
				linhaTabela += '</td>';
				linhaTabela += '</tr>';
			}
			$('#lista').append(linhaTabela);
			
		});
		
}

/*
$(document).ready(function(){
	listarEnderecos();
});
*/
