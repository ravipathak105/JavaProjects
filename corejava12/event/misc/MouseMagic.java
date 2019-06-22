import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class MouseMagic extends JFrame
{
 String str="<html><h3 style='color:red;font-family:lucida handwriting'>Touch me to see magic</h3></html>"; 
 JLabel la=new JLabel(str);
 int x=20,y=30;
 Random ra=new Random();
 boolean stop=false; 
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
	this.addKeyListener(new StopListener());
	setVisible(true); 
 }
 class StopListener extends KeyAdapter
 {
   public void keyPressed(KeyEvent evt)
   {
      if(evt.getKeyCode()==KeyEvent.VK_F5)
      { 	
	stop=true;
      } 
   } 
 }  
 class MagicListener extends MouseAdapter
 {
   public void mouseEntered(MouseEvent evt)
   {
      if(!stop)
      {
	x=ra.nextInt(600);
	y=ra.nextInt(480);
	la.setLocation(x,y);
      }
      stop=false; 
   }
 }  
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new MouseMagic();
 }
}













