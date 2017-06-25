package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.MyTimer;
import Classes.ScreenTable;
import Classes.Session;
import GUI.CheckAdministratorFrame;
import GUI.MovieFrame;
import GUI.PrintTicket;
import GUI.RefundTicket;
import util.csvReader_util;
import util.search_util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The main frame of user (or whole system), better to use windowsBuilder(or other Visual components) to see the content
 * @author lxt
 *
 */
public class MainFrameForUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel label_list[]; //use Jlabel to represent a film
	JTextArea textArea;// 
	JTextArea textArea_1; //   
	MyTimer timer; // timer 
	private csvReader_util csv_util = new csvReader_util();
	private search_util s_util= new search_util();
	private ArrayList<Movie> movie_list;  //read movie from files
	private ArrayList<ScreenTable> screen_list;//store the screen of the movie	
	private Map<Movie,ArrayList<Session>> movie_map;
	private ArrayList<Map<Movie,ArrayList<Session>>> movie_map_list;
	private ArrayList<Session> sessionList;  // core data structure
	private JPanel panel; //
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameForUser frame = new MainFrameForUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrameForUser() {
		loadFileIntoMemory(); // load related information
		this.setVisible(true);
		setBounds(100, 100, 752, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Print Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrintTicket(sessionList).setVisible(true);//launch the print the Ticket frame
			}
		});
		btnNewButton.setBounds(582, 547, 131, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("refund");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RefundTicket(sessionList).setVisible(true);; // launch the refund Ticket frame
			}
		});
		btnNewButton_1.setBounds(582, 590, 131, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // close the current frame
			}
		});
		btnQuit.setBounds(582, 631, 131, 33);
		contentPane.add(btnQuit);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 716, 313);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		label_list  = new JLabel[movie_list.size()];  // using JLabel to represent the movies
		AddFilmToPanel();  // add the film information to the panel
		
		//get time inoformation
		// using the scrollPanel to scroll the screen
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(92, 390, 634, 139);
		contentPane.add(scrollPane_1);

		
		textArea = new JTextArea("****************Move the mouse to the pic the get the information of each film****************");
		textArea.setAlignmentX((float) 0.5);
		//scrollPane_1.add(textArea);
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 344, 74, 35);
		contentPane.add(lblDescription);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 576, 393, 73);
		contentPane.add(scrollPane_2);
		
		 textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JLabel lblFilmSchedule = new JLabel("Film Schedule");
		lblFilmSchedule.setBounds(10, 547, 84, 33);
		contentPane.add(lblFilmSchedule);
		
		JLabel lblWecomeToOur = new JLabel("Wecome To Our Cinema ! ");
		lblWecomeToOur.setBounds(230, 10, 616, 15);
		contentPane.add(lblWecomeToOur);
		
		JLabel lblDoubleClickTo = new JLabel("Double Click To Select The Movie To Buy");
		lblDoubleClickTo.setBounds(211, 41, 565, 15);
		contentPane.add(lblDoubleClickTo);
		
		JLabel lblMoviemheMouseTo = new JLabel("Movie The Mouse To See The Information Of Movie");
		lblMoviemheMouseTo.setBounds(187, 27, 393, 15);
		contentPane.add(lblMoviemheMouseTo);
		
		JLabel lblDescription_1 = new JLabel("Description");
		lblDescription_1.setBounds(10, 406, 84, 15);
		contentPane.add(lblDescription_1);
		timer= new MyTimer(); //new a timer
		timer.setBounds(546, 10, 180, 15);
		contentPane.add(timer);
		
		JButton btnSystemAdminiter = new JButton("System Administrator");
		btnSystemAdminiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckAdministratorFrame(sessionList, movie_list); //start the Administor Frame
			}
		});
		btnSystemAdminiter.setBounds(413, 566, 159, 81);
		contentPane.add(btnSystemAdminiter);
		timer.start(); // start the timer to count the time
	}
	
	/**
	 * Load the Related files information into memory
	 */
	private void loadFileIntoMemory() {
		movie_list=csv_util.loadMovieFile("files/movies.csv");
		screen_list=csv_util.loadTimeTableFile("files/timeTable.csv");
		//System.out.println(screen_list.size());
		movie_map_list = new ArrayList<Map<Movie,ArrayList<Session>>>();
		for(Movie movie:movie_list){
			movie_map=s_util.getMovie_map(movie, screen_list);
			movie_map_list.add(movie_map);
		}
		sessionList =s_util.getTotalSession(movie_map_list);  // get the total session
		//System.out.println(sessionList.size());
		//System.out.println(sessionList.get(0).getMovie().getName());
		//System.out.println(movie_map_list.get(1).get(movie_list.get(1)).size());
		//movie_map=s_util.getMovie_map(movie_list.get(0), screen_list);
		//System.out.println(movie_map.get(movie_list.get(0)).get(4));
	}
	/**
	 * Set the timeTable of each film 
	 * @param sessionList
	 */
	private void SetText2(ArrayList<Session> sessionList){
		//textArea_1.setText();
		String text=sessionList.get(0).getMovie().getName()+"\n";  // movie name
		for(Session session : sessionList){
			// checkTime(); 提醒用户不能在过了相应的时间点后买票
			text+=session.getScreen_num()+": "+session.getDate()+"\n";
		}
		textArea_1.setText(text);
	}
	/**
	 * this function is used to Add the film to the Panel
	 * the idea is that using the JLabel to represent each film
	 */
	private void AddFilmToPanel(){
		int i=0;
		for(;i<movie_list.size();i++){
			int index = i;
			label_list[i] = new JLabel("");
			Movie temp = movie_list.get(i); //get the movie
			label_list[i].setIcon(new ImageIcon(temp.getPicPath())); // set the movie image
			label_list[i].addMouseListener(new MouseAdapter() {
				@Override
				/**
				 * this method listens to mouse's movement to detect that if choosing the film (Jlabel)
				 */
				public void mouseEntered(MouseEvent e) {
					textArea.setText(temp.getDescribtion());
					SetText2(movie_map_list.get(index).get(movie_list.get(index)));
				}
				/**
				 * this method listens to mouse's click movement to detect that whether the user 
			     * click the label twice. 
			     * if double click, then launch the movie frame to buy the ticket.
				 */
				@Override
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount()==2){
						new MovieFrame(movie_map_list.get(index).get(movie_list.get(index)), movie_list.get(index));
					}
				}
			});
			panel.add(label_list[i]); // add the label 
		}
	}
}
