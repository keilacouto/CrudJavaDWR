package com.keila.controlador;

import java.util.List;
import com.keila.model.Marca;
import com.keila.persistencia.MarcaDAO;

/**
*
* @author Keila
*/
public class MarcaControlador {
   public String inserir(Marca marca){
       MarcaDAO marcaDao = new MarcaDAO();
       try{
    	   marcaDao.cadastrar(marca);
           return "Cadastrado com sucesso!";
       }catch (Exception e){
           return "Erro:" +e.getMessage();
       }
   }
   
   public String excluir(int codigo){
       try{            
           MarcaDAO marcaDAO = new MarcaDAO();
           Marca marca = marcaDAO.buscaporId(codigo);
           if (marca.getCodigo() > 0){
        	   marcaDAO.delete(marca);                
               return "Deletado com sucesso!";                
           } else{
               return "Erro: Registro não encontrado.";
           }
       }catch (Exception e){
           return "Erro:" +e.getMessage();
       }
       
   }
   
   public String atualizar(Marca marca){
       MarcaDAO marcaDAO = new MarcaDAO();
       try{
    	   marcaDAO.update(marca);
           return "Atualizado com sucesso!";
       }catch (Exception e){
           return "Erro:" +e.getMessage();
       } 
   }
   
   public Marca buscar(int codigo) throws Exception{                 
       MarcaDAO marcaDAO = new MarcaDAO();
       Marca marca = marcaDAO.buscaporId(codigo);
       return marca;
   }
   
   public List<Marca> listar() throws Exception{
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> lista = marcaDAO.listaMarcas();        
        return lista;
   }
   
}