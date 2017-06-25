package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.Session;
import Classes.Ticket;
import util.search_util;
import util.ticket_util;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintTicket extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox ;
	private search_util s_util = new search_util();
	private ticket_util t_util = new ticket_util();

	/**
	 * Create the frame.
	 */
	public PrintTicket(ArrayList<Session> sessionList) {
		setBounds(100, 100, 601, 244);
		ArrayList<Ticket> ticket_list = s_util.getTiketSessionList(sessionList);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticket=comboBox.getSelectedItem().toString();
				String ticket_split []= ticket.split("-");
				Ticket tmp = s_util.getTicketFromTk_list(ticket_split[1], ticket_list);
				if(tmp.getType().equals("Student")){
					new CheckStudentID(1,sessionList,ticket_list,tmp);
					return;
				}
				else{
					//Session session_tmp=s_util.getSessionFromSessionListByTicket(sessionList, tmp);
					//session_tmp.getSession_Screen().getTicket_list().remove(tmp); // remove the ticket from the list
					tmp.setPrinted(true);
					t_util.printTicket(tmp);
					JOptionPane.showConfirmDialog(null, "Print the Selected Tickects");
					return;
				}

			}
		});
		btnNewButton.setBounds(200, 125, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(342, 125, 93, 23);
		contentPane.add(btnBack);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(10, 57, 557, 28);
		contentPane.add(comboBox);
		for(Ticket ticket :ticket_list){
			if(!ticket.isPrinted())
			comboBox.addItem(ticket.ticketInfor().toString());
		}
		
		JLabel lblChooseTheTicket = new JLabel("Choose The Ticket To Print");
		lblChooseTheTicket.setBounds(212, 22, 263, 15);
		contentPane.add(lblChooseTheTicket);
	}
}
