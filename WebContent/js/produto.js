var dadosCache = { };        	  
   
function gravarProduto() {
	var produto = { codigo:0, descricao:null, marcaId:null, quantidade:null, valor:null };
   	dwr.util.getValues(produto);
 
   	dwr.engine.beginBatch();
   	if (produto.codigo > 0){
   		ProdutoControlador.atualizar(produto);
   	} else { 
   		ProdutoControlador.inserir(produto);
   	}
   	  
   	limpaFormulario();
   	listarProduto();
   	dwr.engine.endBatch();    
}

function limpaFormulario() {  
	dwr.util.setValues({ codigo:0, descricao:null, marcaId:null, quantidade:null, valor:null });
}

function listarProduto() {
	ProdutoControlador.listar(retornoListarProduto);
}

function retornoListarProduto(data) {
	dwr.util.removeAllRows("tablebody", { filter:function(tr) {
      return (tr.id != "pattern");
    }});
	for (var i = 0; i < data.length; i++) {
		produto = data[i];
		codigo = produto.codigo;
		dwr.util.cloneNode("pattern", { idSuffix:codigo });
		dwr.util.setValue("tableCodigo" + codigo, produto.codigo);
		dwr.util.setValue("tableDescricao" + codigo, produto.descricao);
		dwr.util.setValue("tableMarca" + codigo, produto.marcaId);
		dwr.util.setValue("tableQuantidade" + codigo, produto.quantidade);
		dwr.util.setValue("tableValor" + codigo, produto.valor);
                       	      
		dwr.util.byId("pattern" + codigo).style.display = "";
		dadosCache[codigo] = produto;
    }
}

function editarProduto(eleid) {
	// we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
	var produto = dadosCache[eleid.substring(6)];
	dwr.util.setValues(produto);
}

function excluirProduto(eleid) {
	// we were an id of the form "delete{id}", eg "delete42". We lookup the "42"
	var produto = dadosCache[eleid.substring(7)];
	if (confirm("Tem certeza que deseja excluir esse produto: " + produto.descricao + "?")) {
		dwr.engine.beginBatch();
		ProdutoControlador.excluir(produto.codigo);
		listarProduto();
		dwr.engine.endBatch();
	}
}

function carregaMarca(){	
    MarcaControlador.listar(retornoCarregaMarca);
}

function retornoCarregaMarca(dados){
    dwr.util.removeAllOptions("marcaId");
    dwr.util.addOptions("marcaId", dados, "codigo", "descricao");
}

function init() {
	carregaMarca();
	listarProduto();
}