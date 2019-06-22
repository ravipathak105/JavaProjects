import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
class MO extends JFrame
{
 JLabel la=new JLabel();
 int x=140,y=140;
 AudioClip clip;
 public MO()
 {
	setSize(300,300);
	setLayout(null);
	setLocationRelativeTo(null);
	la.setBorder(BorderFactory.createLineBorder(Color.blue,20));	
	la.setBounds(x,y,20,20);
	add(la);
	this.addKeyListener(new MoveListener());
	loadFile();
	setVisible(true); 
 }
 class MoveListener extends KeyAdapter
 {
   public void keyPressed(KeyEvent evt)
   {
	int kc=evt.getKeyCode();
	if(kc==KeyEvent.VK_UP)
	{
	  if(y<=0)
	  {
	   clip.play();
	   return;
	  }
	  y-=5;
	  la.setLocation(x,y);
	}
	if(kc==KeyEvent.VK_DOWN)
	{
	  y+=5;
	  la.setLocation(x,y);
	}
	if(kc==KeyEvent.VK_LEFT)
	{
	  if(x<=0)
	  {
	   clip.play();
	   return;
	  }
	  x-=5;
	  la.setLocation(x,y);
	}
	if(kc==KeyEvent.VK_RIGHT)
	{
	  x+=5;
	  la.setLocation(x,y);
	}
   }
 } 
 void loadFile()
 {
   clip=Applet.newAudioClip(getClass().getResource("sounds/gameover.wav"));
 }   
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new MO();
 }
}