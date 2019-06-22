import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;
class BounceBall extends JFrame
{
 JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/ball.png")));
 int x=185,y=0; 
 BallThread th;
 boolean started=false;
 public BounceBall()
 {
	super("Press ENTER to start");
	loadSound();
	setSize(400,500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	la.setBounds(x,y,30,30);
	add(la);
	this.addKeyListener(new BallListener());
	setVisible(true);
 }
 class BallListener extends KeyAdapter
 { 
  public void keyPressed(KeyEvent evt)
  {
    if(!started && evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
	th=new BallThread();
	th.start();
	started=true;
    } 	    	
  }
 }
 class BallThread extends Thread
 {
  public void run()
  {
      boolean down=true; 	
      while(true)
      {   
        if(y<=0)
	 down=true; 
	else if(y>=440)
	 down=false;
	if(down)
	{
	  y+=4;
	  x--;
	}
	else
	{
	 y-=4;
	 x++;
	}
	la.setBounds(x,y,30,30);
	try
	{
	  Thread.sleep(10);
	}catch(Exception ex){}
      } 
  }
 }
 void loadSound()
 {
   try
   { 
     URL url=getClass().getResource("sound/intro.mid");	
     AudioClip clip=Applet.newAudioClip(url);
     clip.play();	
   }catch(Exception ex){}
 } 
 public static void main(String ...s)
 {
	new BounceBall();
 }
}