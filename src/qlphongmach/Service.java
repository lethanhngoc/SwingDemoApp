/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongmach;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlphongmach.Connect_db.con;

/**
 *
 * @author sieus
 */
public class Service extends Connect_db{
    public int Insert (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "INSERT INTO DICHVU( MaDV, TenDV, GiaDV ) VALUES(?,?,?)";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Update (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE DICHVU SET TenDV = ?, GiaDV = ? WHERE MaDV =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Delete (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "DELETE FROM DICHVU WHERE MaDV =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
}
