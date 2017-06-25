package backup;

import java.util.ArrayList;
import javax.swing.JPanel;

import Classes.mySeat;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class myRow_1 extends JPanel {
	//private ArrayList<mySeat> list = new ArrayList<mySeat>();
	private mySeat[] seatList;
	
	public mySeat[] getSeatList() {
		return seatList;
	}
	public void setSeatList(mySeat[] seatList) {
		this.seatList = seatList;
	}
/*	public ArrayList<mySeat> getList() {
		return list;
	}
	public void setList(ArrayList<mySeat> list) {
		this.list = list;
	}*/


	//private myButton mbt = new myButton();
	private int numOfseats;
	private String rowNum;
	private String screen_num;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JPanel panel_0;
	JPanel panel_1;
	
	public myRow_1(int numOfseats,String rowNum,String screen_num) {
		seatList =new mySeat[numOfseats];
		setLayout(null);
		this.numOfseats=numOfseats;
		this.rowNum=rowNum;
		this.screen_num=screen_num;
		panel_0 = new JPanel();
		panel_0.setBounds(65, 10, 189, 38);
		add(panel_0);
		panel_0.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//panel_0.add(mbt);
		
		panel_1 = new JPanel();
		panel_1.setBounds(291, 10, 189, 38);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblNewLabel = new JLabel(rowNum);
		lblNewLabel.setBounds(484, 10, 54, 15);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("row:"+rowNum);
		lblNewLabel_1.setBounds(0, 10, 54, 15);
		add(lblNewLabel_1);

		addSeats();
	}

	
	public void addSeats(){
		
		if(numOfseats%2!=0){
			System.out.println("wrong row's size, must be even");
		}
		
		for(int i=numOfseats;i>0;i--){
			if(i>numOfseats/2){
				mySeat temp = new mySeat(i,rowNum,screen_num);
				panel_0.add(temp);
				seatList[i-1]=temp;
			}
			else{
				mySeat temp = new mySeat(i,rowNum,screen_num);
				panel_1.add(temp);
				seatList[i-1]=temp;
			}
		}
	}

	//set the seats False means that ticket 
	public void setSeats(int numOfseats){
		if(numOfseats>this.numOfseats){
			System.out.println("Out of bounds exception");
			return;
		}
		mySeat temp=seatList[numOfseats-1];
		temp.setBackground(Color.RED);
		temp.setAvailable(false);
	}
	public mySeat getSet(int numOfseats){
		
		if(numOfseats>this.numOfseats){
			System.out.println("Out of bounds exception");
			return null;
		}
		return seatList[numOfseats-1];
	}
	
}
