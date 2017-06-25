package Classes;

import java.util.ArrayList;
import java.util.Map;

public class ScreenTable {
	
	private String screen_name;
	private Map<String, ArrayList<String>> movie_Session;
	
	public ScreenTable() {
		// TODO Auto-generated constructor stub
	}
	public ScreenTable(String screen_name,Map<String, ArrayList<String>> movie_Session){
		this.screen_name=screen_name;
		this.movie_Session=movie_Session;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public Map<String, ArrayList<String>> getMovie_Session() {
		return movie_Session;
	}
	public void setMovie_Session(Map<String, ArrayList<String>> movie_Session) {
		this.movie_Session = movie_Session;
	}
}
