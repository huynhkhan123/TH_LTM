/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.User;

/**
 *
 * @author Administrator
 */
public class DBAccess {
    private Connection con;
    private  Statement stmt;
    public DBAccess() throws SQLException{
        try {
            MyConnection mycon = new MyConnection();
            con = mycon.getConnection();
            stmt =con.createStatement();
        } catch (Exception e) {
            
        }
        
        
    }
    
    public ResultSet getUser(String str){
        try {
            PreparedStatement statement = con.prepareStatement(str);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public int Update(String str)
    {
        try {
            int i = stmt.executeUpdate(str);
            return i;
            
        } catch (Exception e) {
            return -1;
        }
    }
    
    public ResultSet Qury(String str)
    {
        try {
            ResultSet rs =stmt.executeQuery(str);
            return rs;
            
        } catch (Exception e) {
            return null;
        }
        
        
    }
}
