package Classes;

import java.util.Date;
import java.util.Random;
/**
 * Ticket Class for storing the information of the ticket
 * @author lxt
 *
 */
public class Ticket {
	
	private String ticket_date;
	private mySeat seat;
	private String movieName;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	private double price;
	private boolean isPrinted=false;
	private String ticket_ID;
	public String getTicket_ID() {
		return ticket_ID;
	}
	public void setTicket_ID(String ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

	private String type; //what kind of ticket is 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Ticket(String movieName,String ticket_date,mySeat seat,String type){
		this.ticket_ID=genarateID();
		this.movieName=movieName;
		this.ticket_date=ticket_date;
		this.seat=seat;
		this.type=type;
	}
	public String genarateID(){
		 StringBuilder str1 =new StringBuilder();//定义变长字符串
		 Random	random=new Random();
		 //随机生成数字，并添加到字符串
		 for(int i=0;i<8;i++){
			 str1.append(random.nextInt(4)+1);
		 }
		 return str1.toString();
	}
	public boolean isPrinted() {
		return isPrinted;
	}
	public void setPrinted(boolean isPrinted) {
		this.isPrinted = isPrinted;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}
	public mySeat getSeat() {
		return seat;
	}
	public void setSeat(mySeat seat) {
		this.seat = seat;
	}
	
	public String ticketInfor(){
		return this.movieName+" ID:-"+this.ticket_ID+"- Date:"+this.ticket_date+" \nScreen: "+this.getSeat().getScreenOfseat()
				+" \nRow:"+this.getSeat().getRowOfseat()
				+" num:"+this.getSeat().getNumOfseat()
				+ "\nType:"+this.getType();
	}

}
