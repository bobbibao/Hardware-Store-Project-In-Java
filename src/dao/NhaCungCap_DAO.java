package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.nhaCungCap;

public class NhaCungCap_DAO {
	public NhaCungCap_DAO() {
		
	}
	public ArrayList<nhaCungCap>  getalltbNhaCungCap(){
		ArrayList<nhaCungCap> dsncc=new ArrayList<nhaCungCap>();
		try {
			ConnectDB.getInstance();	
			Connection con=ConnectDB.getConnection();
			String sql="Select * from NhaCungCap";
			Statement statement=con.createStatement();
			//Thuc thi cau lenh SL tra ve doi tuong resultset
			ResultSet rs=statement.executeQuery(sql);
			//duyet tren ket qua tra ve
			while (rs.next()) {//di chuyen con tro xuong ban ghi ke tiep
				String maNCC=rs.getString(1);
				String tenNCC=rs.getString(2);
				String soDienThoai=rs.getString(3);
				String email=rs.getString(4);
				String diaChi=rs.getString(5);
				nhaCungCap ncc=new nhaCungCap(maNCC, tenNCC, soDienThoai, email, diaChi);
				dsncc.add(ncc);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsncc;
	}
	public void addNCC(nhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql="insert into NhaCungCap values(?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, ncc.getMaNCC());
			stmt.setString(2, ncc.getTenNCC());
			stmt.setString(3, ncc.getSoDienThoai());
			stmt.setString(4, ncc.getEmail());
			stmt.setString(5, ncc.getDiaChi());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteNCC(String maNCC) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		String sql="delete from nhacungcap where maNCC=?";
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, maNCC);
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void updateNCC(nhaCungCap NCC) { 
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement stmt=null;
		String sql="update NhaCungCap "
				+ "set tenNCC=?,"
				+ "soDienThoai=?,"
				+ "email=?,"
				+ "Diachi=? "
				+ "where maNCC=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, NCC.getTenNCC());
			stmt.setString(2, NCC.getSoDienThoai());
			stmt.setString(3, NCC.getEmail());
			stmt.setString(4, NCC.getDiaChi());
			stmt.setString(5, NCC.getMaNCC());
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
