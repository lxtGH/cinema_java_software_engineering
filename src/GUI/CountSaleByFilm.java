package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.Session;
import Classes.Ticket;
import util.search_util;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CountSaleByFilm extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public CountSaleByFilm(ArrayList<Session> sessionList,ArrayList<Movie> movie_list) {
		search_util s_util = new search_util();
		this.setVisible(true);
		ArrayList<Ticket> ticket_list = s_util.getTiketSessionList(sessionList);  //get the ticketList
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(97, 81, 54, 15);
		contentPane.add(lblFilm);
		
		JComboBox comboBox = new JComboBox();
		for(Movie movie:movie_list)
			comboBox.addItem(movie.getName().toString());
		
		comboBox.setBounds(161, 78, 107, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Sale Amount");
		lblNewLabel.setBounds(97, 136, 73, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("default");
		lblNewLabel_1.setBounds(176, 136, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filmName = comboBox.getSelectedItem().toString();
				double amount = search_util.countTheSaleByFilm(filmName, ticket_list);
				lblNewLabel_1.setText(amount+"");
				return;
			}
		});
		btnNewButton.setBounds(167, 179, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(167, 212, 93, 23);
		contentPane.add(btnBack);
	}
}
