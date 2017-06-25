package Classes;

import java.util.Date;

import GUI.BasicScreen;
import GUI.Screen1;
import GUI.Screen2;
import GUI.Screen3;

public class Session {

	private String ticket_type;  //
	private Double movie_price;  // this is for changing demand of movies' price
	
	
	public Double getMovie_price() {
		return movie_price;
	}

	public void setMovie_price(Double movie_price) {
		this.movie_price = movie_price;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	private String date;
	private Movie movie;
	private String screen_num;
	
	private BasicScreen session_Screen;


	public BasicScreen getSession_Screen() {
		return session_Screen;
	}

	public void setSession_Screen(BasicScreen session_Screen) {
		this.session_Screen = session_Screen;
	}

	
	public Session(Movie movie,String screen_num,String date){
		this.movie=movie;
		this.screen_num=screen_num;
		this.date=date;
		this.setMovie_price(this.movie.getPrice()); //default price
		if(screen_num.equals("screen1"))
		this.session_Screen=new Screen1();
		else if(screen_num.equals("screen2"))
			this.session_Screen=new Screen2();
		else if(screen_num.equals("screen3"))
			this.session_Screen= new Screen3();
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getScreen_num() {
		return screen_num;
	}
	public void setScreen_num(String screen_num) {
		this.screen_num = screen_num;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  screen_num +" Movie: "+movie.getName()+" date: "+getDate();
	}
}
