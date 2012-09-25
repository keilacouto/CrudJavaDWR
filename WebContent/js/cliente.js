var dadosCache = { };
  
/* Exemplo de DWR
  function teste() {
    var name = dwr.util.getValue("nome");
    ClienteControlador.sayHello(name,retornoTeste);
  }
  function retornoTeste(data){
      dwr.util.setValue("msg", data);
  } */
  
function gravarCliente() {
	var cliente = { codigo:0, nome:null, telefone:null, email:null, site:null };
   	dwr.util.getValues(cliente);

	dwr.engine.beginBatch();
	if (cliente.codigo > 0){
		ClienteControlador.atualizar(cliente);
	} else { 
		ClienteControlador.inserir(cliente);
	}
	  
	limpaFormulario();
	listarCliente();
	dwr.engine.endBatch();   	  
 }

function limpaFormulario() {  
	dwr.util.setValues({ codigo:0, nome:null, telefone:null, email:null, site:null });
}

function listarCliente() {
	ClienteControlador.listar(retornoListarCliente);
}

function retornoListarCliente(data) {
	dwr.util.removeAllRows("tablebody", { filter:function(tr) {
      return (tr.id != "pattern");
    }});
	for (var i = 0; i < data.length; i++) {
		cliente = data[i];
		codigo = cliente.codigo;
		dwr.util.cloneNode("pattern", { idSuffix:codigo });
		dwr.util.setValue("tableCodigo" + codigo, cliente.codigo);
		dwr.util.setValue("tableNome" + codigo, cliente.nome);
		dwr.util.setValue("tableTelefone" + codigo, cliente.telefone);
		dwr.util.setValue("tableEmail" + codigo, cliente.email);
		dwr.util.setValue("tableSite" + codigo, cliente.site);
                 	      
		dwr.util.byId("pattern" + codigo).style.display = "";
		dadosCache[codigo] = cliente;
    }
}

function editarCliente(eleid) {
	// we were an id of the form "edit{id}", eg "edit42". We lookup the "42"
	var cliente = dadosCache[eleid.substring(6)];
	dwr.util.setValues(cliente);
}

function excluirCliente(eleid) {
	// we were an id of the form "delete{id}", eg "delete42". We lookup the "42"
	var cliente = dadosCache[eleid.substring(7)];
	if (confirm("Tem certeza que deseja excluir esse cliente: " + cliente.nome + "?")) {
		dwr.engine.beginBatch();
		ClienteControlador.excluir(cliente.codigo);
		listarCliente();
		dwr.engine.endBatch();
	}
}