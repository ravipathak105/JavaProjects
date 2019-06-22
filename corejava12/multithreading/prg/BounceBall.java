import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BounceBall extends JFrame
{
 JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/ball.png")));
 int x=120,y=0; 
 boolean started=false;
 public BounceBall()
 {
	setSize(300,500);
	setLocationRelativeTo(null);
	setLayout(null);
	la.setBounds(x,y,30,30);
	add(la);
	addKeyListener(new KeyAdapter()
	{
	  public void keyPressed(KeyEvent evt)
	  {
             if(!started && evt.getKeyCode()==KeyEvent.VK_ENTER)
	     {    	
		new BallThread().start();
	 	started=true;
	     }  
	  }
	});
	setVisible(true);
 }
 class BallThread extends Thread
 {
   public void run()
   {
     int d=15; 	
     int sp=52,ctr=0;	 
     while(true)
     {
	if(ctr%2==0)
	 sp+=-2;
	for(int c=0;c<29;c++)
	{
	  y+=d;
	  la.setLocation(x,y);
	  try{
	   Thread.sleep(sp);
	  }catch(Exception ex){}
	}
	d=0-d;
	ctr++;
	 
     }
   }
 } 
 public static void main(String ...s)
 {
	new BounceBall();
 }
}



