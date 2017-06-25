package Classes;


import javax.swing.JButton;
import javax.swing.UIManager;

public class myScreen extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2399606733232399635L;
	private int screen_id;
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public myScreen() {
		setEnabled(false);
		this.setBackground(UIManager.getColor("Button.shadow"));
		this.setSize(400,20);
		this.setText("--------------------------------Screen--------------------------------");
	}
	
}
