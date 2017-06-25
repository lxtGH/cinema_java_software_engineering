package GUI;
import Classes.mySeat;
import GUI.BasicScreen;
import util.ticket_util;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classes.Session;
import Classes.Ticket;

/**
 * Screen1 which is a super class of BasicScreen
 * @author lxt
 *
 */
public class Screen1 extends BasicScreen {
	
	private String screen_name="Screen1";
	private myRow_1 row_A,row_B,row_C,row_D;
	
	public String getScreen_name() {
		return screen_name;
	}

	
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	
	
	public myRow_1 getRow_1() {
		return row_A;
	}

	public void setRow_1(myRow_1 row_1) {
		this.row_A = row_1;
	}

	public myRow_1 getRow_2() {
		return row_B;
	}

	public void setRow_2(myRow_1 row_2) {
		this.row_B = row_2;
	}

	public myRow_1 getRow_3() {
		return row_C;
	}

	public void setRow_3(myRow_1 row_3) {
		this.row_C = row_3;
	}

	public myRow_1 getRow_4() {
		return row_D;
	}

	public void setRow_4(myRow_1 row_4) {
		this.row_D = row_4;
	}

	
	//for demo
	public Screen1() {
		//String Ticket_Type = super.current_Ticket_Type;
		this.setTitle(this.screen_name);
		buy.addActionListener(new ActionListener() {
			/**
			 * record the buy operation
			 */
			public void actionPerformed(ActionEvent e) {
				int count = searchForSelectedSeat();//record the count that user has been
				double totalPrice=ticket_util.calculatePrice(getCurrent_Ticket_Price(), getCurrent_Ticket_Type(), count);
				JOptionPane.showMessageDialog(null, "totalPrice: "+totalPrice);
//				if(current_Ticket_Type.equals("Student")){
//					setCheckStudentID(new CheckStudentID(count));
//				}
//				while(true){
//					if(getCheckStudentID().isActive()==false){
//						break;
//					}
//				 // no operation	
//				}
				int answer=JOptionPane.showConfirmDialog(null,"Do you confirm this payment?","Notation",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.NO_OPTION){
					return;
				}

				//set the all seats unavailable and record the tickets 
				for(mySeat seat :getSeatListForSelected()){
					seat.setAvailable(false);// set the available false to the seat
					seat.setText(seat.getNumOfseat()+"");
					Ticket temp = ticket_util.generateTicket(getCurrent_Session(),seat, getCurrent_Ticket_Type());	
					temp.setPrice(ticket_util.calculateTicketPrice(current_Ticket_Price, current_Ticket_Type)); // set the ticket price
					//temp.setType(current_Ticket_Type); //set the ticket type 
					getTicket_list().add(temp); //add to the ticket list 
				}
				
				getSeatListForSelected().clear();
				//System.out.println("Buy ticket number: "+getTicket_list().size());
				dispose();
				return;
			}
		});
	
		//this.setScreen_name("Screen1");
		 row_A = new myRow_1(8, "A",screen_name);
		row_A.setBounds(61, 173, 530, 46);
		getContentPane().add(row_A);
		
		//row.getComponent(n)
		 row_B = new myRow_1(8, "B",screen_name);
		row_B.setBounds(61, 114, 530, 46);
		getContentPane().add(row_B);
		
		 row_C = new myRow_1(8, "C",screen_name);
		row_C.setBounds(61, 57, 530, 46);
		getContentPane().add(row_C);
		
		 row_D = new myRow_1(8, "D",screen_name);
		row_D.setBounds(61, 1, 530, 46);
		getContentPane().add(row_D);
	}
	
	public Screen1(Session session){
		//this.setScreen_name("Screen1");
		 row_A = new myRow_1(8, "A",screen_name);
		row_A.setBounds(61, 173, 530, 46);
		getContentPane().add(row_A);
		
		//row.getComponent(n)
		 row_B = new myRow_1(8, "B",screen_name);
		row_B.setBounds(61, 114, 530, 46);
		getContentPane().add(row_B);
		
		 row_C = new myRow_1(8, "C",screen_name);
		row_C.setBounds(61, 57, 530, 46);
		getContentPane().add(row_C);
		
		 row_D = new myRow_1(8, "D",screen_name);
		row_D.setBounds(61, 1, 530, 46);
		getContentPane().add(row_D);
		super.buy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});		
	}
	
	
	
	int searchForSelectedSeat(){
		int count=0;
		mySeat[] ms1 = row_A.getSeatList();
		mySeat[] ms2 = row_B.getSeatList();
		mySeat[] ms3 = row_C.getSeatList();
		mySeat[] ms4 = row_D.getSeatList();
		for(mySeat x:ms1)
			if(x.getText().equals("Y")&&x.isAvailable()){
				System.out.println(x.seatInfo());
				getSeatListForSelected().add(x);
				count++;
			}
		for(mySeat x:ms2)
			if(x.getText().equals("Y")&&x.isAvailable()){
				System.out.println(x.seatInfo());
				getSeatListForSelected().add(x);
				count++;
			}
		for(mySeat x:ms3)
			if(x.getText().equals("Y")&&x.isAvailable()){
				System.out.println(x.seatInfo());
				getSeatListForSelected().add(x);
				count++;
			}
		for(mySeat x:ms4)
			if(x.getText().equals("Y")&&x.isAvailable()){
				System.out.println(x.seatInfo());
				getSeatListForSelected().add(x);
				count++;
			}
		return count;
	}
	
/*	public void getList(){
		ArrayList<mySeat> list = row_1.getList();
		int count=0;
		for(mySeat x:list){
			if(x.getBackground()==Color.RED&&x.isAvailable()){
				System.out.println(x.seatInfo());
				count++;
			}
		}
		System.out.println("you have choosen "+count);
	}
	*/
	
	

}
