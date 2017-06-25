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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CheckStudentID extends JFrame {

	private JPanel contentPane;
	private search_util s_util = new search_util();
	private ticket_util t_util = new ticket_util();
	private JTextField [] testField_array;
	private ArrayList<String> numberList;
	private boolean IsTrue = false;
	private boolean IsAlive = true;
	public boolean isIsAlive() {
		return IsAlive;
	}
	public void setIsAlive(boolean isAlive) {
		IsAlive = isAlive;
	}
	public boolean isIsTrue() {
		return IsTrue;
	}
	public void setIsTrue(boolean isTrue) {
		IsTrue = isTrue;
	}
	/**
	 * Create the frame.
	 */
	public CheckStudentID(int number,ArrayList<Session> sessionList,ArrayList<Ticket> ticket_list,Ticket tmp) {
		setVisible(true);
		setBounds(100, 100, 279, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadFromFile();
				boolean flag = checkID(numberList,testField_array,number);
				if(!flag){
					JOptionPane.showMessageDialog(null, "the number doesn't exist");
					return;
				}
				else{
					//Session session_tmp=s_util.getSessionFromSessionListByTicket(sessionList, tmp);
					//session_tmp.getSession_Screen().getTicket_list().remove(tmp); // remove the ticket from the list
					tmp.setPrinted(true);
					t_util.printTicket(tmp);
					JOptionPane.showMessageDialog(null, "Print the Selected Tickects");
					return;
				}
	
			}
		});
		btnNewButton.setBounds(73, 194, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setIsAlive(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(73, 227, 93, 23);
		contentPane.add(btnNewButton_1);
		testField_array = new JTextField[number];
		int index_location = 48;
		for(int i=0;i<number;i++){
			testField_array[i] = new JTextField();
			testField_array[i].setColumns(10);
			testField_array[i].setBounds(73,index_location,93,21);
			index_location+=30;
			contentPane.add(testField_array[i]);
		}

		JLabel lblPleaseInputThe = new JLabel("Please Input the Students ID ");
		lblPleaseInputThe.setBounds(38, 10, 193, 15);
		contentPane.add(lblPleaseInputThe);
	}
	void ReadFromFile(){
		numberList = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader= new BufferedReader(new FileReader("files/number.txt"));
	        String line = null;  
	        while((line=reader.readLine())!=null){
	        	numberList.add(line);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	boolean checkID(ArrayList<String> list,JTextField [] testField_array,int num){
		boolean flag = false;
		for(int i=0;i<num;i++){
			String tmp = testField_array[i].getText().toString();
			if(list.contains(tmp)){
				flag= true;
			}
			else{
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	
}
