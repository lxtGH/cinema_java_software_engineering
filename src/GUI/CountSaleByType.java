package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Session;
import Classes.Ticket;
import util.search_util;
import util.ticket_util;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CountSaleByType extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public CountSaleByType(ArrayList<Session> sessionList) {
		search_util s_util = new search_util();
		this.setVisible(true);
		ArrayList<Ticket> ticket_list = s_util.getTiketSessionList(sessionList);  //get the ticketList
		setBounds(100, 100, 391, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectTicketType = new JLabel("Select Ticket Type");
		lblSelectTicketType.setBounds(124, 56, 122, 15);
		contentPane.add(lblSelectTicketType);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(57, 97, 54, 15);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Senior", "Child", "Adult"}));
		comboBox.setBounds(144, 94, 74, 21);
		contentPane.add(comboBox);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(57, 136, 54, 15);
		contentPane.add(lblAmount);
		
		JLabel lblDefault = new JLabel("default");
		lblDefault.setBounds(144, 136, 54, 15);
		contentPane.add(lblDefault);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = comboBox.getSelectedItem().toString();
				double amount = ticket_util.calculateTicketPriceByType(type, ticket_list);
				lblDefault.setText(amount+"");
				return;
			}
		});
		btnSearch.setBounds(144, 186, 93, 23);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(144, 219, 93, 23);
		contentPane.add(btnBack);
	}

}
