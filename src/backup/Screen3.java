package backup;


import GUI.BasicScreen;

public class Screen3 extends BasicScreen {
	myRow_2 row_D;
	public myRow_2 getRow_D() {
		return row_D;
	}

	public void setRow_D(myRow_2 row_D) {
		this.row_D = row_D;
	}

	public myRow_3 getRow_C() {
		return row_C;
	}

	public void setRow_C(myRow_3 row_C) {
		this.row_C = row_C;
	}

	public myRow_3 getRow_B() {
		return row_B;
	}

	public void setRow_B(myRow_3 row_B) {
		this.row_B = row_B;
	}

	public myRow_3 getRow_A() {
		return row_A;
	}

	public void setRow_A(myRow_3 row_A) {
		this.row_A = row_A;
	}

	myRow_3 row_C;
	myRow_3 row_B;
	myRow_3 row_A;
	private String screen_name;
	public Screen3() {
		row_D = new myRow_2(8, "D",screen_name);
		row_C = new myRow_3(6, "C",screen_name);
		row_B = new myRow_3(6, "B",screen_name);
		row_A = new myRow_3(6, "A",screen_name);

		row_D.setLocation(115, 28);
		row_D.setSize(454, 40);
		getContentPane().add(row_D);
		row_C.setLocation(113, 78);
		row_C.setSize(456, 40);
		getContentPane().add(row_C);

		row_B.setBounds(115, 128, 456, 40);
		getContentPane().add(row_B);

		row_A.setBounds(113, 178, 456, 40);
		getContentPane().add(row_A);
	}

	public static void main(String[] args) {
		Screen3 sc3 = new Screen3();
		sc3.setVisible(true);
	}
}
