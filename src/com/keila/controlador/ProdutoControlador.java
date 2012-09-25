package com.keila.controlador;

import com.keila.model.Produto;
import com.keila.persistencia.ProdutoDAO;
import java.util.List;

/**
 *
 * @author Keila
 */
public class ProdutoControlador {
    public String inserir(Produto produto){
        ProdutoDAO produtoDao = new ProdutoDAO();
        try{
        	produtoDao.cadastrar(produto);
            return "Cadastrado com sucesso!";
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        }
    }
    
    public String excluir(int codigo){
        try{            
        	ProdutoDAO produtoDao = new ProdutoDAO();
            Produto produto = produtoDao.buscaporId(codigo);
            if (produto.getCodigo() > 0){
            	produtoDao.delete(produto);                
                return "Deletado com sucesso!";                
            } else{
                return "Erro: Registro não encontrado.";
            }
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        }
        
    }
    
    public String atualizar(Produto produto){
    	ProdutoDAO produtoDao = new ProdutoDAO();
        try{
        	produtoDao.update(produto);
            return "Atualizado com sucesso!";
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        } 
    }
    
    public Produto buscar(int codigo) throws Exception{                 
    	ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = produtoDao.buscaporId(codigo);
        return produto;
    }
    
    public List<Produto> listar() throws Exception{
    	ProdutoDAO produtoDao = new ProdutoDAO();
        List<Produto> lista = produtoDao.listaProdutos();        
        return lista;
    }
    
}
