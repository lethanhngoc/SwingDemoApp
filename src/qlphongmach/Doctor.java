/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongmach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlphongmach.Connect_db.con;

/**
 *
 * @author sieus
 */
public class Doctor extends Connect_db{
   
    public int Insert(String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "INSERT INTO BACSI( MaBS, TenBS, ChuyenNganh ) VALUES(?,?,?)";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
                    
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
            
            

        return rowsInserted;
    }
    public int Update (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE BACSI SET TenBS = ?, ChuyenNganh = ? WHERE MaBS =?";
        PreparedStatement statement;    
        try {
             statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rowsInserted;
    }
    public int Delete (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "DELETE FROM BACSI WHERE MaBS =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
public ResultSet getDataBS (String stringSQL)
    {
        ResultSet rs = null;
        PreparedStatement statement; 
            // tạo đường dẫn kết nối database
        try {
            statement = con.prepareStatement("SELECT * FROM BACSI WHERE MaBS = ? ");
            statement.setString(1, stringSQL);
            rs = statement.executeQuery();
                          
        } catch (SQLException ex) {
            Logger.getLogger(Connect_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
