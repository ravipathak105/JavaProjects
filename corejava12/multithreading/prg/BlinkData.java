import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BlinkData extends JFrame
{
 JLabel la=new JLabel("CETPA Infotech");
 boolean stop=false;
 public BlinkData()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout(FlowLayout.CENTER,0,80));
	la.setFont(new Font("Lucida calligraphy",1,25));
	add(la);
	la.addMouseListener(new BlinkListener());
	new BlinkThread().start();
	setVisible(true);
 }
 class BlinkThread extends Thread
 {
   public void run()
   {
     boolean blink=false;	
     while(true)
     {
       if(!stop)
       { 
	 la.setVisible(blink=!blink);
	 try{
	   Thread.sleep(100);
	 }catch(Exception ex){}
       } 
     } 	
   }
 }  
 class BlinkListener extends MouseAdapter
 {
   public void mouseEntered(MouseEvent evt)
   {
	stop=true;
	la.setVisible(true);
   }
   public void mouseExited(MouseEvent evt)
   {
	stop=false;
   }
 }  
 public static void main(String ...s)
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new BlinkData();
 }
}









