import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.URL;
import java.util.Random;
import java.awt.Graphics;
class FPS extends JFrame 
{
		
	JLabel gun, env, mark, m1,m2,m3,m4,m5,m7,m8,fire,blast,hs,skull,go;
	int x=-460,i=1000,i2=1000,i4=1000,i7=1000,i5=-50,i3=376,i8=-50,n=0,gunfire=0,shot=0,missfire=0,score=0,t=332;
	boolean gamestarted=false;
	AudioClip [] clips= new AudioClip[3];
	public FPS()
	{
		super("Ghost Hunter >>> Press <SpaceBar> to shoot");
		setSize(1000,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		ImageIcon igun= new ImageIcon("pics/gun.png");
		ImageIcon en= new ImageIcon("pics/env.jpg");
		ImageIcon m= new ImageIcon("pics/mark.png");
		env=new JLabel(en);
		gun=new JLabel(igun);
		mark=new JLabel(m);
		m1=new JLabel(new ImageIcon("pics/mon (1).gif"));
		m2=new JLabel(new ImageIcon("pics/mon (2).gif"));
		m3=new JLabel(new ImageIcon("pics/mon (3).gif"));
		m4=new JLabel(new ImageIcon("pics/mon (4).gif"));
		m5=new JLabel(new ImageIcon("pics/mon (5).gif"));
		m7=new JLabel(new ImageIcon("pics/mon (7).gif"));
		m8=new JLabel(new ImageIcon("pics/mon (8).gif"));
		hs=new JLabel(new ImageIcon("pics/homescreen.jpg"));
		skull=new JLabel(new ImageIcon("pics/skull.png"));
		fire=new JLabel(new ImageIcon("pics/fire.gif"));
		blast=new JLabel(new ImageIcon("pics/blast.gif"));
		go=new JLabel("Game Over!!");
		go.setForeground(Color.yellow);
		go.setBounds(150,200,1000,200);
		add(go);
		go.setFont(new Font("Papyrus",Font.PLAIN,120));
		go.setVisible(false);
		add(gun);
		add(mark);
		add(blast);
		add(fire);
		add(m1);
		add(m2);
		add(m3);
		add(m4);
		add(m5);
		add(m7);
		add(m8);
		add(env);
		add(skull);
		skull.setBounds(352,0,296,213);
		add(hs);
		hs.setBounds(0,0,1000,600);
		ra();
		loadFiles();
		addKeyListener(new KL());
		setVisible(true);
	}
	void loadFiles()
	{
  		try
		{
			String [] str={"music.wav", "gun.wav" , "tada.wav"};
			for(int p=0; p<str.length; p++)
			{
				URL url= new URL("file:" + System.getProperty("user.dir") + "/sound/" + str[p]);
				clips[p]= Applet.newAudioClip(url);
			}
		}catch(Exception ex){}
  	}
	class KL extends KeyAdapter
	{
		public void keyPressed(KeyEvent evt)
		{
			if(evt.getKeyCode()==KeyEvent.VK_ESCAPE)
			{
				System.exit(0);
			}
			if(evt.getKeyCode()==KeyEvent.VK_ENTER)
			{
				if(gamestarted==false)
				{	
					clips[0].loop();
					hs.setVisible(false);
					env.setBounds(x,-240,1920,1080);
					try{Thread.sleep(1000);}catch(Exception ex){}
					new FS().start();
					gamestarted=true;
					gun.setBounds(480,t,268,235);
					mark.setBounds(479,340,42,33);
					setTitle("Ghost Hunter >>>Press <Escape> to Exit");
				}
			}
			if(evt.getKeyCode()==KeyEvent.VK_LEFT)
			{
				if(x<=-10 && gamestarted==true)
				{
					x+=15;
					i+=15;
					i2+=15;
					i3+=15;
					i4+=15;
					i5+=15;
					i7+=15;
					i8+=15;
					blast.setVisible(false);
					env.setBounds(x,-240,1920,1080);				
				}
				else
					return;
			}
			if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				if(x>=-920 && gamestarted==true)
				{
					x-=15;
					i-=15;
					i2-=15;
					i3-=15;
					i4-=15;
					i5-=15;
					i7-=15;
					i8-=15;
					blast.setVisible(false);
					env.setBounds(x,-240,1920,1080);
					
				}
				else
					return;
			}
			if(evt.getKeyCode()==KeyEvent.VK_SPACE)
			{	
			      if(gamestarted==true)
			      {	
				clips[1].play();
				t=t+25;
				gun.setBounds(480,t,268,235);
				fire.setVisible(true);
				fire.setBounds(465,300,71,100);
				blast.setBounds(465,300,48,78);
				if(n==1)
				{
					if(i>=420 && i<=510)
					{	
						m1.setVisible(false);
						i=1000;
						ra();blast.setVisible(true);
						shot+=1;
					}
				}
				if(n==2)
				{	
					if(i2>=380 && i2<=500)
					{	
						m2.setVisible(false);
						i2=1000;
						ra();blast.setVisible(true);shot+=1;
					}
				}	
					
				if(n==3)
				{	
					if(i3>=241 && i3<=496)
					{	
						m3.setVisible(false);
						ra();blast.setVisible(true);shot+=1;
					}
				}	
				if(n==4)
				{	
					if(i4>=358 && i4<=500)
					{	
						m4.setVisible(false);
						i4=1000;
						ra();blast.setVisible(true);shot+=1;
					}
					
				}	
				if(n==5)
				{ 
					if(i5>=315 && i5<=495)
					{	
						m5.setVisible(false);
						i5=-50;
						ra();blast.setVisible(true);shot+=1;
					}
				}
				if(n==6)
				{	
					if(i7>=370 && i7<=415)
					{	
						m7.setVisible(false);
						i7=1000;
						ra();blast.setVisible(true);shot+=1;
					}
				}
				if(n==7)
				{	
					if(i8>=420 && i8<=460)
					{	
						m8.setVisible(false);
						i8=-50;
						ra();blast.setVisible(true);shot+=1;
					}
				}	
			       }
			       else
				return;		
			}
			
		}
		public void keyReleased(KeyEvent evt)
		{
			if(evt.getKeyCode()==KeyEvent.VK_SPACE)
			{
				if(gamestarted==true)
				{
					t=t-25;
					gun.setBounds(480,t,268,235);
					fire.setVisible(false);
					gunfire+=1;
					missfire=gunfire-shot;
					repaint();
				}
				else
					return;
			}
		}
	}
	public void paint(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		g2.setPaint(Color.yellow);
		g2.setFont(new Font("Papyrus",Font.PLAIN,20));
		g2.drawString("You Missed :" +missfire,10,100);
		g2.drawString("Hits :" + shot,10,150);
		if(score==1)
			g2.drawString("Your Score is:" + shot,400,150);
	}
	class FS extends Thread
  	{
  		public void run()
		{
		      if(gamestarted==true)
		      {	
			while(true)
			{
	 			try
                   			{
					sleep(50);
					if(n==1)
					{	i-=10;
						m1.setVisible(true);
						m1.setBounds(i,350,80,50);
						if(i<-50)
							gameOver();
					}
					if(n==2)
					{	i2-=10;
						m2.setVisible(true);
						m2.setBounds(i2,320,108,140);
						if(i2<-50)
							gameOver();
					}
					if(n==3)
					{
						m3.setVisible(true);
						m3.setBounds(i3,150,248,296);
					}
					if(n==4)
					{	i4-=10;
						m4.setVisible(true);
						m4.setBounds(i4,350,104,107);
						if(i4<-50)
							gameOver();
					}
					if(n==5)
					{	i5+=10;
						m5.setVisible(true);
						m5.setBounds(i5,280,180,172);
						if(i5>1000)
							gameOver();
					}
					if(n==6)
					{	i7-=10;
						m7.setVisible(true);
						m7.setBounds(i7,280,190,150);
						if(i7<-50)
							gameOver();
					}
					if(n==7)
					{	i8+=10;
						m8.setVisible(true);
						m8.setBounds(i8,320,120,120);
						if(i8>1000)
							gameOver();
					}
					
				}catch(Exception ex){}
			}
		       }
		}
	}
	public void gameOver()
	{
		gamestarted=false;
		score=1;
		gun.setVisible(false);
		mark.setVisible(false);
		go.setVisible(true);
		clips[0].stop();
		repaint();
		
	}
	public void ra()
   	{
		Random ra=new Random();
		n=ra.nextInt(7)+1;
   	}   
	public static void main(String ...s)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new FPS();
	}
}