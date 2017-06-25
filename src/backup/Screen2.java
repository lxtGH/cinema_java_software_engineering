package backup;


import GUI.BasicScreen;

public class Screen2 extends BasicScreen {
	private String screen_name="Screen2";
	private myRow_1 row_A,row_B,row_C,row_D;
	
	public myRow_1 getRow_A() {
		return row_A;
	}


	public void setRow_A(myRow_1 row_A) {
		this.row_A = row_A;
	}


	public myRow_1 getRow_B() {
		return row_B;
	}


	public void setRow_B(myRow_1 row_B) {
		this.row_B = row_B;
	}


	public myRow_1 getRow_C() {
		return row_C;
	}


	public void setRow_C(myRow_1 row_C) {
		this.row_C = row_C;
	}


	public myRow_1 getRow_D() {
		return row_D;
	}


	public void setRow_D(myRow_1 row_D) {
		this.row_D = row_D;
	}


	public Screen2() {
		 row_A = new myRow_1(6, "A",screen_name);
		row_A.setSize(494, 43);
		row_A.setLocation(78, 180);
		getContentPane().add(row_A);
		
		 row_B = new myRow_1(6, "B",screen_name);
		row_B.setBounds(78, 125, 494, 43);
		getContentPane().add(row_B);
		
		 row_C = new myRow_1(6, "C",screen_name);
		row_C.setBounds(78, 72, 494, 43);
		getContentPane().add(row_C);
		
		 row_D = new myRow_1(8, "D",screen_name);
		row_D.setBounds(78, 19, 494, 43);
		getContentPane().add(row_D);
	}
	
	
	public static void main(String[] args) {
		Screen2 sc2= new Screen2();
		sc2.setVisible(true);
		
	}
}
