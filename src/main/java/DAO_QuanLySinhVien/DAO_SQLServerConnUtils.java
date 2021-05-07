/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO_QuanLySinhVien;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO_SQLServerConnUtils {
    
     public static Connection getSQLServerConnection()
         throws SQLException, ClassNotFoundException {
     String hostName = "PHOENIXHUYNH\\SQLEXPRESS";
     String sqlInstanceName = "SQLEXPRESS";
     String database = "DB_QUANLYSV";
     String userName = "sa";
     String password = "3008NGUyenSA";
 
     return getSQLServerConnection(hostName, sqlInstanceName,
             database, userName, password);
 }
 
 // Trường hợp sử dụng SQLServer.
 // Và thư viện SQLJDBC.
 public static Connection getSQLServerConnection(String hostName,
         String sqlInstanceName, String database, String userName,
         String password) throws ClassNotFoundException, SQLException {
     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }  
}
