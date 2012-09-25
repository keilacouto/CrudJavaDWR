package com.keila.persistencia;

import com.keila.model.Marca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keila
 */
public class MarcaDAO extends DAO {   
    public void cadastrar(Marca marca)throws Exception{
        OpenDataBase();
        String SQL = "INSERT INTO Marca VALUES(?)";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, marca.getDescricao());
        pstmt.execute();        
        CloseDataBase();
    }
    
    public Marca buscaporId(Integer id)throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Marca WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        Marca marca = new Marca();
        if (rs.next()){
        	marca.setCodigo(rs.getInt("codigo"));
        	marca.setDescricao(rs.getString("descricao"));
        }    
        return marca;
    }
    
    public void delete(Marca marca)throws Exception{
        OpenDataBase();
        String SQL = "DELETE Marca WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, marca.getCodigo());
        pstmt.execute();
    }
    
    public List<Marca> listaMarcas()throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Marca";
        pstmt = con.prepareStatement(SQL);
        rs = pstmt.executeQuery();
        Marca marca = null;
        List<Marca> listaMarcas = new ArrayList<Marca>();
        while (rs.next()){
        	marca = new Marca();
        	marca.setCodigo(rs.getInt("codigo"));
        	marca.setDescricao(rs.getString("descricao"));
            listaMarcas.add(marca);            
        }
        return listaMarcas;
    }
    
    public void update(Marca marca)throws Exception{
        OpenDataBase();
        String SQL = "UPDATE Marca set descricao=? WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, marca.getDescricao());        
        pstmt.setInt(2, marca.getCodigo());
        pstmt.executeUpdate(); 
    }
}
