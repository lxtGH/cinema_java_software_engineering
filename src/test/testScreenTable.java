package test;

import java.util.ArrayList;

import Classes.ScreenTable;
import util.csvReader_util;

public class testScreenTable {
	public static void main(String[] args) {
		csvReader_util temp = new csvReader_util();
		ArrayList<ScreenTable> screen_list;
		screen_list=temp.loadTimeTableFile("files/timeTable.csv");
		System.out.println(screen_list.get(0).getMovie_Session().get("BEAUTY AND THE BEAST").get(0));
	}
}
