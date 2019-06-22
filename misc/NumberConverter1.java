import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;
class NumberConverter1 extends JFrame
{
 JTextField tb=new JTextField(12);
 Font fo=new Font("arial",0,20);	
 JButton bt=new JButton("Speak");	
 AudioClip []clips1=new AudioClip[20];
 AudioClip []clips2=new AudioClip[11];
 public NumberConverter1()
 {
	loadFiles();
	setSize(300,200);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	tb.setFont(fo);
	add(tb);
	add(bt);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	bt.setMnemonic('S');
	bt.addActionListener(new NumberListener());
	setVisible(true);
 }
 class NumberListener implements ActionListener
 {
  String res="";
  public void actionPerformed(ActionEvent evt)	
  {
	res="";
	String str=tb.getText();
	if(str.equals(""))
	{
	 return;
	}
	int num=Integer.parseInt(str);
	if(num>=100000 && num<=9999999)
	{
	  convert(num/100000);
	  clips2[10].play();
	  pause(); 	  
	  convert(num%100000);
	}
	else
	{
	  convert(num);
	}
  }
  void convert(int num)
  {
	if(num>=1 && num<=19)
	{
	  clips1[num].play();
	  pause();
	}
	if(num>=20 && num<=99)
	{
	  clips2[(num/10)-2].play();
	  pause();
	  if(num%10!=0)
	  {
	   clips1[num%10].play();
	   pause();
	  }
	}
	if(num>=100 && num<=999)
	{
	  convert(num/100);
	  clips2[8].play();
	  pause(); 	  
	  convert(num%100);
	}
	if(num>=1000 && num<=99999)
	{
	  convert(num/1000);
	  clips2[9].play();
	  pause(); 	  
	  convert(num%1000);
	}
	
  }
 }
 void loadFiles()
 {
  String [] str1={"20","30","40","50","60","70","80","90","hundred","thousand","million"};
  try
  {
   for(int i=0;i<clips1.length;i++)
   {
     URL url=new URL("file:"+System.getProperty("user.dir")+"/numbers/"+i+".wav");	
     clips1[i]=Applet.newAudioClip(url);	
   } 	
   for(int i=0;i<clips2.length;i++)
   {
     URL url=new URL("file:"+System.getProperty("user.dir")+"/numbers/"+str1[i]+".wav");	
     clips2[i]=Applet.newAudioClip(url);	
   } 	
  }catch(Exception ex){}
 }
 private static void pause()
 {
	try
	{
	  Thread.sleep(1000);
	}catch(Exception ex){}
 }
 public static void main(String ...s)
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new NumberConverter1();
 }
}

