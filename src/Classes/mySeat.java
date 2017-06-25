package Classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class mySeat extends JButton {
	/**
	 * Seat is represented by JButton
	 */
	private static final long serialVersionUID = 5420164136992588079L;
	
	private boolean isAvailable; // this is used to indicate whether the sear is available
	
	private int numOfseat; // the seat's number 
	
	private String rowOfseat; // this is used for row number
	
	private String screenOfseat; // this is for screenOfseat
	
	public String getScreenOfseat() {
		return screenOfseat;
	}
	public void setScreenOfseat(String screenOfseat) {
		this.screenOfseat = screenOfseat;
	}
	public String getRowOfseat() {
		return rowOfseat;
	}
	public void setRowOfseat(String rowOfseat) {
		this.rowOfseat = rowOfseat;
	}
	public int getNumOfseat() {
		return numOfseat;
	}
	public void setNumOfseat(int numOfseat) {
		this.numOfseat = numOfseat;
	}


	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		if(!isAvailable)
		this.setBackground(Color.RED);
		else
		this.setBackground(Color.GREEN);
		
		this.isAvailable = isAvailable;
	}
	
	// ÐòºÅ £¬ÐÐºÅ£¬ÆÁÄ»ºÅ
	public mySeat(int numOfseat,String row_num,String screen_num) {
		this.isAvailable=true;
		this.setNumOfseat(numOfseat);
		this.setRowOfseat(row_num);
		this.setScreenOfseat(screen_num);
		this.setBackground(Color.GREEN);
		this.setText(String.valueOf(numOfseat));
		this.setSize(42, 25);
		this.setVisible(true);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof mySeat){
					mySeat bt = (mySeat)e.getSource();
					if(bt.getBackground()==Color.GREEN &&bt.isAvailable()){
						bt.setText("Y");
						bt.setBackground(Color.BLUE);
					}
					if(!bt.isAvailable())
					{	bt.setBackground(Color.RED);
						bt.setEnabled(false);//ÒÑ¾­¸¶¿îµÄ×´Ì¬
					}
				
				}
				
			}
		});
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() instanceof mySeat){
					mySeat bt = (mySeat)e.getSource();
					if(e.getClickCount()==2 && bt.isAvailable()){
						bt.setBackground(Color.GREEN);
						bt.setText(bt.getNumOfseat()+"");
					}
				}
			}
		});
	
	}
		
	public String seatInfo(){
		return "num: "+this.getNumOfseat()+" row: "+this.getRowOfseat()+" screen: "+this.getScreenOfseat();
	}

}
