package backup;
import Classes.mySeat;
import GUI.BasicScreen;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Classes.Session;


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
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		super.buy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
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
	
	
	public static void main(String[] args) {
		Screen1 sc1= new Screen1();
		sc1.setVisible(true);
		sc1.getRow_1().setSeats(8);
	}
}
