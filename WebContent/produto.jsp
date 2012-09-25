<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Conten't-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
        
        <script type='text/javascript' src='/SisDemonstracao/dwr/interface/ProdutoControlador.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/interface/MarcaControlador.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/engine.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/dwr/util.js'></script>
        <script type='text/javascript' src='/SisDemonstracao/js/produto.js'></script>
        <link rel="stylesheet" type="text/css" href="/SisDemonstracao/css/estilo.css" media="all" />
    </head>
    
    <body onload="init();">
    	<h2>Cadastro de Produto</h2>
        <form id="form" method="post">	                
	        <input type="hidden" class="input" name="codigo" value=""/>
	        	        
	        <div class="field">  
	            <label for="descricao">Descrição:</label>            
	            <input type="text" class="input" name="descricao" value="" /><br />
	            <p class="hint">Entre com a produto</p>
	        </div>	
	        
	        <div class="field">  	        
	            <label for="marcaId">Marca:</label>            
	            <select id="marcaId" class="input">
					<option value="codigo">descricao</option>
				</select><br/>
				<p class="hint">Selecione a marca</p>            
	        </div>	
	                 
	        <div class="field">  
	            <label for="quantidade">Quantidade:</label>            
	            <input type="text" class="input" name="quantidade" value="" /><br />
	            <p class="hint">Entre com a quantidade</p>
	        </div>
	        <div class="field">  
	            <label for="valor">Valor:</label>            
	            <input type="text" class="input" name="valor" value="" /><br />
	            <p class="hint">Entre com o valor</p>
	        </div>	
	        
	               		        
	       
	        <input value="Gravar" class="button" type="button" onclick="gravarProduto()"/>
        </form><br />
        <font color="#FF0000">
         <span id="msg"></span>
        </font>
        <h2>Lista de Produtos</h2>
        <table>
            <thead>
                <tr>
                    <td>Código</td>
                    <td>Descrição</td>
                    <td>Marca</td>
                    <td>Quantidade</td>
                    <td>Valor</td>
                    <td>Ações</td>
                </tr>                
            </thead>
            <tbody  id="tablebody" >                
                <tr id="pattern" style="display:none;">
				     <td><span id="tableCodigo">Código</span></td>
				     <td><span id="tableDescricao">Descrição</span></td>
				     <td><span id="tableMarca">Marca</span></td>
				     <td><span id="tableQuantidade">Quantidade</span></td>
				     <td><span id="tableValor">Valor</span></td>
				     				     				       
				     <td>
				       <input id="editar" type="button" class="button" value="Editar" onclick="editarProduto(this.id)"/>
				       <input id="excluir" type="button" class="button" value="Excluir" onclick="excluirProduto(this.id)"/>
				     </td>
				  </tr>
            </tbody>           
        </table>   
    </body>  
</html>
