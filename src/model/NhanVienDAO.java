package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// Đăng ký MySQL driver với DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Các thông số
			String url = "jdbc:mySQL://localhost:3306/qlnv";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static List<NhanVien> findAll(){
		List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien";
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				int tuoi = rs.getInt("tuoi");
				int gioiTinh = rs.getInt("gioiTinh");
				String chucVu = rs.getString("chucVu");
				int luong = rs.getInt("luong");
				NhanVien nv = new NhanVien(id, ten, tuoi, gioiTinh, chucVu, luong);
				nhanVienList.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList;
	}
	
	public static List<NhanVien> sortFindAll(){
		List<NhanVien> nhanVienList = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien ORDER BY ten";
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				int tuoi = rs.getInt("tuoi");
				int gioiTinh = rs.getInt("gioiTinh");
				String chucVu = rs.getString("chucVu");
				int luong = rs.getInt("luong");
				NhanVien nv = new NhanVien(id, ten, tuoi, gioiTinh, chucVu, luong);
				nhanVienList.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVienList;
	}
	
	public static void insert(NhanVien nv) {
		String sql = "INSERT INTO nhanvien(id, ten, tuoi, gioiTinh, chucVu, luong) VALUES(?,?,?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, nv.getId());
			pst.setString(2, nv.getTen());
			pst.setInt(3, nv.getTuoi());
			pst.setInt(4, nv.getGioiTinh());
			pst.setString(5, nv.getChucVu());
			pst.setInt(6, nv.getLuong());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(NhanVien nv) {
		String sql = "DELETE FROM nhanvien WHERE ten = '"+ nv.getTen() +"'";
		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(NhanVien nv) {
		String sql = "UPDATE nhanvien SET ten=?, tuoi=?, gioiTinh=?, chucVu=?, luong=? WHERE ten='"+nv.getTen()+"'";
		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, nv.getTen());
			pst.setInt(2, nv.getTuoi());
			pst.setInt(3, nv.getGioiTinh());
			pst.setString(4, nv.getChucVu());
			pst.setInt(5, nv.getLuong());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<NhanVien> findByName(NhanVien nv) {
		List<NhanVien> nvList = new ArrayList<NhanVien>();
		String sql = "SELECT * FROM nhanvien WHERE ten LIKE '%"+ nv.getTen()+"%'";
		try {
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				int tuoi = rs.getInt("tuoi");
				int gioiTinh = rs.getInt("gioiTinh");
				String chucVu = rs.getString("chucVu");
				int luong = rs.getInt("luong");
				NhanVien nhanvien = new NhanVien(id, ten, tuoi, gioiTinh, chucVu, luong);
				nvList.add(nhanvien);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nvList;
	}	
}

