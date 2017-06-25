package Classes;

public class Movie {
	private int id;
	private String name;
	private String duration;
	private String describtion;
	private String picPath;
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Movie(int id,String name,String duration,String describtion,String picPath,Double price) {
		this.id=id;
		this.name=name;
		this.duration=duration;
		this.describtion=describtion;
		this.picPath=picPath;
		this.price=price;
	}
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDescribtion() {
		String content = "";
		String temp[]=describtion.split("/");
		for (int i=0;i<temp.length;i++)
		{
			content = content +temp[i] +"\n";
		}
		return content;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
