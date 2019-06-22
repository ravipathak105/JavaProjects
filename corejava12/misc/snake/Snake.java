import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class Snake extends JFrame
{
  JPanel pa=new JPanel();  
  int x=50,y=350;
  JLabel msg=new JLabel("<html><h2>Press ENTER to start...</h2></html>");
  public Snake()
  {
	super("Snake");
	setSize(500,500);
	setLocationRelativeTo(null);
	setLayout(null);
	pa.setBounds(50,30,400,400);
	add(pa);
	pa.setBorder(BorderFactory.createLineBorder(Color.red,4));
	pa.setBackground(new Color(100,255,100));
	pa.setLayout(null);
	msg.setBounds(100,50,200,30);
	pa.add(msg);
	addSnake();
	addKeyListener(new StartListener());
	setVisible(true);
  }	
  void addSnake()
  {
    Border bb=BorderFactory.createLineBorder(Color.black,12,true);
    Border bw=BorderFactory.createLineBorder(Color.white,12,true);
    for(int i=0;i<10;i++)
    {
	VA.sn[i]=new JLabel();
	VA.sn[i].setBounds(x,y,12,12);
	pa.add(VA.sn[i]);
	if(i%2==0)
	  VA.sn[i].setBorder(bw);
	else
	  VA.sn[i].setBorder(bb);
	y-=12;	
    }  		
    bb=BorderFactory.createLineBorder(Color.black,12);
    VA.sn[9].setBorder(bb);
  }
  class StartListener extends KeyAdapter
  {
    boolean started=false;  	
    public void keyPressed(KeyEvent evt)
    {
       int kc=evt.getKeyCode();	
       if(!started && kc==KeyEvent.VK_ENTER)
       {	
	msg.setVisible(false);
	started=true; 
	VA.cthread=new StartThread();VA.cthread.start(); 
       }	
       if(kc==KeyEvent.VK_RIGHT)
       {	
	VA.cthread=new RightThread();VA.cthread.start(); 
       }	
       if(kc==KeyEvent.VK_DOWN)
       {	
	VA.cthread=new DownThread();VA.cthread.start(); 
       }	
       if(kc==KeyEvent.VK_LEFT)
       {	
	VA.cthread=new LeftThread();VA.cthread.start(); 
       }	
       if(kc==KeyEvent.VK_UP)
       {	
	VA.cthread=new UpThread();VA.cthread.start(); 
       }	
    }
  }
  public static void main(String []args)
  {
	new Snake();
  }
}











