<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Conten't-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
        
        <script type='text/javascript' src='/SisDemonstracao/dwr/interface/ClienteControlador.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/engine.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/util.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/js/cliente.js'></script>
        <link rel="stylesheet" type="text/css" href="/SisDemonstracao/css/estilo.css" media="all" />
    </head>
    
    <body onload="listarCliente();">
    	<h2>Cadastro de Clientes</h2>
    	
        <form id="form" method="post">	                
	        <input type="hidden" class="input" name="codigo" value=""/>
	        <div class="field">  
	            <label for="nome">Nome:</label>            
	            <input type="text" class="input" name="nome" value="" /><br />
	            <p class="hint">Entre com seu nome</p>
	        </div>
	        <div class="field">
	            <label for="telefone">Telefone:</label>            
	            <input type="text" class="input" name="telefone" value="" /><br />
	            <p class="hint">Entre com seu telefone</p>
	        </div>
	        <div class="field">
	            <label for="email">Email:</label>               
	            <input type="text" class="input" name="email" value="" /><br />
	            <p class="hint">Entre com seu e-mail</p>
	        </div>
	        <div class="field">    
	            <label for="site">Site:</label>       
	            <input type="text" class="input" name="site" value="" /><br />
	            <p class="hint">Entre com seu site</p>
	        </div>
	        
	        <!-- <input value="teste" class="button" type="button" onclick="teste()"/> -->
	        <input value="Gravar" class="button" type="button" onclick="gravarCliente()"/>
        </form><br />
        <font color="#FF0000">
         <span id="msg"></span>
        </font>
        <h2>Lista de Clientes</h2>
        <table>
            <thead>
                <tr>
                    <td>Código</td>
                    <td>Nome</td>
                    <td>Telefone</td>
                    <td>Email</td>
                    <td>Site</td>
                    <td>Ações</td>
                </tr>                
            </thead>
            <tbody  id="tablebody" >                
                <tr id="pattern" style="display:none;">
				     <td><span id="tableCodigo">Código</span></td>
				     <td><span id="tableNome">Nome</span></td>
				     <td><span id="tableTelefone">Telefone</span></td>
				     <td><span id="tableEmail">Email</span></td>
				     <td><span id="tableSite">Site</span></td>
				     				       
				     <td>
				       <input id="editar" type="button" class="button" value="Editar" onclick="editarCliente(this.id)"/>
				       <input id="excluir" type="button" class="button" value="Excluir" onclick="excluirCliente(this.id)"/>
				     </td>
				  </tr>
            </tbody>           
        </table>   
    </body>  
</html>
