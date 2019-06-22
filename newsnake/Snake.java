import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class Snake extends JFrame
{
  FoodHandling foodobj;
  InfoPanel infopanel;
  TimeMeter time;
  HighestScore highest;
  GameOver over;
  public Snake()
  {
	super("Snake");
	Va.snake=this;
	setSize(490,570);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	Va.field=new JLabel(new ImageIcon(getClass().getResource("images/field.jpg")));
	Va.field.setBounds(20,100,440,390);
	Va.field.setBorder(BorderFactory.createLineBorder(Color.red,5,true));
	add(Va.field);
	Va.field.setLayout(null);
	addSnake();
	time=new TimeMeter();
	time.addBar();
	infopanel=new InfoPanel();
	infopanel.addInfo();
	foodobj=new FoodHandling();
	foodobj.addFood();
	highest=new HighestScore();
	highest.fetch();
	over=new GameOver();
	over.addPanel();
	addKeyListener(new SnakeListener());
	setVisible(true);
  }
  void addSnake()
  {
	Border black=BorderFactory.createLineBorder(Color.black,Va.w,true);
	Border white=BorderFactory.createLineBorder(Color.white,Va.w,true);
	for(int i=0;i<Va.sn.length;i++)
	{
	  Va.sn[i]=new JLabel();
	  Va.sn[i].setSize(Va.w,Va.h);
	  if(i%2==1)
	   Va.sn[i].setBorder(black);
	  else
	   Va.sn[i].setBorder(white);
	}
	Va.sn[3].setBorder(BorderFactory.createLineBorder(Color.black,Va.w));
	for(int i=0;i<Va.size;i++)
	{
	  Va.sn[i].setBounds(Va.px,Va.py,Va.w,Va.h);
	  Va.field.add(Va.sn[i]);
	  Va.sy[i]=Va.py;
	  Va.sx[i]=Va.px;
	  Va.py-=Va.h;
	}
	Va.si=Va.size-1;
  }
  void intt()
  {
      for(Thread t:Thread.getAllStackTraces().keySet())
      {
	if(t.getState()==Thread.State.TIMED_WAITING)
	{
	  try{
		t.interrupt();
	  }catch(Exception ex){System.out.println(ex);} 	
	}
      }
  }
  class SnakeListener extends KeyAdapter
  {
    public void keyPressed(KeyEvent evt) 
    {
	if(Va.snakedead)
	  return;
	if(!Va.started && evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
		//Va.clipmove.loop();
		Va.start.setVisible(false);
		Va.snake.foodobj.showFood();
		Va.cthread=new StartThread();Va.cthread.start();
		new EatFoodThread().start();
		new CollisionThread().start();
		Va.started=true;
		return;
        }
	if(!Va.started)
	  return;
	if(!validMove())
	  return;
	if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
	{
		if(Va.cd==3 || Va.cd==1)
	 	  return;
		current(new RightThread(),1);
	}
	if(evt.getKeyCode()==KeyEvent.VK_DOWN)
	{
		if(Va.cd==0 || Va.cd==2)
		  return;
		current(new DownThread(),2);
	}
	if(evt.getKeyCode()==KeyEvent.VK_LEFT)
	{
		if(Va.cd==1 || Va.cd==3)
		  return;
		current(new LeftThread(),3);
	}
        if(evt.getKeyCode()==KeyEvent.VK_UP)
	{
		if(Va.cd==2 || Va.cd==0)
		  return;
		current(new UpThread(),0);
	}
    }
  }
  boolean validMove()
  {
	int xd=Va.sx[Va.si]-Va.sx[Va.si-2];
	int yd=Va.sy[Va.si]-Va.sy[Va.si-2];
	if(Math.abs(xd)==12 && Math.abs(yd)==12)
	  return false;
	return true;
  }
  void current(MyThread ct,int x)
  {
	Va.cd=x;
	Va.cthread=ct;
	Va.cthread.dir=x;
	Va.cthread.start();
  }
}