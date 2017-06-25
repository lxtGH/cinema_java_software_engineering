package test;

import Classes.Movie;
import Classes.Session;
import GUI.Screen1;

public class testSession {
	public static void main(String[] args) {
		Session session = new Session(new Movie(),"screen1","10:10");
		Screen1 sc1 = (Screen1)session.getSession_Screen();
		session.getSession_Screen().setVisible(true);
	}
}
