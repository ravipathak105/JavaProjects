import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
class DisplayNumbers extends JFrame
{
 JLabel la=new JLabel("10");
 AudioClip []clips=new AudioClip[10];
 public DisplayNumbers()
 {
	setSize(380,300);
	loadFiles();
	setLocationRelativeTo(null);
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	setLayout(gbl);
	gbl.setConstraints(la,gbc);
	la.setFont(new Font("Lucida calligraphy",1,60));
	add(la);
	new NumberThread().start();
	setVisible(true);
 }
 class NumberThread extends Thread
 {
   public void run()
   {
      for(int num=10;num>=1;num--)
      {
	clips[num-1].play();
	la.setText(String.valueOf(num));
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
 void loadFiles()
 {
  for(int c=0;c<clips.length;c++)
  {
      try{ 
	URL url=getClass().getResource("sounds/"+(c+1)+".wav");
	clips[c]=Applet.newAudioClip(url);
      }catch(Exception ex){}
  }   	 
 }
 public static void main(String ...s)
 {
	new DisplayNumbers();
 }
}