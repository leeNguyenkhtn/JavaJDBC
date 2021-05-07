/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_QuanLySinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class DAO_TableSinhVien {
    public static ResultSet SelectTable() throws ClassNotFoundException,
          SQLException
    {
        Connection connection = DAO_ConnectionUtils.getMyConnection();
 
      // Tạo đối tượng Statement.
      Statement statement = connection.createStatement();
 
      String sql = "SELECT * FROM SinhVien";
 
      // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
      ResultSet rs = statement.executeQuery(sql);
      // Đóng kết nối
      connection.close();
      return rs;
    }
    public static boolean UpdateRecord(String maHS,String id,String hoTen,double diem,
            String hinhAnh,String diaChi,String ghiChu) throws SQLException,ClassNotFoundException
    {
        Connection connection = DAO_ConnectionUtils.getMyConnection();
        String sql = "UPDATE SinhVien\n" +
                     "SET MAHS = ?, HOTEN = ?, DIEM = ?, HINHANH = ?, DIACHI = ?, GHICHU = ?\n" +
                     "WHERE MAHS = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, hoTen);
        ps.setDouble(3, diem);
        ps.setString(4, hinhAnh);
        ps.setString(5, diaChi);
        ps.setString(6, ghiChu);
        ps.setString(7,maHS);
        boolean result = ps.execute();
        ps.close();
        connection.close();
        return result;
    }
    public static boolean InsertRecord(String maHS,String hoTen,double diem,
            String hinhAnh,String diaChi,String ghiChu) throws SQLException,ClassNotFoundException
    {
        
        Connection connection = DAO_ConnectionUtils.getMyConnection();
        String sql = "INSERT INTO SinhVien\n" +
                     "VALUES (?,?,?,?,?,?)\n";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, maHS);
        ps.setString(2, hoTen);
        ps.setDouble(3, diem);
        ps.setString(4, hinhAnh);
        ps.setString(5, diaChi);
        ps.setString(6, ghiChu);
        boolean result = ps.execute();
        ps.close();
        connection.close();
        return result;
    }
    public static boolean DeleteRecord(String maHS)throws SQLException,ClassNotFoundException
    {
         Connection connection = DAO_ConnectionUtils.getMyConnection();
         String sql = "DELETE FROM SinhVien WHERE maHS = " + maHS;
         Statement st = connection.createStatement();       
         connection.close();
         boolean result = st.execute(sql);
         return result;
    }
    public static ResultSet ViewSortedRecord(String orderBy, int flag)throws ClassNotFoundException,
          SQLException
        //flag = 0 : asc (tang dan)
        //flag = 1 : desc (giam dan)
    {
      Connection connection = DAO_ConnectionUtils.getMyConnection();
      String sql = "SELECT * FROM SinhVien ORDER BY ";
      // Tạo đối tượng Statement.
      Statement st = connection.createStatement();
      ResultSet rs = null;
      if(flag ==0)
      {
          rs = st.executeQuery(sql + orderBy + " ASC");
      }
      else{
          rs = st.executeQuery(sql + orderBy + " DESC");
      }
      connection.close();
      return rs;
    }
    
}
