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
public class Medicine extends Connect_db{
    public int Insert (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "INSERT INTO THUOC( MaT,TenThuoc,HSD,LieuDung,GiaThuoc ) VALUES(?,?,?,?,?)";
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
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Update (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "UPDATE THUOC SET TenThuoc = ?, HSD = ?, LieuDung = ?, GiaThuoc = ? WHERE MaT =?";
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
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public int Delete (String[] stringsSQL)
    {
        int rowsInserted = 0;
        String sql = "DELETE FROM THUOC WHERE MaT =?";
        PreparedStatement statement;
        
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rowsInserted;
    }
    public ResultSet getDataT (String stringSQL)
    {
        ResultSet rs = null;
        PreparedStatement statement; 
            // tạo đường dẫn kết nối database
        try {
            statement = con.prepareStatement("SELECT * FROM THUOC WHERE MaT = ? ");
            statement.setString(1, stringSQL);
            rs = statement.executeQuery();
                          
        } catch (SQLException ex) {
            Logger.getLogger(Connect_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
