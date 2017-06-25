package test;
import java.util.Random;


public class test_GenerateNumber
{
 public static void main (String [] str)
 {
	 StringBuilder str1 =new StringBuilder();//定义变长字符串
	 Random	random=new Random();
	 //随机生成数字，并添加到字符串
	 for(int i=0;i<8;i++){
		 str1.append(random.nextInt(4)+1);
	 }
	 
	 //将字符串转换为数字并输出
	 int num=Integer.parseInt(str1.toString());
	 System.out.println(num);
 }
}