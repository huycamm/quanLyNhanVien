package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.NhanVienDAO;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

public class LoginView extends JFrame {
	private JPanel contentPane;
	private JTextField textField_userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 237, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lbl_userName = new JLabel("User name:");
		lbl_userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_userName.setBounds(90, 90, 102, 32);
		contentPane.add(lbl_userName);
		
		JLabel lbl_passWord = new JLabel("Password:");
		lbl_passWord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_passWord.setBounds(90, 191, 102, 32);
		contentPane.add(lbl_passWord);
		
		textField_userName = new JTextField();
		textField_userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_userName.setBounds(90, 132, 330, 36);
		contentPane.add(textField_userName);
		textField_userName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(90, 303, 113, 37);
		contentPane.add(btnLogin);
		
		JButton btnSignin = new JButton("Sign up");
		btnSignin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignin.setBounds(307, 303, 113, 37);
		contentPane.add(btnSignin);
			
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 72, 466, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 291, 459, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(159, 10, 204, 52);
		contentPane.add(lblNewLabel);		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(62, 217, 420, 60);
		contentPane.add(layeredPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 10, 330, 37);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbl_show = new JLabel("");
		lbl_show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char)0);
			}
			public void mouseReleased(MouseEvent e) {
                passwordField.setEchoChar('●');
            }
		});
		lbl_show.setBounds(317, 10, 42, 37);
		lbl_show.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lbl_show.setHorizontalAlignment(SwingConstants.LEFT);
		
		layeredPane.add(passwordField, Integer.valueOf(1));
		layeredPane.add(lbl_show, Integer.valueOf(2));
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void login() {
		if(textField_userName.getText().equals("") || passwordField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Mời bạn nhập đầy đủ thông tin tài khoản");
			return;
		}
		try {
			Connection connection = NhanVienDAO.getConnection();
			String sql = "SELECT * FROM user WHERE userName = ? AND password =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, textField_userName.getText());
			ps.setString(2, passwordField.getText());
			ResultSet rs = ps.executeQuery();		
			if(rs.next()){
				NhanVienView nhanVienView = new NhanVienView();
				nhanVienView.setVisible(true);
				nhanVienView.textField_username.setText(rs.getString("userName"));
				nhanVienView.passwordField.setText(rs.getString("password"));
				nhanVienView.textField_email.setText(rs.getString("email"));
				this.dispose();
				JOptionPane.showMessageDialog(nhanVienView, "Đăng nhập thành công!");
			}else {
				JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!");
		}
	}

	public void signUp() {
		SignUpView su = new SignUpView();
		su.setVisible(true);
		this.dispose();
	}
}
