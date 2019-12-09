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
public class TotalBill extends Connect_db{
    public int Insert (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "INSERT INTO HOADON ( MaHD, MaDT, MaDDV,MaBN, TongTien ) VALUES(?,?,?,?,?)";
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
            Logger.getLogger(TotalBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Update (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE HOADON SET MaDT = ?, MaDDV = ?, MaBN = ? , TongTien = ? WHERE MaHD = ?";
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
            Logger.getLogger(TotalBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    //Hàm DELETE
    public int Delete(String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "DELETE FROM HOADON WHERE MaHD =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TotalBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Hàm tính tổng tiền
    public int totalPrices(String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE dbo.HOADON SET  TongTien = (SELECT TienThuoc FROM  dbo.DONTHUOC WHERE MaDT = ? ) + (SELECT TienDV FROM  dbo.DONDV WHERE MaDDV = ?) WHERE MaHD =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TotalBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
}
