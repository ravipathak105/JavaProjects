import javax.swing.*;
import java.awt.*;
class DisplayNumbers extends JFrame
{
 JLabel la=new JLabel("10");
 public DisplayNumbers()
 {
	setSize(380,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout(FlowLayout.CENTER,0,80));
	la.setFont(new Font("Lucida calligraphy",1,60));
	add(la);
	new NumberThread().start();
	setVisible(true);
 }
 class NumberThread extends Thread
 {
   public void run()
   {
	for(int c=10;c>=1;c--)
	{
	  la.setText(String.valueOf(c));
	  try{
	    Thread.sleep(1000);
	  }catch(Exception ex){} 
	}
	la.setText("Let's play");
	  try{
	    Thread.sleep(1000);
	  }catch(Exception ex){} 
	System.exit(0);
   }
 }   
 public static void main(String ...s)
 {
	new DisplayNumbers();
 }
}









