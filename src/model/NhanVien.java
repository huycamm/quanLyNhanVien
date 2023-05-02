package model;

import java.io.Serializable;

public class NhanVien implements Serializable{
	private int id;
	private String ten;
	private int tuoi, gioiTinh;
	private String chucVu;
	private int luong;
	public NhanVien() {
		
	}
	public NhanVien(int id, String ten, int tuoi, int gioiTinh, String chucVu, int luong) {
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.luong = luong;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
}
