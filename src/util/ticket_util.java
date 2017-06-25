package util;

import java.io.*;
import java.util.ArrayList;

import Classes.Movie;
import Classes.Session;
import Classes.Ticket;
import Classes.mySeat;

public class ticket_util {

	public Ticket generateTicket(Movie movie,mySeat seat){
		return null;
	}
	public static Ticket generateTicket(Session session,mySeat seat,String ticketType){
		String movieName = session.getMovie().getName();
		String date= session.getDate();
		Ticket tk = new Ticket(movieName, date, seat,ticketType);
		return tk;
	}
	public void printTicket(Ticket ticket){
		String id = ticket.getTicket_ID();
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter("output/"+id+".txt"));
			writer.write("ticket ID: "+ticket.getTicket_ID());
			writer.newLine();
			writer.write("Type: "+ticket.getType());
			writer.newLine();
			writer.write("Movie: "+ticket.getMovieName());
			writer.newLine();
			writer.write("Date: "+ticket.getTicket_date());
			writer.newLine();
			writer.write("Screen: "+ticket.getSeat().getScreenOfseat());
			writer.newLine();
			writer.write("Row: "+ticket.getSeat().getRowOfseat()+" Number: "+ticket.getSeat().getNumOfseat());
			writer.flush();
			writer.close();//使用缓冲区中的方法，将数据刷新到目的地文件中去。
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static double calculatePrice(Double price,String ticketType,int num){
		if(ticketType.equals("Child")){
			return price * num * 0.5;
		}
		else if(ticketType.equals("Senior")){
			return price * num * 0.8;
		}
		else if(ticketType.equals("Student")){
			return price * num * 0.85;
		}
		else{
			return price * num ;
		}
	}
	public static double calculateTicketPrice(Double price,String ticketType){
		if(ticketType.equals("Child")){
			return price  * 0.5;
		}
		else if(ticketType.equals("Senior")){
			return price  * 0.8;
		}
		else if(ticketType.equals("Student")){
			return price * 0.85;
		}
		else{
			return price;
		}
	}
	public static double calculateTicketPriceByType(String type,ArrayList<Ticket> ticket_list){
		double amount = 0.0;
		for(Ticket ticket :ticket_list){
			if(ticket.getType().equals(type)){
				amount+=ticket.getPrice();
			}
		}
		
		return amount;
	}
	public static double calculateTotalPrice(ArrayList<Ticket> ticket_list){
		double amount = 0.0;
		for(Ticket ticket:ticket_list){
			amount +=ticket.getPrice();
		}
		return amount;
	}
	public static int countNumberOfTicket(String type,ArrayList<Ticket> ticket_list){
		int num =0;
		for(Ticket ticket :ticket_list){
			if(ticket.getType().equals(type)){
				num++;
			}
		}
		return num;
	}
	
}
