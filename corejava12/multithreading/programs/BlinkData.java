import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BlinkData extends JFrame
{
 JLabel la=new JLabel("<html><h1 style='color:red'>Rehan Ahmad</h1></html>");
 BlinkThread th=new BlinkThread();
 public BlinkData()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	setLayout(gbl);
	gbl.setConstraints(la,gbc);
	add(la);
	la.setOpaque(true);
	la.setBackground(Color.WHITE);
	la.addMouseListener(new BlinkListener());
	th.start();
	new ColorThread().start();
	setVisible(true);
 }
 class BlinkThread extends Thread
 {
   public void run()
   {
	boolean blink=false; 
	while(true)
	{
	  la.setVisible(blink=!blink); 
	  try{
	    Thread.sleep(100);
	  }catch(Exception ex){}
	}	
   }	
 }
 class ColorThread extends Thread
 {
   java.util.Random ra=new java.util.Random();
   public void run()
   {
	while(true)
	{
	  int r=ra.nextInt(256);
	  int g=ra.nextInt(256);
	  int b=ra.nextInt(256);
	  getContentPane().setBackground(new Color(r,g,b));
	  try{
	    Thread.sleep(1000);
	  }catch(Exception ex){}
	}	
   }	
 }
 class BlinkListener extends MouseAdapter
 {
  public void mouseEntered(MouseEvent evt) 
  {
	th.suspend();
  }
  public void mouseExited(MouseEvent evt) 
  {
	th.resume();
  }
 }
 public static void main(String ...s)
 {
	new BlinkData();
 }
}