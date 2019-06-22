import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class MouseMagic extends JFrame
{
 JLabel la=new JLabel("Touch me to see magic");
 int x=20,y=30;
 boolean stop=false;
 Random ra=new Random();
 public MouseMagic()
 {
	setSize(800,550);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	la.setFont(new Font("arial",0,20));
	la.setBounds(x,y,230,30);
	add(la);
	la.addMouseListener(new MagicListener());
	this.addMouseListener(new StopListener());
	setVisible(true); 
 }
 class StopListener extends MouseAdapter
 {
  public void mousePressed(MouseEvent evt)
  {
	if(evt.getButton()==MouseEvent.BUTTON3)
	{
	  stop=true;
	}	
  } 	
 }
 class MagicListener implements MouseListener
 {
  public void mouseEntered(MouseEvent evt)
  {
    if(!stop)
    {  	
      x=ra.nextInt(600);
      y=ra.nextInt(450);
      la.setLocation(x,y);	
    }
    stop=false;  
  } 	
  public void mouseExited(MouseEvent evt){}
  public void mouseClicked(MouseEvent evt){}
  public void mousePressed(MouseEvent evt){}
  public void mouseReleased(MouseEvent evt){}
 }
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new MouseMagic();
 }
}