package com.keila.persistencia;

import java.util.ArrayList;
import java.util.List;
import com.keila.model.Produto;

/**
 *
 * @author Keila
 */
public class ProdutoDAO extends DAO {   
    public void cadastrar(Produto produto)throws Exception{
        OpenDataBase();
        String SQL = "INSERT INTO Produto VALUES(?, ?, ?, ?)";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, produto.getDescricao());
        pstmt.setInt(2, produto.getMarcaId());
        pstmt.setInt(3, produto.getQuantidade());
        pstmt.setDouble(4, produto.getValor());
        pstmt.execute();        
        CloseDataBase();
    }
    
    public Produto buscaporId(Integer id)throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Produto WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        Produto produto = new Produto();
        if (rs.next()){
        	produto.setCodigo(rs.getInt("codigo"));
        	produto.setDescricao(rs.getString("descricao"));
        	produto.setMarcaId(rs.getInt("marcaId"));
        	produto.setQuantidade(rs.getInt("quantidade"));
        	produto.setValor(rs.getDouble("valor"));
        }    
        return produto;
    }
    
    public void delete(Produto produto)throws Exception{
        OpenDataBase();
        String SQL = "DELETE Produto WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setInt(1, produto.getCodigo());
        pstmt.setString(2, produto.getDescricao());
        pstmt.setInt(3, produto.getMarcaId());
        pstmt.setInt(4, produto.getQuantidade());
        pstmt.setDouble(5, produto.getValor());
        pstmt.execute();
    }
    
    public List<Produto> listaProdutos()throws Exception{
        OpenDataBase();
        String SQL = "SELECT * from Produto";
        pstmt = con.prepareStatement(SQL);
        rs = pstmt.executeQuery();
        Produto produto = null;
        List<Produto> listaProdutos = new ArrayList<Produto>();
        while (rs.next()){
        	produto = new Produto();
        	produto.setCodigo(rs.getInt("codigo"));
        	produto.setDescricao(rs.getString("descricao"));
        	produto.setMarcaId(rs.getInt("marcaId"));
        	produto.setQuantidade(rs.getInt("quantidade"));
        	produto.setValor(rs.getDouble("valor"));
            listaProdutos.add(produto);            
        }
        return listaProdutos;
    }
    
    public void update(Produto produto)throws Exception{
        OpenDataBase();
        String SQL = "UPDATE Produto set descricao=?, marcaId=?,"
                + "quantidade=?, valor=? WHERE codigo=?";
        pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, produto.getDescricao());
        pstmt.setInt(2, produto.getMarcaId());
        pstmt.setInt(3, produto.getQuantidade());
        pstmt.setDouble(4, produto.getValor());
        pstmt.setInt(5, produto.getCodigo());
        pstmt.executeUpdate(); 
    }
}

