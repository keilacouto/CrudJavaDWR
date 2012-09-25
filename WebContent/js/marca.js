var dadosCache = { };        	  
   
function gravarMarca() {
	var marca = { codigo:0, descricao:null };
   	dwr.util.getValues(marca);
 
   	dwr.engine.beginBatch();
   	if (marca.codigo > 0){
   		MarcaControlador.atualizar(marca);
   	} else { 
   		MarcaControlador.inserir(marca);
   	}
   	  
   	limpaFormulario();
   	listarMarca();
   	dwr.engine.endBatch();    
}

function limpaFormulario() {  
	dwr.util.setValues({ codigo:0, descricao:null });
}

function listarMarca() {
	MarcaControlador.listar(retornoListarMarca);
}

function retornoListarMarca(data) {
	dwr.util.removeAllRows("tablebody", { filter:function(tr) {
      return (tr.id != "pattern");
    }});
	for (var i = 0; i < data.length; i++) {
		marca = data[i];
		codigo = marca.codigo;
		dwr.util.cloneNode("pattern", { idSuffix:codigo });
		dwr.util.setValue("tableCodigo" + codigo, marca.codigo);
		dwr.util.setValue("tableDescricao" + codigo, marca.descricao);
                       	      
		dwr.util.byId("pattern" + codigo).style.display = "";
		dadosCache[codigo] = marca;
    }
}

function editarMarca(eleid) {
	// we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
	var marca = dadosCache[eleid.substring(6)];
	dwr.util.setValues(marca);
}

function excluirMarca(eleid) {
	// we were an id of the form "delete{id}", eg "delete42". We lookup the "42"
	var marca = dadosCache[eleid.substring(7)];
	if (confirm("Tem certeza que deseja excluir essa marca: " + marca.descricao + "?")) {
		dwr.engine.beginBatch();
		MarcaControlador.excluir(marca.codigo);
		listarMarca();
		dwr.engine.endBatch();
	}
}