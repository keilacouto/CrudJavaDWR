<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Conten't-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
        
        <script type='text/javascript' src='/SisDemonstracao/dwr/interface/MarcaControlador.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/engine.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/util.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/js/marca.js'></script>
        <link rel="stylesheet" type="text/css" href="/SisDemonstracao/css/estilo.css" media="all" />
    </head>
    
    <body onload="listarMarca();">
    	<h2>Cadastro de Marca</h2>
        <form id="form" method="post">	                
	        <input type="hidden" class="input" name="codigo" value=""/>
	        <div class="field">  
	            <label for="nome">Descrição:</label>            
	            <input type="text" class="input" name="descricao" value="" /><br />
	            <p class="hint">Entre com a marca</p>
	        </div>	        
	       
	        <input value="Gravar" class="button" type="button" onclick="gravarMarca()"/>
        </form><br />
        <font color="#FF0000">
         <span id="msg"></span>
        </font>
        <h2>Lista de Marcas</h2>
        <table>
            <thead>
                <tr>
                    <td>Código</td>
                    <td>Descrição</td>
                    <td>Ações</td>
                </tr>                
            </thead>
            <tbody  id="tablebody" >                
                <tr id="pattern" style="display:none;">
				     <td><span id="tableCodigo">Código</span></td>
				     <td><span id="tableDescricao">Descrição</span></td>
				     				     				       
				     <td>
				       <input id="editar" type="button" class="button" value="Editar" onclick="editarMarca(this.id)"/>
				       <input id="excluir" type="button" class="button" value="Excluir" onclick="excluirMarca(this.id)"/>
				     </td>
				  </tr>
            </tbody>           
        </table>   
    </body>  
</html>
