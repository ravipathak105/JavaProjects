import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
class ShowDate extends JFrame
{
 JLabel la=new JLabel();
 public ShowDate()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	setLayout(gbl);
	gbl.setConstraints(la,gbc);
	add(la);
	la.setFont(new Font("arial",0,25));
	new TimeThread().start();
	setVisible(true);
 }
 class TimeThread extends Thread
 {
   public void run()
   {
	while(true)
	{
	  Date dt=new Date();
	  int h=dt.getHours();
	  int m=dt.getMinutes();
	  int s=dt.getSeconds();
	  String time=h+":"+m+":"+s;
	  la.setText(time);
	  try{
	    Thread.sleep(1000);
	  }catch(Exception ex){}
	}	
   }	
 }
 public static void main(String ...s)
 {
	new ShowDate();
 }
}