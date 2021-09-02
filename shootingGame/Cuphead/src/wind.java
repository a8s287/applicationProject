import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*; 
import java.util.Random;
//魔王
public class wind {
	ImageIcon wind_pic=new ImageIcon("C:\\java\\Cuphead\\img\\wind.png" );
	JLabel wind_label=new JLabel(wind_pic);
	AePlayWave apw=new AePlayWave("C:\\java\\Cuphead\\src\\music\\opening.wav"); 
	int[] y_position =  {75,100,150,200,250,300,350,400,450,500,550};
	
	public void set_x_y() {//設定x在甚麼位置
		Random ran = new Random();
		int rand = ran.nextInt(10);
		wind_label.setBounds(750,y_position[rand],wind_pic.getIconWidth(),wind_pic.getIconHeight());
		
	}
	public void set_x_y(int x) {//設定x在甚麼位置
		Random ran = new Random();
		int rand = ran.nextInt(10);
		wind_label.setBounds(x,y_position[rand],wind_pic.getIconWidth(),wind_pic.getIconHeight());
		
	}
	public void put_pic(JFrame frm)//把WIND圖片放上去
	    {
		 	//wind.setBounds(,20,wind_pic.getIconWidth(),wind_pic.getIconHeight());
			
		 	frm.add(wind_label);
			
		 	frm.setSize(1010,620);
		 	
	    }
	 public void wind_position() {
		 wind_label.setBounds(100,50,wind_pic.getIconWidth(),wind_pic.getIconHeight());
			
	 }
	 public int wind_x() {
		 return wind_label.getX();
	 }
	 public int wind_y() {
		 return wind_label.getY();
	 }
	 public void wind_move(JFrame frm) {
		 Random ran = new Random();
		int rand = ran.nextInt(10);
		 if(wind_label.getX() + 80 > frm.getWidth())wind_label.setBounds(-50,y_position[rand],wind_pic.getIconWidth(),wind_pic.getIconHeight());
		 else wind_label.setBounds(wind_label.getX()+5,wind_label.getY(),wind_pic.getIconWidth(),wind_pic.getIconHeight());
		 
	 }
	 public int wind_width() {
		 return wind_label.getWidth();
	 }
	 public void win() {
		 wind_label.setVisible(false);
	 }
}
