package backup;

import java.util.ArrayList;

import javax.swing.JPanel;

import Classes.mySeat;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class myRow_2 extends JPanel{
	JPanel panel;
	//private ArrayList<mySeat> list = new ArrayList<mySeat>();
	private mySeat[] seatList;
	public mySeat[] getSeatList() {
		return seatList;
	}

	public void setSeatList(mySeat[] seatList) {
		this.seatList = seatList;
	}

	private int numOfseats;
	private String screen_num;


	public int getNumOfseats() {
		return numOfseats;
	}

	public void setNumOfseats(int numOfseats) {
		this.numOfseats = numOfseats;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public JPanel getPanel() {
		return panel;
	}

	private String rowNum;
	public myRow_2(int numOfseats,String rowNum,String screen_num) {
		seatList = new mySeat[numOfseats];
		this.numOfseats = numOfseats;
		this.rowNum = rowNum;
		this.screen_num=screen_num;
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(52, 10, 380, 28);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("row:"+rowNum);
		label.setBounds(0, 10, 54, 15);
		add(label);
		JLabel label_1 = new JLabel(rowNum);
		label_1.setBounds(442, 10, 54, 15);
		add(label_1);
		addSeats();
		// TODO Auto-generated constructor stub
	}
	
	public void addSeats(){
		for(int i=numOfseats;i>=1;i--){
			mySeat temp = new mySeat(i,rowNum,screen_num);
			panel.add(temp);
			seatList[i-1]=temp;
		}
	}
	//set the seats False
	public void setSeats(int numOfseats){
		if(numOfseats>this.numOfseats){
			System.out.println("Out of bounds exception");
			return;
		}
		mySeat temp=seatList[numOfseats-1];
		temp.setBackground(Color.RED);
	}
	public mySeat getSet(int numOfseats){
		
		if(numOfseats>this.numOfseats){
			System.out.println("Out of bounds exception");
			return null;
		}
		return seatList[numOfseats-1];
	}
}
