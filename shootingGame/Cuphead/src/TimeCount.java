import java.util.Date;
import java.text.*;
public class TimeCount extends Thread{
	Date date = new Date();
	Date date2 = new Date();
	long start_time;
	long now_time;

	public TimeCount() {
		start_time = System.currentTimeMillis();
	}
	public long get_mmmsecond() {//1/1000¬í
		
		now_time = System.currentTimeMillis();
		long diff =  now_time - start_time;
		
		//System.out.println(diff/1000);
		
		return diff;
	}
	public long get_msecond() {//1/10¬í
		
		now_time = System.currentTimeMillis();
		long diff =  now_time - start_time;
		
		//System.out.println(diff/1000);
		
		return diff/100;
	}
	public long get_second() {//1 second
		
		now_time = System.currentTimeMillis();
		long diff =  now_time - start_time;
		
		//System.out.println(diff/1000);
		
		return diff/2000;
	}
	public long get_minute() {
		now_time = System.currentTimeMillis();
		long diff =  now_time - start_time;
		
		//System.out.println(diff/1000/60);
		diff = diff/1000/60;
		return diff;
	}
	
}
