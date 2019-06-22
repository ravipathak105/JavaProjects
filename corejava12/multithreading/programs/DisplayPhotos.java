import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
class DisplayPhotos extends JFrame
{
 JLabel la=new JLabel();
 AudioClip []clips=new AudioClip[10];
 public DisplayPhotos()
 {
	setSize(300,300);
	loadFiles();
	setLocationRelativeTo(null);
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	setLayout(gbl);
	gbl.setConstraints(la,gbc);
	la.setFont(new Font("arial",1,30));
	add(la);
	new NumberThread().start();
	setVisible(true);
 }
 class NumberThread extends Thread
 {
   public void run()
   {
	for(int c=1;c<=10;c++)
	{
	  clips[c-1].play();
	  la.setIcon(new ImageIcon("images/"+c+".jpg"));
	  try{
	    Thread.sleep(1000);
	  }catch(Exception ex){}
	}
	System.exit(0);
   }	
 }
 void loadFiles()
 {
  for(int c=0;c<clips.length;c++)
  {
      try{ 
	URL url=new URL("file:"+System.getProperty("user.dir")+"/sounds/"+(c+1)+".wav");
	clips[c]=Applet.newAudioClip(url);
      }catch(Exception ex){}
  }   	 
 }
 public static void main(String ...s)
 {
	new DisplayPhotos();
 }
}