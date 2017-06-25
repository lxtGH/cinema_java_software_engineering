package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Movie;
import Classes.Session;
import util.date_util;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * this class is used to show basic movie information of each movie.
 * @author lxt
 *
 */
public class MovieFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox_2,comboBox_1;
	JComboBox comboBox_3;
	JButton btnBack;
	JLabel pic,duration;JLabel notation;
	private MovieFrame movieFrame;
	/**
	 * Create the frame.
	 */
	public MovieFrame(ArrayList<Session> sessionList,Movie movie) {
		movieFrame=this;
		this.setTitle(movie.getName());
		this.setVisible(true);
		setBounds(100, 100, 449, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChooseSeat = new JButton("Choose Seat");
		btnChooseSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox_2.getSelectedItem().toString().equals("None")){
						JOptionPane.showMessageDialog(null, "No sessions left, please select other screens ");
						return;
					}
					Session session = findSession(comboBox_1.getSelectedItem().toString(),
							comboBox_2.getSelectedItem().toString(),sessionList);//first find the session
					//session.setTicket_type(comboBox_3.getSelectedItem().toString());
					String type =comboBox_3.getSelectedItem().toString();

					BasicScreen screen=session.getSession_Screen(); //find the screen of the session
		
					screen.setCurrent_Ticket_Type(comboBox_3.getSelectedItem().toString());
					screen.setCurrent_Ticket_Price(session.getMovie_price());
					screen.setCurrent_Session(session);
					screen.setVisible(true);// launch the screen
			}
		});
		btnChooseSeat.setBounds(238, 228, 117, 23);
		contentPane.add(btnChooseSeat);
		
		 btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(365, 228, 69, 23);
		contentPane.add(btnBack);
		 
		  comboBox_1 = new JComboBox();
		  comboBox_1.setBounds(344, 49, 80, 21);
		  comboBox_2 = new JComboBox();	 
		  comboBox_2.setBounds(344, 105, 80, 21);
		  comboBox_1.addItemListener(new ItemListener() {
		  	@Override
		  	public void itemStateChanged(ItemEvent e) {
		  		setCombox2(e.getItem().toString(),sessionList);
		  	}
		  });
		  contentPane.add(comboBox_1);
		 contentPane.add(comboBox_2);
		
		 ArrayList<String> list= getScreens(sessionList);
		 Set<String> set = new HashSet<String>(list);
		 for(String s:set)
			 comboBox_1.addItem(s);
		
		JLabel lblNewLabel = new JLabel("Choose Screen");
		lblNewLabel.setBounds(344, 24, 80, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Time");
		lblNewLabel_1.setBounds(344, 80, 80, 15);
		contentPane.add(lblNewLabel_1);
		
		 pic = new JLabel(new ImageIcon(movie.getPicPath()));
		pic.setBounds(22, 3, 190, 260);
		contentPane.add(pic);
		
		JLabel lblDuration = new JLabel("duration");
		lblDuration.setBounds(222, 24, 69, 15);
		contentPane.add(lblDuration);
		
		 duration = new JLabel(movie.getDuration());
		duration.setBounds(222, 55, 54, 15);
		contentPane.add(duration);
		
		notation = new JLabel("%50 discount");
		notation.setBounds(344, 164, 90, 15);
		contentPane.add(notation);
		
		JLabel lblChoseTicktype = new JLabel("Chose Ticket Type");
		lblChoseTicktype.setBounds(234, 136, 131, 15);
		contentPane.add(lblChoseTicktype);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(238, 161, 80, 21);
		contentPane.add(comboBox_3);
		comboBox_3.addItem("Child");
		comboBox_3.addItem("Adult");
		comboBox_3.addItem("Senior");
		comboBox_3.addItem("Student");
		comboBox_3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().toString().equals("Child")){
					notation.setText("%50 discount");
					
				}
				else if (e.getItem().toString().equals("Adult")){
					notation.setText("No discount");
					
				}else if(e.getItem().toString().equals("Senior")){
					notation.setText("%20 discount");
					
				}else if(e.getItem().toString().equals("Student")){
					notation.setText("%15 discount");
					
				}
			}
		});

	}
	
	
	private ArrayList<String> getScreens(ArrayList<Session> sessionList){
		ArrayList<String> list = new ArrayList<String>();
		for(Session session:sessionList){
			list.add(session.getScreen_num());
		}
		return list;
	}
	
	private void setCombox2(String screen,ArrayList<Session> sessionList){
		comboBox_2.removeAllItems();
		ArrayList<String> list = new ArrayList<String>();
		for(Session session:sessionList){
			if(screen.equals(session.getScreen_num())){
				list.add(session.getDate());
			}
		}
		list=date_util.getAvaliableTime(list);
		if(list.size()==0){
			comboBox_2.addItem("None");
			return;
		}
		for(String s:list)
			comboBox_2.addItem(s);
	}
	
	private Session findSession(String screen,String date,ArrayList<Session> sessionList){
		for(Session session:sessionList){
			if(screen.equals(session.getScreen_num())&& date.equals(session.getDate())){
				return session;
			}
		}
		return null;
	}
	
	
}
