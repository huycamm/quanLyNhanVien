package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.NhanVienController;
import model.NhanVien;
import model.NhanVienDAO;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;

public class NhanVienView extends JFrame {
	private JPanel contentPane;
	private JTextField textField_ten;
	private JTextField textField_tuoi;
	private JTextField textField_chucVu;
	private JTextField textField_luong;
	private JComboBox comboBox;
	private JTable table;
	private JTextField textField_timKiem;
	private JTable table_1;
	private JLabel Jlabel_menu;
	private JPanel panel_Menu;
	private final JSeparator separator_3 = new JSeparator();
	private JPanel panel_TrangChu;
	private JPanel panel_TaiKhoan;
	public JTextField textField_username;
	public JPasswordField passwordField;
	private JPasswordField TextNew_password;
	private JPasswordField TextConfirm_password;
	public JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienView frame = new NhanVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhanVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 724);
		
		NhanVienController controller = new NhanVienController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_file = new JMenu("File");
		mnNewMenu_file.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnNewMenu_file);
		
		JMenuItem mntmNewMenuItem_save = new JMenuItem("save");
		mntmNewMenuItem_save.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_save.addActionListener(controller);
		mnNewMenu_file.add(mntmNewMenuItem_save);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_file.add(separator_6);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_file.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(controller);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_Menu = new JPanel();
		panel_Menu.setBackground(new Color(225, 238, 219));
		panel_Menu.setBounds(0, 0, 0, 661);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JLabel lbl_trangChu = new JLabel("Trang chủ");
		lbl_trangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_TrangChu.setSize(1062,660);
				panel_TaiKhoan.setSize(0,660);
			}
		});
		lbl_trangChu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_trangChu.setBounds(45, 179, 115, 39);
		panel_Menu.add(lbl_trangChu);
		
		JLabel lbl_caiDat = new JLabel("Cài đặt");
		lbl_caiDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_TrangChu.setSize(0,660);
				panel_TaiKhoan.setSize(1062,660);			
			}
		});
		lbl_caiDat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_caiDat.setBounds(45, 240, 115, 27);
		panel_Menu.add(lbl_caiDat);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user.png"));
		lblNewLabel_3.setBounds(77, 37, 60, 64);
		panel_Menu.add(lblNewLabel_3);
		separator_3.setBounds(10, 130, 203, 2);
		panel_Menu.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 562, 203, 2);
		panel_Menu.add(separator_4);
		
		Jlabel_menu = new JLabel("");
		Jlabel_menu.setBounds(37, 10, 32, 32);
		contentPane.add(Jlabel_menu);
		Jlabel_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new Thread(new Runnable() {			
					@Override
					public void run() {
						int height = 660;
						for(int i=0; i<210; i++) {
							panel_Menu.setSize(i, height);
							try {
								Thread.sleep(2);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}				
					}
				});
				t.start();
			}
		});
		Jlabel_menu.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\menu.png"));
		
		JLabel lblNewLabel_close = new JLabel("");
		lblNewLabel_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new Thread(new Runnable() {			
					@Override
					public void run() {
						int height = 660;
						for(int i=210; i>=0; i--) {
							panel_Menu.setSize(i, height);
							try {
								Thread.sleep(2);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}				
					}
				});
				t.start();
			}
		});
				
		lblNewLabel_close.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\x.png"));
		lblNewLabel_close.setBounds(168, 10, 32, 27);
		panel_Menu.add(lblNewLabel_close);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangXuat.setBounds(33, 585, 138, 39);
		btnDangXuat.addActionListener(controller);
		panel_Menu.add(btnDangXuat);
		
		panel_TrangChu = new JPanel();
		panel_TrangChu.setBackground(new Color(226, 237, 237));
		panel_TrangChu.setBounds(0, 0, 1062, 660);
		contentPane.add(panel_TrangChu);
		panel_TrangChu.setLayout(null);
		
		JLabel lbl_ten_1 = new JLabel("Tên:");
		lbl_ten_1.setBounds(69, 120, 62, 34);
		panel_TrangChu.add(lbl_ten_1);
		lbl_ten_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_timKiem = new JTextField();
		textField_timKiem.setBounds(141, 121, 117, 34);
		panel_TrangChu.add(textField_timKiem);
		textField_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_timKiem.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(266, 66, 117, 43);
		panel_TrangChu.add(btnFind);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(266, 119, 117, 40);
		panel_TrangChu.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(266, 169, 117, 40);
		panel_TrangChu.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(404, 96, 637, 113);
		panel_TrangChu.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Tên", "Tuổi", "Giới tính", "Chức vụ", "Lương"
			}
		));
		table_1.setRowHeight(25);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("DANH SÁCH TÌM KIẾM");
		lblNewLabel_4.setBounds(615, 46, 259, 52);
		panel_TrangChu.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user2.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_ten = new JLabel("Tên:");
		lbl_ten.setBounds(69, 284, 87, 34);
		panel_TrangChu.add(lbl_ten);
		lbl_ten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField_ten = new JTextField();
		textField_ten.setBounds(217, 285, 146, 34);
		panel_TrangChu.add(textField_ten);
		textField_ten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_ten.setColumns(10);
		
		textField_tuoi = new JTextField();
		textField_tuoi.setBounds(217, 350, 146, 36);
		panel_TrangChu.add(textField_tuoi);
		textField_tuoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_tuoi.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(217, 410, 110, 34);
		panel_TrangChu.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Nam", "Nữ" }));
		
		textField_chucVu = new JTextField();
		textField_chucVu.setBounds(217, 469, 146, 34);
		panel_TrangChu.add(textField_chucVu);
		textField_chucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_chucVu.setColumns(10);
		
		textField_luong = new JTextField();
		textField_luong.setBounds(217, 521, 146, 34);
		panel_TrangChu.add(textField_luong);
		textField_luong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_luong.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(404, 292, 637, 265);
		panel_TrangChu.add(scrollPane);
				
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "T\u00EAn", "Tu\u1ED5i",
		"Gi\u1EDBi t\u00EDnh", "Ch\u1EE9c v\u1EE5", "L\u01B0\u01A1ng" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(72);
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
						
		JLabel lblNewLabel = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel.setBounds(548, 231, 383, 52);
		panel_TrangChu.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
						
		JLabel lbl_tuoi = new JLabel("Tuổi:");
		lbl_tuoi.setBounds(69, 350, 87, 34);
		panel_TrangChu.add(lbl_tuoi);
		lbl_tuoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_gioiTinh = new JLabel("Giới Tính:");
		lbl_gioiTinh.setBounds(69, 409, 87, 34);
		panel_TrangChu.add(lbl_gioiTinh);
		lbl_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_chucVu = new JLabel("Chức Vụ:");
		lbl_chucVu.setBounds(69, 468, 87, 34);
		panel_TrangChu.add(lbl_chucVu);
		lbl_chucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbl_luong = new JLabel("Lương:");
		lbl_luong.setBounds(69, 520, 87, 34);
		panel_TrangChu.add(lbl_luong);
		lbl_luong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_save = new JButton("Save");
		btnNewButton_save.setBounds(232, 596, 131, 40);
		panel_TrangChu.add(btnNewButton_save);
		
		btnNewButton_save.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(464, 596, 131, 40);
		panel_TrangChu.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
				
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(679, 596, 131, 40);
		panel_TrangChu.add(btnRefresh);
		btnRefresh.addActionListener(controller);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
						
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(42, 219, 999, 2);
		panel_TrangChu.add(separator_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 46, 1006, 2);
		panel_TrangChu.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(43, 584, 998, 2);
		panel_TrangChu.add(separator_1);
		
		JButton btnNewButton = new JButton("Sort");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(controller);
		btnNewButton.setBounds(896, 596, 122, 40);
		panel_TrangChu.add(btnNewButton);
		
		panel_TaiKhoan = new JPanel();
		panel_TaiKhoan.setBackground(new Color(226, 237, 237));
		panel_TaiKhoan.setBounds(0, 0, 0, 646);
		contentPane.add(panel_TaiKhoan);
		panel_TaiKhoan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản của bạn");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(78, 71, 314, 57);
		panel_TaiKhoan.add(lblNewLabel_1);
		
		JLabel lbl_userName = new JLabel("User name: ");
		lbl_userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_userName.setBounds(78, 173, 116, 48);
		panel_TaiKhoan.add(lbl_userName);
		
		textField_username = new JTextField();
		textField_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_username.setBounds(254, 177, 211, 42);
		panel_TaiKhoan.add(textField_username);
		textField_username.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpassword.setBounds(78, 277, 127, 34);
		panel_TaiKhoan.add(lblpassword);
		
		JLabel lblNewLabel_2 = new JLabel("Change Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(78, 384, 197, 48);
		panel_TaiKhoan.add(lblNewLabel_2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(30, 138, 1010, 2);
		panel_TaiKhoan.add(separator_5);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setBounds(30, 372, 1010, 2);
		panel_TaiKhoan.add(separator_5_1);
		
		JLabel lblNewpass = new JLabel("NEW PASSWORD:");
		lblNewpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewpass.setBounds(78, 456, 152, 26);
		panel_TaiKhoan.add(lblNewpass);
		
		JLabel lblNewLabel_5 = new JLabel("CONFIRM NEW PASSWORD:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(77, 539, 267, 26);
		panel_TaiKhoan.add(lblNewLabel_5);
		
		JSeparator separator_5_2 = new JSeparator();
		separator_5_2.setBounds(30, 59, 1010, 2);
		panel_TaiKhoan.add(separator_5_2);
		
		JButton btnChange = new JButton("CHANGE");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChange.setBounds(633, 527, 116, 38);
		btnChange.addActionListener(controller);
		panel_TaiKhoan.add(btnChange);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(215, 254, 314, 71);
		panel_TaiKhoan.add(layeredPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 19, 211, 42);
		layeredPane.add(passwordField, Integer.valueOf(1));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
			}
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('●');
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lblNewLabel_6.setBounds(212, 19, 38, 42);
		layeredPane.add(lblNewLabel_6, Integer.valueOf(2));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(368, 425, 297, 57);
		panel_TaiKhoan.add(layeredPane_1);
		
		TextNew_password = new JPasswordField();
		TextNew_password.setBounds(24, 10, 211, 42);
		layeredPane_1.add(TextNew_password, Integer.valueOf(1));
		TextNew_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TextNew_password.setEchoChar((char) 0);
			}
			public void mouseReleased(MouseEvent e) {
				TextNew_password.setEchoChar('●');
			}
		});
		lblNewLabel_7.setBounds(199, 10, 36, 42);
		layeredPane_1.add(lblNewLabel_7, Integer.valueOf(2));
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(368, 516, 297, 57);
		panel_TaiKhoan.add(layeredPane_2);
		
		TextConfirm_password = new JPasswordField();
		TextConfirm_password.setBounds(26, 10, 211, 42);
		layeredPane_2.add(TextConfirm_password, Integer.valueOf(1));
		TextConfirm_password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TextConfirm_password.setEchoChar((char) 0);
			}
			public void mouseReleased(MouseEvent e) {
				TextConfirm_password.setEchoChar('●');
			}
		});
		lblNewLabel_8.setBounds(201, 10, 36, 42);
		layeredPane_2.add(lblNewLabel_8, Integer.valueOf(2));
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_email.setBounds(571, 176, 78, 42);
		panel_TaiKhoan.add(lbl_email);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_email.setBounds(674, 173, 243, 44);
		panel_TaiKhoan.add(textField_email);
		textField_email.setColumns(10);
		
		btnRefresh.addActionListener(controller);
		btnUpdate.addActionListener(controller);
		btnNewButton_save.addActionListener(controller);
		btnCancel.addActionListener(controller);
		btnDelete.addActionListener(controller);
		btnFind.addActionListener(controller);
		
		showData(NhanVienDAO.findAll());

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void showData(List<NhanVien> nv) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (NhanVien nhanVien : nv) {
			String gioiTinh;
			if (nhanVien.getGioiTinh() == 0) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] { nhanVien.getId(), nhanVien.getTen(), nhanVien.getTuoi(), gioiTinh,
					nhanVien.getChucVu(), nhanVien.getLuong(), });
		}
	}
	public void showDataFind(List<NhanVien> nv) {
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		tableModel.setRowCount(0);
		for (NhanVien nhanVien : nv) {
			String gioiTinh;
			if (nhanVien.getGioiTinh() == 0) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] { nhanVien.getId(), nhanVien.getTen(), nhanVien.getTuoi(), gioiTinh,
					nhanVien.getChucVu(), nhanVien.getLuong(), });
		}
	}

	public void refresh() {
		this.textField_timKiem.setText("");
		this.textField_ten.setText("");
		this.textField_tuoi.setText("");
		this.textField_chucVu.setText("");
		this.textField_luong.setText("");
		this.comboBox.setSelectedIndex(-1);
	}

	public void them() {
		NhanVien nv = new NhanVien();
		nv.setTen(this.textField_ten.getText());
		nv.setTuoi(Integer.valueOf(this.textField_tuoi.getText()));
		if(comboBox.getSelectedIndex() == 1) {
			nv.setGioiTinh(0);
		}else if(comboBox.getSelectedIndex() == 2) {
			nv.setGioiTinh(1);
		}
		nv.setChucVu(this.textField_chucVu.getText());
		nv.setLuong(Integer.valueOf(this.textField_luong.getText()));
		NhanVienDAO.insert(nv);
		JOptionPane.showMessageDialog(null, "Save success");
		showData(NhanVienDAO.findAll());
	}

	public void xoa() {
		NhanVien nv = new NhanVien();
		nv.setTen(this.textField_timKiem.getText());
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên "+this.textField_timKiem.getText(),"Xóa", JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION)
		NhanVienDAO.delete(nv);
		showData(NhanVienDAO.findAll());
	}
	
	public void timKiem() {
		NhanVien nv = new NhanVien();
		nv.setTen(this.textField_timKiem.getText());
		showDataFind(NhanVienDAO.findByName(nv));
	}
	
	public void huyTim() {
		List<NhanVien> list = new ArrayList<>();
		showDataFind(list);
	}
	
	public void update() {
		NhanVien nv = new NhanVien();	
		nv.setTen(this.textField_ten.getText());
		nv.setTuoi(Integer.valueOf(this.textField_tuoi.getText()));
		if(comboBox.getSelectedIndex() == 1) {
			nv.setGioiTinh(0);
		}else if(comboBox.getSelectedIndex() == 2) {
			nv.setGioiTinh(1);
		}
		nv.setChucVu(this.textField_chucVu.getText());
		nv.setLuong(Integer.valueOf(this.textField_luong.getText()));
		NhanVienDAO.update(nv);
		JOptionPane.showMessageDialog(null, "Update success");
		showData(NhanVienDAO.findAll());
	}
	
	public void dangXuat() {
		int lc = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất?","Đăng xuất", JOptionPane.YES_NO_OPTION);
		if(lc != JOptionPane.YES_OPTION) {
			return;
		}else {
			LoginView lg = new LoginView();
			lg.setVisible(true);
			this.dispose();
		}
	}
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void thucHienSaveFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if(returnVal == fc.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			saveFile(file.getAbsolutePath());
		}
	}
	
	public void saveFile(String path) {
		List<NhanVien> listNv = new ArrayList<>();
		try {
			File file = new File(path);
			FileWriter write = new FileWriter(file);
			write.write("Thông tin nhân viên!\n");
			write.write("Id\tTên\t   Tuổi\t\tGiới tính\t Chức vụ\t\tLương.\n");
			int rowNumber = table.getRowCount();
            for (int i = 0; i < rowNumber; i++) {
                int id = (int) table.getValueAt(i, 0);
                String ten = (String) table.getValueAt(i, 1);
                int tuoi = (int) table.getValueAt(i, 2);
                int gioiTinh = table.getValueAt(i, 3).toString()=="Nam"?0:1;
                String chucVu = (String) table.getValueAt(i, 4);
                int luong = (int) table.getValueAt(i, 5);
                NhanVien nv = new NhanVien(id,ten,tuoi,gioiTinh, chucVu,luong);               
                listNv.add(nv);
            }
            for (NhanVien nhanVien : listNv) {
				String line = nhanVien.getId() +"\t " + nhanVien.getTen() + "\t\t"+ nhanVien.getTuoi()+"\t   "+
						nhanVien.getGioiTinh()+"\t\t    " +nhanVien.getChucVu()+"\t\t "+nhanVien.getLuong()+"\n";
				write.write(line);
			}
            write.close();
            JOptionPane.showMessageDialog(this, "Lưu file thành công!");			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Không thế lưu file!");
			e.printStackTrace();
		}
	}

	public void changePass() {
		int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đổi mật khẩu!", "Confirm", JOptionPane.YES_NO_OPTION);
		if(dk != JOptionPane.YES_OPTION) {
			return;
		}
			
		if(this.TextNew_password.getText().equals("") || this.TextConfirm_password.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin để thay đổi mật khẩu!");
			return;
		}else if(!this.TextConfirm_password.getText().equals(this.TextNew_password.getText())) {
			JOptionPane.showMessageDialog(this, "Mật khẩu phải giống nhau");
			return;
		}else if(this.TextNew_password.getText().equals(this.passwordField.getText())) {
			JOptionPane.showMessageDialog(this, "Mật khẩu mới phải khác mật khẩu cũ!");
			return;
		}
		if(checkPass(TextNew_password.getText())) {
			try {
				String sql = "UPDATE user SET password =? WHERE password = ? AND userName=?";
				Connection con = NhanVienDAO.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, this.TextNew_password.getText());
				pst.setString(2, this.passwordField.getText());
				pst.setString(3, this.textField_username.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
				this.passwordField.setText(this.TextNew_password.getText());
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showConfirmDialog(this, "Đổi mật khẩu thất bại!");
			}		
		}
	}
	
	public boolean checkPass(String password) {
		if (password.length() < 6) {
	        JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất 6 ký tự");
	        return false;
	    }
		boolean hasLetter = false;
	    boolean hasNumber = false;
	    for (char c : password.toCharArray()) {
	        if (Character.isLetter(c)) {
	            hasLetter = true;
	        } else if (Character.isDigit(c)) {
	            hasNumber = true;
	        }
	    }
	    if (!hasLetter || !hasNumber) {
	        JOptionPane.showMessageDialog(null, "Mật khẩu phải chứa ít nhất một chữ cái và một chữ số ");
	        return false;
	    }
		return true;
	}
	
	public void showDataSort() {
		showData(NhanVienDAO.sortFindAll());
	}
}


