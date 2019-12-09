/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlphongmach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sieus
 */
public class Connect_db {
    protected  static Connection con;
    public  Connect_db() 
    {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLPhongMach;username=sa;password=12345";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Connect_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ResultSet getData (String stringSQL)
    {
    ResultSet rs = null;

            // tạo đường dẫn kết nối database
            Statement state;
        try {
            state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connect_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
