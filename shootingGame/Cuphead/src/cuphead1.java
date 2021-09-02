import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.applet.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
public class cuphead1{
	Test t = new Test();
	int x;
	int y;
	int direct = 0;
	int death;
	boolean double_jump = true;
	int wind;//cuphead站在地雲上面號碼，如果==0代表他不再雲上面
	ImageIcon cuphead_1=new ImageIcon("C:\\java\\Cuphead\\img\\cuphead1.png" );
	ImageIcon cuphead_rrun=new ImageIcon("C:\\java\\Cuphead\\img\\right_run_cuphead.png" );
	ImageIcon cuphead_lrun=new ImageIcon("C:\\java\\Cuphead\\img\\left_run_cuphead.png" );
	ImageIcon cuphead_left=new ImageIcon("C:\\java\\Cuphead\\img\\cupleft.png" );
	ImageIcon cuphead_shoot=new ImageIcon("C:\\java\\Cuphead\\img\\shoot.png" );
	
	
	ImageIcon HP1 =new ImageIcon("C:\\java\\Cuphead\\img\\HP1.jpg" );
	ImageIcon HP2 =new ImageIcon("C:\\java\\Cuphead\\img\\HP2.png" );
	ImageIcon HP3 =new ImageIcon("C:\\java\\Cuphead\\img\\HP3.png" );
	
	JLabel cup_death = new JLabel(HP3);
	JLabel cuphead1_label=new JLabel(cuphead_1);
	public cuphead1(){
		death = 3;
	}
	public void put_pic(JFrame frm,int a ,int b)//把cuphead圖片放上去
	{
		 cuphead1_label.setBounds(a,b,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
		 cup_death.setBounds(10,545,HP3.getIconWidth(),HP3.getIconHeight());
			
		 
		 
		 frm.add(cup_death);
		 frm.add(cuphead1_label);
			
		 frm.setSize(1010,620);
		 	
	}
	public int getH() {
		return cuphead1_label.getHeight();
	}
	public int getY() {
		return cuphead1_label.getY();
	}
	public int getX() {
		return cuphead1_label.getX();
	}
	public void cup_move(JFrame frm) {
		
			if(t.cuphead_onwind() == 0) 
				cuphead1_label.setBounds(cuphead1_label.getX(),cuphead1_label.getY()+20,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
			else cuphead1_label.setBounds(cuphead1_label.getX()+5,cuphead1_label.getY(),cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
			
			if(cuphead1_label.getY() > frm.getHeight()) {
				death-=1;
				double_jump = true;
				cuphead1_label.setBounds(100,30,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
			}
		
	}
	public int getdeath() {
		return death;
		
	}
	public void setdeath() {
		death--;
		cuphead1_label.setBounds(100,30,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
		
	}
	/*public void cuphead_move() {
		System.out.println(cuphead_onwind());
	}*/
	public void cup_jump() {
		t.set_shoot_keep(false);
		if(direct == 0)cuphead1_label.setIcon(cuphead_rrun);
		else cuphead1_label.setIcon(cuphead_lrun);
		
		if(direct == 0)
		cuphead1_label.setBounds(cuphead1_label.getX()+200,cuphead1_label.getY()-200,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());			
		else cuphead1_label.setBounds(cuphead1_label.getX()-200,cuphead1_label.getY()-200,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());			
		
	}
	public void cup_change_icon() {
		if(direct == 0)cuphead1_label.setIcon(cuphead_1);
		else cuphead1_label.setIcon(cuphead_left);
	}
	public void cup_right() {
		t.set_shoot_keep(false);
		direct = 0;
		cuphead1_label.setIcon(cuphead_rrun);

		cuphead1_label.setBounds(cuphead1_label.getX()+20,cuphead1_label.getY(),cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
		
		
	}
	public void cup_left() {
		t.set_shoot_keep(false);
		direct = 1;
		cuphead1_label.setIcon(cuphead_lrun);
		
		cuphead1_label.setBounds(cuphead1_label.getX()-20,cuphead1_label.getY(),cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
		
		
		
	}
	public boolean get_dbjump() {
		return double_jump;
	}
	public void set_dbjump(boolean t) {
		double_jump = t;
	}
	public void check_death() {
		if(cuphead1_label.getX() +60 > t.test_boss_getX()  && (cuphead1_label.getY() - 50 >= t.test_boss_getY() &&  cuphead1_label.getY() < t.test_boss_getY()+497)) {
			//System.out.println(cuphead1_label.getX()+80+" "+t.test_boss_getX());
			//&& (cuphead1_label.getY() - 50 >= t.test_boss_getY() &&  cuphead1_label.getY() < t.test_boss_getY()+497)
			death-=1;
			double_jump = true;
			cuphead1_label.setBounds(100,30,cuphead_1.getIconWidth(),cuphead_1.getIconHeight());
			//System.out.println("進");
		}
		if(death == 3)cup_death.setIcon(HP3);
		else if(death == 2)cup_death.setIcon(HP2);
		else if(death == 1)cup_death.setIcon(HP1);
	}
	public void change_shooting_icon() {
		cuphead1_label.setIcon(cuphead_shoot);
	}
	public void win() {
		cuphead1_label.setVisible(false);
		cup_death.setVisible(false);
	}
}
