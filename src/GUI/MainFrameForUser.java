package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.MyTimer;
import Classes.ScreenTable;
import Classes.Session;
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

public class MainFrameForUser extends JFrame {

	private JPanel contentPane;
	JLabel label_1,label_2,label_3,label_4,label_5;
	JTextArea textArea;
	JTextArea textArea_1;
	MyTimer timer ; 
	private csvReader_util csv_util = new csvReader_util();
	private search_util s_util= new search_util();
	private ArrayList<Movie> movie_list;
	private ArrayList<ScreenTable> screen_list;
	private Map<Movie,ArrayList<Session>> movie_map;
	private ArrayList<Map<Movie,ArrayList<Session>>> movie_map_list;
	private ArrayList<Session> sessionList;

	
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
		loadFileIntoMemory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Print Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrintTicket(sessionList).setVisible(true);
			}
		});
		btnNewButton.setBounds(582, 547, 131, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("refund");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RefundTicket(sessionList).setVisible(true);;
			}
		});
		btnNewButton_1.setBounds(582, 590, 131, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnQuit = new JButton("quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnQuit.setBounds(582, 631, 131, 33);
		contentPane.add(btnQuit);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 716, 313);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("pic/1.png"));
		label_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Kong: Skull Island is a 2017 American monster film directed by Jordan Vogt-Roberts and "
						+ "\n written by Dan Gilroy, Max Borenstein and Derek Connolly, from a story by John Gatins. The film is a reboot of the King Kong franchise "
						+ "\n and serves as the second film in Legendary's MonsterVerse. It stars an ensemble cast consisting of Tom Hiddleston, Samuel L. Jackson, John Goodman, "
						+ "\n Brie Larson, Jing Tian, Toby Kebbell, John Ortiz, Corey Hawkins, Jason Mitchell,Shea Whigham, Thomas Mann, Terry Notary and John C. Reilly."
						+ "\n The film follows a team of scientists and Vietnam War soldiers who travel to an uncharted island in the Pacific "
						+ "\n and encounter terrifying creatures and the mighty Kong.");
				textArea_1.setText("Screen 1:\n"+"10:00    12:30\n"+"Screen 3:\n"+"10:30   13:00");
				SetText2(movie_map_list.get(0).get(movie_list.get(0)));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					new MovieFrame(movie_map_list.get(0).get(movie_list.get(0)), movie_list.get(0));
				}
			}
			
		});
		panel.add(label_1);
		
		 label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("pic/2.png"));
		label_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Variants significantly reduced, X war has been dissolved. \n "
						+ "Physically and mentally tired of the twilight of the dragon root loopholes gradually disappear, drink all day and rely on the driver to live,\n"
						+ "he was in the Mexican border to take care of suffering from tortured Charles Xavier. Suddenly one day, a strange woman asked Rogen to\n "
						+ "carry a girl named Laura Ginny to the Canadian border, and Rogan refused, but Charles Xavier was waiting for the girl to appear.\n "
						+ "Ginny has a super combat effectiveness, and in many ways much like Wolverine. She was tracked by a strong company behind the scenes, \n"
						+ "because her DNA has a connection to the secret of Rogan, thus an endless hunt to start.");
				SetText2(movie_map_list.get(1).get(movie_list.get(1)));
			}
			
			@Override
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					new MovieFrame(movie_map_list.get(1).get(movie_list.get(1)), movie_list.get(1));
				}
			}
		

		});
		panel.add(label_2);
		
		 label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("pic/3.png"));
		label_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Beauty and the Beast is a 1991 American animated musical \n"
						+ "romantic fantasy film produced by Walt Disney Feature Animation and released by Walt Disney Pictures. Beauty and the Beast focuses on the relationship"
						+ "\n between the Beast (voice of Robby Benson), a prince who is magically transformed into a monster as punishment for his arrogance, and "
						+ "\n Belle (voice of Paige O'Hara), a beautiful young woman whom he imprisons in his castle. To become a prince again, Beast must "
						+ "\n win her love in return. Otherwise, he will remain a monster forever. The film also features the voices of Richard White, "
						+ "\n Jerry Orbach, David Ogden Stiers, and Angela Lansbury.");
				SetText2(movie_map_list.get(2).get(movie_list.get(2)));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					new MovieFrame(movie_map_list.get(2).get(movie_list.get(2)), movie_list.get(2));
				}
			}
			
		});
		panel.add(label_3);
		
		 label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("pic/4.png"));
		panel.add(label_4);
		label_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("Moonlight is a 2016 American coming-of-age drama film written and "
						+ "\n directed by Barry Jenkins and based on Tarell Alvin McCraney's unpublished semi-autobiographical play In Moonlight Black Boys Look Blue. "
						+ "\n It stars Trevante Rhodes, André Holland, Janelle Monáe, Ashton Sanders, Naomie Harris, and Mahershala Ali. The film presents "
						+ "\n three stages in the life of the main character. It explores the difficulties he faces with his own sexuality "
						+ "\n and identity, including the physical and emotional abuse he receives as a result of it.");
				SetText2(movie_map_list.get(3).get(movie_list.get(3)));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					new MovieFrame(movie_map_list.get(3).get(movie_list.get(3)), movie_list.get(3));
				}
			}

		});
		
		 label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("pic/5.png"));
		label_5.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setText("La La Land is a 2016 American musical romantic drama film written "
						+ "\n and directed by Damien Chazelle, and starring Ryan Gosling and Emma Stone as a musician and an aspiring actress "
						+ "\n who meet and fall in love in Los Angeles. The film's title refers both to the city of Los Angeles and to the idiom "
						+ "\n for being out of touch with reality.");
				SetText2(movie_map_list.get(4).get(movie_list.get(4)));
			}
			@Override
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					new MovieFrame(movie_map_list.get(4).get(movie_list.get(4)), movie_list.get(4));
				}
			}

		});
		panel.add(label_5);
		
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
		timer= new MyTimer();
		timer.setBounds(546, 10, 180, 15);
		contentPane.add(timer);
		timer.start();
		
		
	}

	private void loadFileIntoMemory() {
		movie_list=csv_util.loadMovieFile("files/movies.csv");
		screen_list=csv_util.loadTimeTableFile("files/timeTable.csv");
		
		movie_map_list = new ArrayList<Map<Movie,ArrayList<Session>>>();
		for(Movie movie:movie_list){
			movie_map=s_util.getMovie_map(movie, screen_list);
			movie_map_list.add(movie_map);
		}
		sessionList =s_util.getTotalSession(movie_map_list);  // get the total session
		
		
		//System.out.println(sessionList.get(0).getMovie().getName());
		//System.out.println(movie_map_list.get(1).get(movie_list.get(1)).size());
		//movie_map=s_util.getMovie_map(movie_list.get(0), screen_list);
		//System.out.println(movie_map.get(movie_list.get(0)).get(4));
	}
	
	private void SetText2(ArrayList<Session> sessionList){
		//textArea_1.setText();
		String text=sessionList.get(0).getMovie().getName()+"\n";  // movie name
		for(Session session : sessionList){
			// checkTime(); 提醒用户不能在过了相应的时间点后买票
			text+=session.getScreen_num()+": "+session.getDate()+"\n";
		}
		textArea_1.setText(text);
	}
}
