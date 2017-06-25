package GUI;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.Session;
import Classes.Ticket;
import util.csvReader_util;
import util.search_util;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * this is the administer frame 
 * @author lxt
 *
 */
public class MainFrameForAdminister extends JFrame {

	private JPanel contentPane;
	
	/**
	 * MainFrame Class For the Administer 
	 * @param sessionList 
	 * @param movie_list
	 */
	public MainFrameForAdminister(ArrayList<Session> sessionList,ArrayList<Movie> movie_list) {
		search_util s_u= new search_util();
		ArrayList<Ticket> ticket_list = s_u.getTiketSessionList(sessionList); //get the ticket list of the session List
		this.setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCountSale = new JButton("Count Sale By Film");
		btnCountSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CountSaleByFilm(sessionList,movie_list); //launch the count sale frame by choosing movie name
			}
		});
		btnCountSale.setBounds(24, 39, 173, 23);
		contentPane.add(btnCountSale);
		
		JButton btnCountSaleBy = new JButton("Count Sale By Type");
		btnCountSaleBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CountSaleByType(sessionList);//launch the count sale frame by choosing the ticket type
				return;
			}
		});
		btnCountSaleBy.setBounds(24, 83, 173, 23);
		contentPane.add(btnCountSaleBy);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(302, 217, 93, 23);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Generate Report");
		btnNewButton.setBounds(24, 126, 173, 23);
		btnNewButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				csvReader_util.generateReport(ticket_list, movie_list); //generate the ticket report 
				JOptionPane.showMessageDialog(null, "Generate the done!");
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnSendTheEmail = new JButton("Send the email ");
		btnSendTheEmail.setBounds(24, 167, 173, 23);
		btnSendTheEmail.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendEmail(); // Sending Email function
			}
		});
		contentPane.add(btnSendTheEmail);
		
		JLabel lblFunctionByAdministrator = new JLabel("Function By Administrator");
		lblFunctionByAdministrator.setBounds(24, 10, 173, 15);
		contentPane.add(lblFunctionByAdministrator);
	}
	
	/**
	 * Send the Emails interface
	 */
	void sendEmail(){
		JOptionPane.showMessageDialog(null, "Send the message to Administer's email");
	}

}

