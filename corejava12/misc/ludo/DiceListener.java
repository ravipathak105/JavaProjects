import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
class DiceListener implements ActionListener
{
  public void actionPerformed(ActionEvent evt)
  {
    new DiceThread().start();
  }
}
class DiceThread extends Thread
{
  public void run()
  {
    for(int i=0;i<5;i++)
    {
	ImageIcon icon=new ImageIcon(getClass().getResource("pics/dice"+i+".jfif"));
	Va.dice.setIcon(icon);
	Va.pause(50);
    } 
    setNumberImage();
  }
  void setNumberImage()
  {
	Random ra=new Random();
	int num=ra.nextInt(6)+1;
	if(num!=6)
	{
	  int n=ra.nextInt(3);	 
	  if(n==2)
	   num=6;	
	}
	ImageIcon icon=new ImageIcon(getClass().getResource("pics/"+num+".jpg"));
	Va.dice.setIcon(icon);
	Va.move=false;
  }
}








