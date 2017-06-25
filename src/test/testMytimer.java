package test;

import javax.swing.JFrame;

import Classes.MyTimer;

public class testMytimer extends JFrame {
		public testMytimer(){
			this.setVisible(true);
			 MyTimer timer = new MyTimer();
			 timer.start();
			 this.add(timer);
		}
		
		public static void main(String[] args) {
			testMytimer t=	new testMytimer();
			t.setSize(250, 200);
			t.setLocationRelativeTo(null);
			t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
}
