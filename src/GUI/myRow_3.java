package GUI;

import java.util.ArrayList;

import javax.swing.JPanel;

import Classes.mySeat;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;

public class myRow_3 extends JPanel{


	private int numOfseats;
	private String screen_num;
	JPanel panel;
	JPanel panel_1;
	JPanel panel_2;
	private mySeat[] seatList;
	public mySeat[] getSeatList() {
		return seatList;
	}
	public void setSeatList(mySeat[] seatList) {
		this.seatList = seatList;
	}
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
	private String rowNum;
	
	public myRow_3(int numOfseats,String rowNum,String screen_num) {
		seatList = new mySeat[numOfseats];
		setLayout(null);
		this.numOfseats=numOfseats;
		this.rowNum=rowNum;
		this.screen_num=screen_num;
		JLabel label = new JLabel("row:"+rowNum);
		label.setBounds(0, 10, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel(rowNum);
		label_1.setBounds(443, 10, 54, 15);
		add(label_1);
		
		panel = new JPanel();
		panel.setBounds(64, 10, 101, 39);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		panel_1 = new JPanel();
		panel_1.setBounds(196, 10, 101, 39);
		panel_1.setVisible(true);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		panel_2 = new JPanel();
		panel_2.setBounds(326, 10, 101, 39);
		panel_2.setVisible(true);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		addSeats();
	}
	public void addSeats(){
		for(int i=numOfseats;i>0;i--){
			if(i>numOfseats/3*2 ){
				mySeat temp = new mySeat(i,rowNum,screen_num);
				panel.add(temp);
				seatList[i-1]=temp;
			}
			else if (i>numOfseats/3 && i<=numOfseats/3*2){
				mySeat temp = new mySeat(i,rowNum,screen_num);
				panel_1.add(temp);
				seatList[i-1]=temp;
			}
		    else if(i>0&&i<=numOfseats/3){
				mySeat temp = new mySeat(i,rowNum,screen_num);
				panel_2.add(temp);
				seatList[i-1]=temp;
			}

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
	
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.add(new myRow_3(6,"c","screen3"));
		jf.setVisible(true);
		jf.setSize(200, 100);
	}

	
}
