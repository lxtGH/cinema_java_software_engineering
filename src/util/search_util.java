package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Classes.Movie;
import Classes.ScreenTable;
import Classes.Session;
import Classes.Ticket;
import GUI.BasicScreen;

public class search_util {

	/**
	 * get the movie map Through the movie
	 * @param movie
	 * @param list
	 * @return
	 */
	public Map<Movie,ArrayList<Session>> getMovie_map(Movie movie,ArrayList<ScreenTable> list){
		Map<Movie,ArrayList<Session>> movie_map=new HashMap<Movie,ArrayList<Session>>();
		ArrayList<Session>session_temp = new ArrayList<Session>();
		ArrayList<String> dateList;
		for(ScreenTable screenTable:list){
			String screenName=screenTable.getScreen_name();
			for(String movieName :screenTable.getMovie_Session().keySet()){ //get the movie_name set
				if(movieName.equals(movie.getName())){ //get the movie
					dateList=screenTable.getMovie_Session().get(movieName);
					for(String time:dateList){
						session_temp.add(new Session(movie, screenName, time));//add the Session
						movie_map.put(movie, session_temp); //put the session and movie into the map
					}
				}
			}
		}
		
		return movie_map;
	}
	/**
	 * get the session list 
	 * @param movie_map_list
	 * @return
	 */
	public ArrayList<Session> getTotalSession(ArrayList<Map<Movie,ArrayList<Session>>> movie_map_list){
		ArrayList<Session> sessionList = new ArrayList<Session>();
		ArrayList<Session> temp;
		for(Map map_tmp:movie_map_list){
			for(Object mv: map_tmp.keySet()){
				temp=(ArrayList<Session>)map_tmp.get((Movie)mv);
				sessionList.addAll(temp);
			}
		}
		return sessionList;
	}
	/**
	 * get the ticket list through the Session List
	 * @param sessionList
	 * @return
	 */
	public ArrayList<Ticket> getTiketSessionList(ArrayList<Session> sessionList){
		ArrayList<Ticket> tk_list = new ArrayList<Ticket>();	
		for(Session session:sessionList){
			BasicScreen sc = session.getSession_Screen();
			tk_list.addAll(sc.getTicket_list());
		}
		return tk_list;
	}
	
	/**
	 *find the ticket through the ID
	 * @param ID
	 * @param ticket_list
	 * @return
	 */
	public Ticket getTicketFromTk_list(String ID,ArrayList<Ticket> ticket_list){
		Ticket tmp = null; // null means that no found
		for(Ticket ticket:ticket_list){
			if(ID.equals(ticket.getTicket_ID())){
				tmp=ticket;
			}
		}
		return tmp;
	}
	
	public  Session getSessionFromSessionListByTicket(ArrayList<Session> sessionList,Ticket ticket){
		Session temp=null;
		for(Session session:sessionList){
			 ArrayList<Ticket> list_temp=session.getSession_Screen().getTicket_list();
			 for(Ticket ticket_tmp :list_temp){
				 if(ticket.getTicket_ID().equals(ticket_tmp.getTicket_ID())){
					 temp  = session;
					 break;
				 }
			 }
		}
		return temp;
	}
	
	public static double countTheSaleByFilm(String filmName,ArrayList<Ticket> ticket_list){
		double count=0.0;
		
		for(Ticket ticket:ticket_list){
			if(ticket.getMovieName().equals(filmName))
			{
				count += ticket.getPrice();
			}
		}
		
		return count;
	}
	
}
