import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class StopWatch extends JFrame implements ActionListener
{
 JLabel la=new JLabel("00:00:00");
 JButton bt=new JButton("Start"); 
 int h,m,s;
 boolean start=true;
 public StopWatch()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
	la.setFont(new Font("Lucida calligraphy",1,20));
	add(la);
	add(bt);
	bt.addActionListener(this);
	setVisible(true);
 }
 public void actionPerformed(ActionEvent evt)
 {
    if(bt.getText().equals("Start"))
    {
	start=true;
	new WatchThread().start();
	bt.setText("Stop");
    }	 		
    else
    {
	bt.setText("Start");
	start=false;
    }		
 }  
 class WatchThread extends Thread
 {
   public void run()
   {
     while(start)
     {
	try{
	  Thread.sleep(1000);
	}catch(Exception ex){}

	s++;
	la.setText((h<10?"0"+h:h)+":"+(m<10?"0"+m:m)+":"+(s<10?"0"+s:s));
	if(s==59)
	{
	  s=0;
	  m++;
	  if(m==60)
	  {
		m=0;
		h++;
	  }
	}
     } 	
   }
 }
 public static void main(String ...s)
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new StopWatch();
 }
}









