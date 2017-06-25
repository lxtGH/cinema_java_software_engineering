package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.Session;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class CheckAdministratorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;



	/**
	 * Create the frame.
	 */
	public CheckAdministratorFrame(ArrayList<Session> sessionList,ArrayList<Movie> movie_list) {
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(85, 79, 54, 15);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(85, 127, 54, 15);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(162, 76, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 124, 66, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(
		 /**
		 * @author lxt
		 *
		 */
		new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// check the administer information
				if(textField.getText().equals("sys")&&passwordField.getText().equals("123456")){
					new MainFrameForAdminister(sessionList,movie_list);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Error input!");
					return;
				}
			}
		});
		btnNewButton.setBounds(85, 199, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(210, 199, 93, 23);
		contentPane.add(btnBack);
	}
}
