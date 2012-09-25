package com.keila.persistencia;

import com.keila.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keila
 */
public class ClienteDAO extends DAO {   
    public void cadastrar(Cliente cliente)throws Exception{
        OpenDataBase();
        String SQL = "INSERT INTO Cliente VALUES(?, ?, ?, ?)";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getTelefone());
        pstmt.setString(3, cliente.getEmail());
        pstmt.setString(4, cliente.getSite());
        pstmt.execute();        
        CloseDataBase();
    }
    
    public Cliente buscaporId(Integer id)throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Cliente WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        Cliente cliente = new Cliente();
        if (rs.next()){
        	cliente.setCodigo(rs.getInt("codigo"));
        	cliente.setNome(rs.getString("nome"));
        	cliente.setTelefone(rs.getString("telefone"));
        	cliente.setEmail(rs.getString("email"));
        	cliente.setSite(rs.getString("site"));
        }    
        return cliente;
    }
    
    public void delete(Cliente cliente)throws Exception{
        OpenDataBase();
        String SQL = "DELETE Cliente WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, cliente.getCodigo());
        pstmt.execute();
    }
    
    public List<Cliente> listaClientes()throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Cliente";
        pstmt = con.prepareStatement(SQL);
        rs = pstmt.executeQuery();
        Cliente cliente = null;
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        while (rs.next()){
        	cliente = new Cliente();
        	cliente.setCodigo(rs.getInt("codigo"));
        	cliente.setNome(rs.getString("nome"));
        	cliente.setTelefone(rs.getString("telefone"));
        	cliente.setEmail(rs.getString("email"));
        	cliente.setSite(rs.getString("site"));
            listaClientes.add(cliente);            
        }
        return listaClientes;
    }
    
    public void update(Cliente cliente)throws Exception{
        OpenDataBase();
        String SQL = "UPDATE Cliente set nome=?, telefone=?,"
                + "email=?, site=? WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getTelefone());
        pstmt.setString(3, cliente.getEmail());
        pstmt.setString(4, cliente.getSite());
        pstmt.setInt(5, cliente.getCodigo());
        pstmt.executeUpdate(); 
    }
}
