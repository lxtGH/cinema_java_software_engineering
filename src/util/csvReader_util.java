package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Classes.Movie;
import Classes.ScreenTable;
import Classes.Ticket;

public class csvReader_util {
	private ArrayList<Movie> movie_list=null;
	private ArrayList<ScreenTable> screen_list=null;
	
	/**
	 * load the movie file into the memory in form of arrayList
	 * @param fileName  
	 * @return arrayList<movie>
	 */
	public ArrayList<Movie> loadMovieFile(String fileName){
		movie_list = new ArrayList<Movie>();
		BufferedReader reader;
		try {
			reader= new BufferedReader(new FileReader(fileName));
	        String line = null;  
	        while((line=reader.readLine())!=null){
	        	String item[] = line.split(";");
	        	//System.err.println(item[1]);
	        	Movie temp = new Movie(Integer.parseInt(item[0]),item[1],item[2],item[3],item[4],Double.parseDouble(item[5]));
	        	movie_list.add(temp);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie_list;
	}
	
	/**
	 * load the timeTableFile into the memory in form of screen Table 
	 * @param fileName
	 * @return
	 */
	public ArrayList<ScreenTable> loadTimeTableFile(String fileName){
		screen_list = new ArrayList<ScreenTable>();
		BufferedReader reader;
		try {
			reader= new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line=reader.readLine())!=null){
				String item[] = line.split(";");
				String screenName = item[0];
				Map<String, ArrayList<String>> movie_Session_temp = new HashMap<String,ArrayList<String>>();
				for(int i=1;i<item.length;i++){
					ArrayList<String> list_temp = new ArrayList<String>();
					String item2[]=item[i].split(",");
					for(int j=1;j<item2.length;j++){
						list_temp.add(item2[j]);
					}
					movie_Session_temp.put(item2[0], list_temp);
				}
				ScreenTable temp = new ScreenTable(screenName, movie_Session_temp);
				screen_list.add(temp);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screen_list;
		
	}
	
	public static void generateReport(ArrayList<Ticket> ticket_list,ArrayList<Movie> movie_list){
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("output/report.txt"));
			int numOfTicket = ticket_list.size();
			bufferedWriter.write("number of Ticket is :"+numOfTicket);
			bufferedWriter.newLine();
			bufferedWriter.write("Total Sale Amount:"+ticket_util.calculateTotalPrice(ticket_list));
			bufferedWriter.newLine();
			double movie_amount;
			for(Movie movie:movie_list){
				movie_amount= search_util.countTheSaleByFilm(movie.getName(), ticket_list);
				bufferedWriter.write("Name:"+movie.getName()+" Amount:"+movie_amount);
				bufferedWriter.newLine();
			}
			int num_Adult=ticket_util.countNumberOfTicket("Adult", ticket_list);
			bufferedWriter.write("Type: Adult"+" Number:"+num_Adult);
			bufferedWriter.newLine();
			int num_Student = ticket_util.countNumberOfTicket("Student", ticket_list);
			bufferedWriter.write("Type: Student"+" Number:"+num_Student);
			bufferedWriter.newLine();
			int num_Children = ticket_util.countNumberOfTicket("Children", ticket_list);
			bufferedWriter.write("Type: Children"+" Number:"+num_Children);
			bufferedWriter.newLine();
			int num_Senior = ticket_util.countNumberOfTicket("Senior", ticket_list);
			bufferedWriter.write("Type: Senior"+" Number:"+num_Senior);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
}
