import javax.swing.*;
public class bg {//背景圖
	//插入圖片
    ImageIcon icon1=new ImageIcon("C:\\java\\Cuphead\\img\\bg.jpg" );
    ImageIcon icon2=new ImageIcon("C:\\java\\Cuphead\\img\\KnockOut.jpg" );
    ImageIcon icon3=new ImageIcon("C:\\java\\Cuphead\\img\\Dead.jpg" );
    //新增JLabel 放置圖片
    JLabel label1=new JLabel(icon1);
    
    AePlayWave apw=new AePlayWave("C:\\java\\Cuphead\\src\\music\\KnockOut.wav"); 
    AePlayWave apw2=new AePlayWave("C:\\java\\Cuphead\\src\\music\\Dead.wav"); 
	
    public void put_bg(JFrame frm)
    {	
    	
        label1.setBounds(0,-10,frm.getWidth(),frm.getHeight());
        
        //frm.setComponentZOrder(label1);
        frm.add(label1);
        frm.setSize(1010,620);
        
    }
    public void Lose(JFrame frm) {
    	apw2.start();
    	Test.w1.win();
    	Test.w2.win();
    	Test.w3.win();
    	Test.w4.win();
    	Test.w5.win();
    	Test.w6.win();
    	Test.w7.win();
    	Test.lead.win();
    	Test.boss.win();
    	for(int i = 0 ;i <1000;i++) {
    		if(Test.b_array[i] != null)
    		Test.b_array[i].win();
    	}
    	for(int i = 0 ;i <100000;i++) {
    		if(Test.g_array[i] != null)
    		Test.g_array[i].win();
    	}
    	label1.setIcon(icon3);
        label1.setBounds(0,-20,frm.getWidth(),frm.getHeight());
    }
    public void Win(JFrame frm)
    {	
    	apw.start();
    	Test.w1.win();
    	Test.w2.win();
    	Test.w3.win();
    	Test.w4.win();
    	Test.w5.win();
    	Test.w6.win();
    	Test.w7.win();
    	Test.lead.win();
    	Test.boss.win();
    	for(int i = 0 ;i <1000;i++) {
    		if(Test.b_array[i] != null)
    		Test.b_array[i].win();
    	}
    	for(int i = 0 ;i <100000;i++) {
    		if(Test.g_array[i] != null)
    		Test.g_array[i].win();
    	}
    	label1.setIcon(icon2);
        label1.setBounds(0,0,frm.getWidth(),frm.getHeight());
        //
        //frm.setComponentZOrder(label1);
        //frm.add(label1);
        //frm.setSize(1010,620);
        
    }
    public void remove_bg(JFrame frm) {
    	frm.remove(label1);
    }
    public void put_bg2(JFrame frm) {
    	frm.add(label1);
    }
    
}