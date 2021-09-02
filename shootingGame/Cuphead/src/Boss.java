import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*; 
//魔王
public class Boss {
	static ImageIcon boss_pic=new ImageIcon("C:\\java\\Cuphead\\img\\boss.png" );
	static ImageIcon boss_hurt=new ImageIcon("C:\\java\\Cuphead\\img\\boss_hurt.png" );
	static JLabel boss=new JLabel(boss_pic);
	AePlayWave apw=new AePlayWave("C:\\java\\Cuphead\\src\\music\\opening.wav"); 
	public static int blood = 1000;
	static int boss_direct = 0;
	 public void put_pic(JFrame frm)//把BOSS圖片放上去
	    {
		 	boss.setBounds(800,20,boss_pic.getIconWidth(),boss_pic.getIconHeight());
			
		 	//System.out.println(boss.getX()+" "+boss.getY()+" "+boss.getWidth()+" "+boss.getHeight());
		 	
		 	frm.add(boss);
		 	frm.setSize(1010,620);
		 	
	    }
	public void boss_vibrate() {
		apw.start(); 
		for(int i = 0 ; i < 10 ; i++) {
			boss.setLocation(boss.getX(), boss.getY()+10);	
			try{Thread.sleep(100);}catch(Exception e){}
			boss.setLocation(boss.getX(), boss.getY()-10);	
			try{Thread.sleep(100);}catch(Exception e){}
		}
	}
	public int boss_getX() {
		return boss.getX();
	}
	public int boss_getY() {
		return boss.getY();
	}
	public static void boss_hurt() {
		blood-=1;
		//System.out.println(blood);
		boss.setIcon(boss_hurt);
	}
	public static void boss_hurt_cover() {
		boss.setIcon(boss_pic);
	}
	public static void boss_move() {
		if(boss.getY() > 150) boss_direct = 1;
		if(boss.getY() < -150)boss_direct = 0;
		
		if(boss_direct == 0)boss.setLocation(boss.getX(), boss.getY()+10);
		else boss.setLocation(boss.getX(), boss.getY()-10);	
	}
	public void win() {
		boss.setVisible(false);
	}
	
}
