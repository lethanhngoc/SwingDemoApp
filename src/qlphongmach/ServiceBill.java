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

/**
 *
 * @author sieus
 */
public class ServiceBill extends Connect_db {
    public int Insert (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "INSERT INTO DONDV( MaDDV, MaBS, MaBN, MaDV, TienDV) VALUES(?,?,?,?,?)";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Update (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE DONDV SET MaBS = ?, MaBN = ?,MaDV = ?, TienDV = ? WHERE MaDDV =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Delete (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "DELETE FROM DONDV WHERE MaDDV =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int ServicePrices(String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE DONDV SET TienDV = (SELECT GiaDV FROM DICHVU WHERE MaDV = ?) WHERE MaDV = ?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
}
