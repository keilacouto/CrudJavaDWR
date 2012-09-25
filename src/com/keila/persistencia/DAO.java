package com.keila.persistencia;

import java.sql.*;

/**
 *
 * @author Keila
 */
public class DAO {
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void OpenDataBase() throws Exception{
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String url = "jdbc:jtds:sqlserver://localhost:1433/SisDemonstracao";
        String user = "sa";
        String password = "desenv";
        con = DriverManager.getConnection(url, user, password);
        
    }
    
    public void CloseDataBase()throws Exception{
        if (con != null){
            con.close();
        }
            
    }
}
