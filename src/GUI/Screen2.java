package GUI;


import GUI.BasicScreen;
import util.ticket_util;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Classes.Ticket;
import Classes.mySeat;

import java.awt.event.ActionEvent;

public class Screen2 extends BasicScreen {
	private String screen_name="Screen2";
	private myRow_1 row_A,row_B,row_C,row_D;
	
	public myRow_1 getRow_A() {
		return row_A;
	}


	public void setRow_A(myRow_1 row_A) {
		this.row_A = row_A;
	}


	public myRow_1 getRow_B() {
		return row_B;
	}


	public void setRow_B(myRow_1 row_B) {
		this.row_B = row_B;
	}


	public myRow_1 getRow_C() {
		return row_C;
	}


	public void setRow_C(myRow_1 row_C) {
		this.row_C = row_C;
	}


	public myRow_1 getRow_D() {
		return row_D;
	}


	public void setRow_D(myRow_1 row_D) {
		this.row_D = row_D;
	}


	public Screen2() {
		this.setTitle(this.screen_name);
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = searchForSelectedSeat();
				//System.out.println("count:"+count);
				double totalPrice=ticket_util.calculatePrice(getCurrent_Ticket_Price(), getCurrent_Ticket_Type(), count);
				JOptionPane.showMessageDialog(null, "totalPrice: "+totalPrice);
				int answer=JOptionPane.showConfirmDialog(null,"Do you confirm this payment?","Notation",JOptionPane.YES_NO_OPTION);
				if(answer==JOptionPane.NO_OPTION){
					return;
				}
				//System.out.println("size:"+getSeatListForSelected().size());
				for(mySeat seat :getSeatListForSelected()){
					seat.setAvailable(false);
					seat.setText(seat.getNumOfseat()+"");
					Ticket temp = ticket_util.generateTicket(getCurrent_Session(),seat, getCurrent_Ticket_Type());	
					temp.setPrice(ticket_util.calculateTicketPrice(current_Ticket_Price, current_Ticket_Type));
					//temp.setType(current_Ticket_Type);
					getTicket_list().add(temp);
				}
				getSeatListForSelected().clear();
				dispose();
				//System.out.println("Buy ticket number: "+getTicket_list().size());
			}
		});
		 row_A = new myRow_1(6, "A",screen_name);
		row_A.setSize(494, 43);
		row_A.setLocation(78, 180);
		getContentPane().add(row_A);
		
		 row_B = new myRow_1(6, "B",screen_name);
		row_B.setBounds(78, 125, 494, 43);
		getContentPane().add(row_B);
		
		 row_C = new myRow_1(6, "C",screen_name);
		row_C.setBounds(78, 72, 494, 43);
		getContentPane().add(row_C);
		
		 row_D = new myRow_1(8, "D",screen_name);
		row_D.setBounds(78, 19, 494, 43);
		getContentPane().add(row_D);
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
	public static void main(String[] args) {
		Screen2 sc2= new Screen2();
		sc2.setVisible(true);
		
	}
}
