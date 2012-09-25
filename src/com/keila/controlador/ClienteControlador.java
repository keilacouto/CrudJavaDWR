/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keila.controlador;

import com.keila.model.Cliente;
import com.keila.persistencia.ClienteDAO;
import java.util.List;

/**
 *
 * @author Keila
 */
public class ClienteControlador {
    public String inserir(Cliente cliente){
        ClienteDAO clienteDao = new ClienteDAO();
        try{
        	clienteDao.cadastrar(cliente);
            return "Cadastrado com sucesso!";
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        }
    }
    
    public String excluir(int codigo){
        try{            
            ClienteDAO clienteDao = new ClienteDAO();
            Cliente cliente = clienteDao.buscaporId(codigo);
            if (cliente.getCodigo() > 0){
            	clienteDao.delete(cliente);                
                return "Deletado com sucesso!";                
            } else{
                return "Erro: Registro não encontrado.";
            }
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        }
        
    }
    
    public String atualizar(Cliente cliente){
        ClienteDAO clienteDao = new ClienteDAO();
        try{
        	clienteDao.update(cliente);
            return "Atualizado com sucesso!";
        }catch (Exception e){
            return "Erro:" +e.getMessage();
        } 
    }
    
    public Cliente buscar(int codigo) throws Exception{                 
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = clienteDao.buscaporId(codigo);
        return cliente;
    }
    
    public List<Cliente> listar() throws Exception{
         ClienteDAO clienteDao = new ClienteDAO();
         List<Cliente> lista = clienteDao.listaClientes();        
         return lista;
    }
    
    public String sayHello(String nome){
        return "Hello" + nome;
    }
}
