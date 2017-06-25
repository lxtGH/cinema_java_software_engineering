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


/**
 * this frame is used for refund the ticket 
 * @author lxt
 *
 */
public class RefundTicket extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox ;
	private search_util s_util = new search_util();
	private ticket_util t_util = new ticket_util();

	/**
	 * Create the frame.
	 */
	public RefundTicket(ArrayList<Session> sessionList) {
		setBounds(100, 100, 601, 244);
		ArrayList<Ticket> ticket_list = s_util.getTiketSessionList(sessionList);  //get the ticketList
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Refund");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticket=comboBox.getSelectedItem().toString();
				String ticket_split []= ticket.split("-"); // to get the Ticket ID
				Ticket tmp = s_util.getTicketFromTk_list(ticket_split[1], ticket_list);
				Session session_tmp=s_util.getSessionFromSessionListByTicket(sessionList, tmp);
				tmp.getSeat().setAvailable(true);// re set the Seat
				session_tmp.getSession_Screen().getTicket_list().remove(tmp); // remove the ticket from the list
				JOptionPane.showMessageDialog(null, "You have been refund this ticket");
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						setCombox(ticket_list);
					}
				}).start();
				return;
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
		setCombox(ticket_list);
		
		JLabel lblChooseTheTicket = new JLabel("Choose The Ticket To Refund");
		lblChooseTheTicket.setBounds(212, 22, 263, 15);
		contentPane.add(lblChooseTheTicket);
	}
	
	void setCombox(ArrayList<Ticket> ticket_list){
		comboBox.removeAllItems();
		for(Ticket ticket :ticket_list){
			comboBox.addItem(ticket.ticketInfor().toString());
		}
	}
}
