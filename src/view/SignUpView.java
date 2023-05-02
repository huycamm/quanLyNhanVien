package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.NhanVienDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirm;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 237, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_userName = new JTextField();
		textField_userName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_userName.setBounds(73, 142, 261, 39);
		contentPane.add(textField_userName);
		textField_userName.setColumns(10);
		
		JLabel lblUsername = new JLabel("User name:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(74, 100, 127, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(435, 100, 104, 32);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(435, 189, 168, 32);
		contentPane.add(lblConfirmPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 76, 746, 4);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Sign up");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\user.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(299, 10, 149, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSignup = new JButton("Sign up");
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignup.setBounds(401, 311, 112, 39);
		contentPane.add(btnSignup);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 293, 746, 2);
		contentPane.add(separator_1);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signIn();	
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogIn.setBounds(234, 311, 112, 39);
		contentPane.add(btnLogIn);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_email.setBounds(73, 191, 67, 30);
		contentPane.add(lbl_email);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_email.setColumns(10);
		textField_email.setBounds(73, 233, 261, 39);
		contentPane.add(textField_email);
		
		JLayeredPane layeredPane1 = new JLayeredPane();
		layeredPane1.setBounds(426, 125, 307, 56);
		contentPane.add(layeredPane1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 10, 261, 39);
		layeredPane1.add(passwordField, Integer.valueOf(1));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_show = new JLabel("");
		lblNewLabel_show.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
			}
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('●');
			}
		});
		lblNewLabel_show.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lblNewLabel_show.setBounds(233, 10, 38, 39);
		layeredPane1.add(lblNewLabel_show, Integer.valueOf(2));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(426, 223, 307, 60);
		contentPane.add(layeredPane);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setBounds(10, 10, 261, 39);
		layeredPane.add(passwordField_confirm, Integer.valueOf(1));
		passwordField_confirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_show2 = new JLabel("");
		lblNewLabel_show2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField_confirm.setEchoChar((char) 0);
			}
			public void mouseReleased(MouseEvent e) {
				passwordField_confirm.setEchoChar('●');
			}
			
		});
		lblNewLabel_show2.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\showPass.png"));
		lblNewLabel_show2.setBounds(233, 10, 38, 39);
		layeredPane.add(lblNewLabel_show2, Integer.valueOf(2));
		
		this.setLocationRelativeTo(null);
	}
	
	public void signUp() {
		try {
			int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng ký", "Confirm", JOptionPane.YES_NO_OPTION);
			if(dk != JOptionPane.YES_OPTION) {
				return;
			}
			if(this.textField_userName.getText().equals("") || this.passwordField.getText().equals("") || 
			this.passwordField_confirm.getText().equals("") || this.textField_email.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Không để thông tin trống!");
				return;
			}else if(!this.passwordField.getText().equals(this.passwordField_confirm.getText())){
				JOptionPane.showMessageDialog(this, "Mật khẩu phải giống nhau!");
				return;
			}
			if(checkPass(passwordField.getText())) {
				Connection connection = NhanVienDAO.getConnection();
				String sql_select = "SELECT userName FROM user;";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(sql_select);
				List<String> user = new ArrayList<>();
				while(rs.next()) {
					String name = rs.getString("userName").toLowerCase();
					user.add(name);
				}
				if(user.contains(this.textField_userName.getText().toLowerCase())) {
					JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại hãy đổi user name!");
					return;
				}
				String sql = "INSERT INTO user(userName,password,email) VALUES(?,?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, this.textField_userName.getText());
				ps.setString(2, this.passwordField.getText());
				ps.setString(3, this.textField_email.getText());
				ps.executeUpdate();	
				JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Đăng ký thất bại!");
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

	public void signIn() {
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
		this.dispose();
	}
}
