import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class setFrame extends JFrame{
	//設定視窗
	//static CardLayout card = new CardLayout();  
	public void set_Frame(JFrame frm) {
		
		//frm.setLayout(card);
		frm.setTitle("Cuphead!");
		frm.setSize(1000,600);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter(){//關閉鍵
			public void windowClosing(WindowEvent e){System.exit(0);}});
		
		
		
	}
/*	public void card_show(JFrame frm,String str) {
		//card.show(frm, str);
	}
	*/
}
