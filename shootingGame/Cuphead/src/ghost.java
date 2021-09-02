import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*; 
public class ghost {
	ImageIcon gh_img=new ImageIcon("C:\\java\\Cuphead\\img\\ghost.png" );
	JLabel gh_label = new JLabel(gh_img);
	Test t = new Test();
	public ghost(JFrame frm) {
		gh_label.setBounds(Boss.boss.getX()-100,(int) (Math.random()*620),gh_img.getIconWidth(),gh_img.getIconHeight());
		
		
		frm.add(gh_label);
		//frm.setComponentZOrder(bullet, 1);
	 	t.rm_bg();
	 	t.pu_bg();
		//s.card_show(frm, "a");
		frm.setSize(1010,620);
	 	
	}
	public void g_move(cuphead1 leader,bullet[] b_array) {
		if(gh_label != null) {
			int randomy = (int) (Math.random()*20-10);
			
			gh_label.setLocation(gh_label.getX()-10, gh_label.getY()+randomy);
			
			
			if((gh_label.getX() >= leader.getX()-40 && gh_label.getX() <= leader.getX()+80)&&(gh_label.getY()  >= leader.getY()-70 &&  gh_label.getY() < leader.getY()+leader.getH()-20))
			leader.setdeath();
				//System.out.println("hurt");
				
			if(gh_label.getX() <= 0) {
				gh_label.setVisible(false);
				gh_label = null;
			}
			for(int i = 0; i< 1000;i++) {
				if(b_array[i] != null) {// 
					if(gh_label != null && gh_label.getX()<= b_array[i].getX() + b_array[i].getW() && gh_label.getX() + gh_label.getWidth()  >= b_array[i].getX() && gh_label != null && gh_label.getY() - 30 <= b_array[i].getY() &&  gh_label.getY() + gh_label.getHeight() >= b_array[i].getY()  && b_array[i].getX() != 0 && b_array[i].getY() != 0 && b_array[i].getH() != 0 && b_array[i].getW() != 0 )
						{// &&
							gh_label.setVisible(false);
							gh_label = null;
						}
				}
			}
		}
		
	}
	public void win() {
		if(gh_label != null)gh_label.setVisible(false);
	}
	
}
