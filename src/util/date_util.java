package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * date_util class that provide method for date compare
 * @author lxt
 *
 */
public class date_util {
	/**
	 * this method tries to get the avaliable time 
	 * @param list 
	 * @return
	 */
	public static ArrayList<String> getAvaliableTime(ArrayList<String> list){
		
		ArrayList<String> avaiList = new ArrayList<String>();
		Date date =new Date();
		long times = date.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String dateString = formatter.format(times);
		String dateArray[]=dateString.split(":");
		int current_min = Integer.parseInt(dateArray[1]);
		int current_hour = Integer.parseInt(dateArray[0]);
		System.out.println(current_hour+":"+current_min);
		//String time =""+ current_hour +"-"+current_min;
		for(String temp:list){
			String []time_temp = temp.split(":");
			int hour=Integer.parseInt(time_temp[0]); 
			int min =Integer.parseInt(time_temp[1]);
			if(hour<current_hour){ //compare the hours
				continue;
			}else if(hour==current_hour&&min<=current_min){ //compare the hours and minutes
				continue;
			}else{
				// if the time in timetable is available  
				avaiList.add(temp);
			}
		}
		return avaiList;
	}
}
