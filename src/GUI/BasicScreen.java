package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.mySeat;
import util.ticket_util;
import Classes.Session;
import Classes.Ticket;
import Classes.myScreen;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
/**
 * 
 * This class has the following functions
 * (1)display the Screen (seat location,row location)
 * (2)to calculate the price of the ticket according to the seats
 * (3)to record the ticket information into a ticketList
 * @author lala
 *
 */
public class BasicScreen extends JFrame {
	
	
	protected String current_Ticket_Type;
	protected Double current_Ticket_Price;
	protected Session current_Session;
	protected ArrayList<mySeat> seatListForSelected;
	
	protected CheckStudentID checkStudentID;
	
	public CheckStudentID getCheckStudentID() {
		return checkStudentID;
	}

	public void setCheckStudentID(CheckStudentID checkStudentID) {
		this.checkStudentID = checkStudentID;
	}

	public ArrayList<mySeat> getSeatListForSelected() {
		return seatListForSelected;
	}

	public void setSeatListForSelected(ArrayList<mySeat> seatListForSelected) {
		this.seatListForSelected = seatListForSelected;
	}

	private ArrayList<Ticket> ticket_list;

	public Session getCurrent_Session() {
		return current_Session;
	}

	public void setCurrent_Session(Session current_Session) {
		this.current_Session = current_Session;
	}
	
	public Double getCurrent_Ticket_Price() {
		return current_Ticket_Price;
	}

	public void setCurrent_Ticket_Price(Double current_Ticket_Price) {
		this.current_Ticket_Price = current_Ticket_Price;
	}

	public String getCurrent_Ticket_Type() {
		return current_Ticket_Type;
	}
	
	public void setCurrent_Ticket_Type(String current_Ticket_Type) {
		this.current_Ticket_Type = current_Ticket_Type;
	}


	
	public ArrayList<Ticket> getTicket_list() {
		return ticket_list;
	}

	public void setTicket_list(ArrayList<Ticket> ticket_list) {
		this.ticket_list = ticket_list;
	}

	private JPanel contentPane;
	private myScreen screen;
	protected JButton buy;
	protected JButton back;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicScreen frame = new BasicScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construct 
	 */
	public BasicScreen(){
		seatListForSelected= new ArrayList<mySeat>(); //this is used for storing saved tickets
		ticket_list = new  ArrayList<Ticket>();  // this is used for storing the tickets
		this.setVisible(false); 
		screen = new myScreen();
		screen.setLocation(144, 268);
		setBounds(100, 100, 661, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(screen);
		
		JLabel lblNewLabel = new JLabel("Available");
		lblNewLabel.setBounds(10, 227, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Unavailable");
		lblNewLabel_1.setBounds(10, 252, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setVisible(true);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(98, 227, 15, 15);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.RED);
		button_1.setEnabled(false);
		button_1.setBounds(98, 248, 15, 15);
		contentPane.add(button_1);
		
		JLabel lblRow = new JLabel("ROW:");
		lblRow.setBounds(581, 10, 54, 15);
		contentPane.add(lblRow);
		
		JLabel lblExit = new JLabel("EXIT\uFF1A");
		lblExit.setBounds(10, 25, 54, 15);
		contentPane.add(lblExit);
		
		 buy = new JButton("buy");
		 buy.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 	}
		 });
		buy.setBounds(552, 223, 93, 23);
		contentPane.add(buy);
		
		 back = new JButton("back");
		 back.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		back.setBounds(552, 248, 93, 23);
		contentPane.add(back);
		
		JLabel lblChoosen = new JLabel("Choosen");
		lblChoosen.setBounds(10, 205, 54, 15);
		contentPane.add(lblChoosen);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setBackground(Color.BLUE);
		button.setBounds(98, 202, 15, 15);
		contentPane.add(button);
		lblNewLabel_1.setVisible(true);
		
	}
}
