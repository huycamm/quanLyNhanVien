package test;

import javax.swing.UIManager;

import view.LoginView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

