import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;//主要畫面
public class Test{
	static JFrame frm  = new JFrame();
	static JPanel panel = new JPanel();
	static Boss boss = new Boss();
	static bg b = new bg();
	static TimeCount timer = new TimeCount();
	static boolean shoot_keep = false;
	static wind w1 = new wind();
    static wind w2 = new wind();
    static wind w3 = new wind();
    static wind w4 = new wind();
    static wind w5 = new wind();
    static wind w6 = new wind();
    static wind w7 = new wind();
    //static int boss_move_time = 1;
    static cuphead1 lead = new cuphead1();
    static long time_change2 = timer.get_second();
    static bullet[] b_array = new bullet[1000];
    static int bullet_count = 0;
    static int bullet_count_start = 0;
    static ghost g_array[] = new ghost[100000];
    static int g_count = 0;
    static int g_time = 0;
    static int mu_time = 0;
    static AePlayWave apw1;
	
    //static bullet a = new bullet(frm,lead);
	public static void main(String args[]) {
		frm.addKeyListener(new KeyLis());
		
		
		
		setFrame sF = new setFrame();
		sF.set_Frame(frm);
		frm.setResizable(false);
		
		
		try{Thread.sleep(10);}catch(Exception e){}
		boss.put_pic(frm);
		try{Thread.sleep(10);}catch(Exception e){}
		w1.set_x_y(80);
    	w1.put_pic(frm);
    	w2.set_x_y(230);
    	w2.put_pic(frm);
    	w3.set_x_y(380);
    	w3.put_pic(frm);
    	w4.set_x_y(530);
    	w4.put_pic(frm);
    	w5.set_x_y(680);
    	w5.put_pic(frm);
    	w6.set_x_y(830);
    	w6.put_pic(frm);
    	w7.set_x_y(0);
    	w7.put_pic(frm);
    	lead.put_pic(frm,w1.wind_x(),w1.wind_y()-50);
		b.put_bg(frm);
		try{Thread.sleep(10);}catch(Exception e){}
		boss.boss_vibrate();
		
		long time_change = timer.get_msecond();//雲的時間序
		
		while(lead.getdeath() > 0 && Boss.blood > 0) {
			//try{Thread.sleep(100);}catch(Exception e){}
			/*if(time_change2 != timer.get_second()) { 
				time_change2 = timer.get_second();
				
			}*/
			if(time_change != timer.get_msecond()) { 
				time_change = timer.get_msecond();
				if(mu_time == 0) {
					apw1 =new AePlayWave("C:\\java\\Cuphead\\src\\music\\song.wav"); 
					//apw1.stop();
					apw1.start();
				}
				if(mu_time<420) mu_time++;
				else mu_time = 0;
				
				g_time++;
				if(g_time == 50) {
					g_array[g_count]	= new ghost(frm);
					if(g_count < 999)g_count++;
					else g_count = 0;
					g_time = 0;
				}
				w1.wind_move(frm);
				w2.wind_move(frm);
				w3.wind_move(frm);
				w4.wind_move(frm);
				w5.wind_move(frm);
				w6.wind_move(frm);
				w7.wind_move(frm);
				lead.cup_move(frm);
				boss.boss_hurt_cover();
				boss.boss_move();
				for(int i = 0; i < g_count ; i++) {
					//System.out.println(i);
					if(g_array[i] != null)g_array[i].g_move(lead,b_array);
				}
				if(bullet_count_start < bullet_count)
					for(int i = bullet_count_start; i < bullet_count ; i++) {
						//System.out.println(i);
						if(b_array[i] != null)b_array[i].bullet_move();
					}
				else {
					for(int i = 0; i < bullet_count ; i++) {
						//System.out.println(i);
						if(b_array[i] != null)b_array[i].bullet_move();
					}
					for(int i = bullet_count_start; i < 1000 ; i++) {
						//System.out.println(i);
						if(b_array[i] != null)b_array[i].bullet_move();
					}
				}
				if(cuphead_onwind() != 0)	{
					
					if(!shoot_keep)lead.cup_change_icon();
					
					lead.set_dbjump(true);
				}
				lead.check_death();
			}
		}
		apw1.stop();
		if(boss.blood<1)b.Win(frm);
		else b.Lose(frm);
	}
	public static void bullet_count_start_change() {
		if(bullet_count_start<999)bullet_count_start++;
		else bullet_count_start = 0;
	}
	public int test_boss_getX() {
		return boss.boss_getX();
	}
	public int test_boss_getY() {
		return boss.boss_getY();
	}
	public void set_shoot_keep(boolean a) {
		shoot_keep = a;
	}
	public void rm_bg() {
		b.remove_bg(frm);
	}
	public void pu_bg() {
		b.put_bg2(frm);
	}
	public static int cuphead_onwind() {//判斷cuphead 是否在雲上面
		if((lead.getY()+50 >  w1.wind_y()-30 && lead.getY()+50 <=  w1.wind_y()) && (w1.wind_x()-50 < lead.getX() && lead.getX() < w1.wind_x()+80  ))
		{
			return 1;
		}else if((lead.getY()+50 >  w2.wind_y()-30 && lead.getY()+50 <=  w2.wind_y()) && (w2.wind_x()-50 < lead.getX() && lead.getX() < w2.wind_x()+80  ))
		{
			return 2;
		}else if((lead.getY()+50 >  w3.wind_y()-30 && lead.getY()+50 <=  w3.wind_y()) && (w3.wind_x()-50 < lead.getX() && lead.getX() < w3.wind_x()+80  ))
		{
			return 3;
		}else if((lead.getY()+50 >  w4.wind_y()-30 && lead.getY()+50 <=  w4.wind_y()) && (w4.wind_x()-50 < lead.getX() && lead.getX() < w4.wind_x()+80  ))
		{
			return 4;
		}else if((lead.getY()+50 >  w5.wind_y()-30 && lead.getY()+50 <=  w5.wind_y()) && (w5.wind_x()-50 < lead.getX() && lead.getX() < w5.wind_x()+80  ))
		{
			return 5;
		}else if((lead.getY()+50 >  w6.wind_y()-30 && lead.getY()+50 <=  w6.wind_y()) && (w6.wind_x()-50 < lead.getX() && lead.getX() < w6.wind_x()+80  ))
		{
			return 6;
		}else if((lead.getY()+50 >  w7.wind_y()-30 && lead.getY()+50 <=  w7.wind_y()) && (w7.wind_x()-50 < lead.getX() && lead.getX() < w7.wind_x()+80  ))
		{
			return 7;
		}else return 0;
	}
	static class KeyLis extends KeyAdapter{
		public void keyPressed(KeyEvent e)
		{
			//System.out.println(e.getKeyCode());
				if(e.isControlDown() && e.getKeyCode() == 39) {
					//System.out.println("CNT+39");
					shoot_keep = true;
					lead.change_shooting_icon();
					
					b_array[bullet_count]	= new bullet(frm,lead,0);
					if(bullet_count < 999)bullet_count++;
					else bullet_count = 0;
				}else if(e.isControlDown() && e.getKeyCode() == 38) {
					//System.out.println("CNT+38");
					shoot_keep = true;
					lead.change_shooting_icon();
					
					b_array[bullet_count]	= new bullet(frm,lead,1);
					if(bullet_count < 999)bullet_count++;
					else bullet_count = 0;
					//bull[0].set_pic(frm, lead, 0);
				}
				else if(e.isControlDown() && e.getKeyCode() == 40) {
					//System.out.println("CNT+40");
					shoot_keep = true;
					lead.change_shooting_icon();
					
					b_array[bullet_count]	= new bullet(frm,lead,2);
					if(bullet_count < 999)bullet_count++;
					else bullet_count = 0;
					//bull[0].set_pic(frm, lead, 0);
				}
				else if(e.getKeyCode() == 38) {	
					if(cuphead_onwind() != 0) {
								lead.cup_jump();
					}else if(lead.get_dbjump() == true) {
						lead.cup_jump();
						lead.set_dbjump(false);
					}
				}
				else if(e.getKeyCode() == 39) {
					
						lead.cup_right();
						
					}
				else if(e.getKeyCode() == 37) {
					
						lead.cup_left();
						
					}
				else lead.cup_change_icon();
			
			//System.out.print(e.getKeyCode());
				
		}
	}
}
