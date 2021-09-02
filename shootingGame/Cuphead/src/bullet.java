import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*; 
public class bullet{
	int direct;
	Test t = new Test();
	setFrame s  = new setFrame();
	ImageIcon bull_pic=new ImageIcon("C:\\java\\Cuphead\\img\\bullet.png" );
	ImageIcon bull_up=new ImageIcon("C:\\java\\Cuphead\\img\\bullet_up.png" );
	ImageIcon bull_down=new ImageIcon("C:\\java\\Cuphead\\img\\bullet_down.png" );
	JLabel bullet;
	AePlayWave apw=new AePlayWave("C:\\java\\Cuphead\\src\\music\\gun.wav"); 
	public bullet(JFrame frm,cuphead1 lead,int d) {
		apw.start();
		//System.out.println(lead.getX()+" "+lead.getY());
		if(d == 0) {
			bullet=new JLabel(bull_pic);
			bullet.setBounds(lead.getX()+100,lead.getY()+50,bull_pic.getIconWidth(),bull_pic.getIconHeight());
		}
		else if(d == 1) {
			bullet=new JLabel(bull_up) ;
			bullet.setBounds(lead.getX()+100,lead.getY(),bull_up.getIconWidth(),bull_up.getIconHeight());
		}
		else {
			bullet=new JLabel(bull_down);
			bullet.setBounds(lead.getX()+100,lead.getY()+50,bull_down.getIconWidth(),bull_down.getIconHeight());
		}
		
		
		
		
		
		frm.add(bullet);
		//frm.setComponentZOrder(bullet, 1);
	 	t.rm_bg();
	 	t.pu_bg();
		//s.card_show(frm, "a");
		frm.setSize(1010,620);
	 	direct = d;
	 	
	}
	public void bullet_move() {
		if(bullet != null) {
			if(direct == 0)
				bullet.setBounds(bullet.getX()+25,bullet.getY(),bullet.getWidth(),bullet.getHeight());
			else if(direct == 1) bullet.setBounds(bullet.getX()+25,bullet.getY()-10,bullet.getWidth(),bullet.getHeight());
			else bullet.setBounds(bullet.getX()+25,bullet.getY()+10,bullet.getWidth(),bullet.getHeight());
				
			if(bullet.getX() >= t.test_boss_getX() && (bullet.getY() - 50 >= t.test_boss_getY() &&  bullet.getY() < t.test_boss_getY()+497)) {
				Boss.boss_hurt();
				bullet.setVisible(false);
				bullet = null;
				Test.bullet_count_start_change();
			}
			
		}
		
		
	}
	public int getX() {
		if(bullet != null) return bullet.getX();
		else return 0;
	}
	public int getY() {
		if(bullet != null) return bullet.getY();
		else return 0;
	}
	public int getW() {
		if(bullet != null) return bullet.getWidth();
		else return 0;
	}
	public int getH() {
		if(bullet != null) return bullet.getHeight();
		else return 0;
	}
	public void win() {
		if(bullet != null) {
			bullet.setVisible(false);
		}
	}
}
