package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NhanVienView;

public class NhanVienController implements ActionListener{
	private NhanVienView nhanVienView;
	
	public NhanVienController(NhanVienView nhanVienView) {
		this.nhanVienView = nhanVienView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Refresh")) {
			this.nhanVienView.refresh();
		}else if(src.equals("Save")) {
			this.nhanVienView.them();		
		}else if(src.equals("Delete")) {
			this.nhanVienView.xoa();
		}else if(src.equals("Find")) {
			this.nhanVienView.timKiem();
		}else if(src.equals("Cancel")) {
			this.nhanVienView.huyTim();
		}else if(src.equals("Update")) {
			this.nhanVienView.update();
		}else if(src.equals("Đăng Xuất")) {
			this.nhanVienView.dangXuat();
		}else if(src.equals("Exit")) {
			this.nhanVienView.thoatKhoiChuongTrinh();
		}else if(src.equals("save")) {
			this.nhanVienView.thucHienSaveFile();
		}else if(src.equals("CHANGE")) {
			this.nhanVienView.changePass();
		}else if(src.equals("Sort")) {
			this.nhanVienView.showDataSort();
		}
	}
}
