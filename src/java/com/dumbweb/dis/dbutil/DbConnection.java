/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.dis.dbutil;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class DbConnection {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void open() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/dis", "root", "");
        
        
    }
    
    public void close() throws SQLException{
        
        if(conn!=null && !conn.isClosed()){
            conn.close();
            conn = null;
        }
    }
    
    public PreparedStatement initStatement(String sql) throws SQLException{
        
        ps =conn.prepareStatement(sql);
        
        return ps;
    }
    
    public ResultSet executeQuery() throws SQLException{
        
        rs = ps.executeQuery();
        
        return rs;
    }
    
    public int executeUpdate() throws SQLException{
        
        int rowsAffected = ps.executeUpdate();
        
        return rowsAffected;
        
    }
}
