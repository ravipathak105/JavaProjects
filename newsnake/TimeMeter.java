import javax.swing.*;    
import java.awt.*;
public class TimeMeter
{      
  public void addBar()
  {    
	Va.timer=new JProgressBar(0,100);            
	Va.timer.setValue(0);    
	Va.timer.setFont(new Font("arial",1,15));
	Va.timer.setForeground(Color.yellow);
	Va.timer.setStringPainted(true); 
  }    
  public void iterate()
  {    
	Va.spa.setVisible(false);
	Va.mp.setVisible(true);
	new MarqueeThread().start();
	Va.timerstarted=true;
      	Va.timer.setVisible(true); 
	new BarThread().start();
  }  
  class BarThread extends Thread
  {
    public void run()
    {
	int i=0;
	int c=Va.bs[Va.speedi];
	System.out.println(c);
	while(i<=100)
	{    
	  if(!Va.bonusfoodvisible)
	    break;
	  Va.timer.setValue(++i);     
	  Ex.exp1(c);
        }
	Va.spa.setVisible(true);
	Va.mp.setVisible(false);
	Va.foodeated=true;
	Va.timer.setVisible(false);
        Va.timerstarted=false;
        if(i>100)
        { 	
          Va.bonusfood.setVisible(false);	 	
          Va.bonusfoodvisible=false;
        }
    }
  }
}    