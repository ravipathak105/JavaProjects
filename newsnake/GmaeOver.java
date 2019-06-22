import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class GameOver
{
  JPanel pa=new JPanel();
  JButton b1=new JButton("Replay");
  JButton b2=new JButton("Back");
  void addPanel()
  {
	pa.setBounds(20,498,440,35);
	Va.snake.add(pa);
	pa.add(b1);
	pa.add(b2);
	pa.setBackground(Color.cyan);
	ReplayListener listener=new ReplayListener();
	b1.addActionListener(listener);	
	b2.addActionListener(listener);
	pa.setVisible(false);
  }
  class ReplayListener implements ActionListener
  {
     public void actionPerformed(ActionEvent evt)
     {
	resetValues();
	if(evt.getSource()==b2)//back button
	{
		Va.stsnake.setVisible(true);
		Va.snake.setVisible(false);
	}
     }
  } 
  void setSnake()
  {
	Va.snake.highest.fetch();
	Va.started=false;
	Va.px=15;Va.py=360;Va.cd=0;
	Border black=BorderFactory.createLineBorder(Color.black,Va.w,true);
	Border white=BorderFactory.createLineBorder(Color.white,Va.w,true);
	for(int i=0;i<Va.size;i++)
	{
	  Va.sn[i].setVisible(false);
	  Va.field.remove(Va.sn[i]);
	  Va.sn[i]=null;
	}
	Va.size=4;
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
	  Va.field.add(Va.sn[i]);
	  Va.sy[i]=Va.py;
	  Va.sx[i]=Va.px;
	  Va.sn[i].setBounds(Va.px,Va.py,Va.w,Va.h);
	  Va.py-=Va.h;
	}
	Va.si=Va.size-1; 
	Va.score.setText("SCORE: 0");
	Va.speed=Va.speedinc[Va.speedi][0];
	Va.snake.requestFocusInWindow();
	Va.mp.setVisible(false);
	Va.spa.setVisible(true);
	Va.start.setVisible(true);
	pa.setVisible(false);
  }
  void resetValues()
  {
	Va.bonusfoodvisible=false;
	Va.bonusfood.setVisible(false);	
	Va.food.setVisible(false);	
	Va.started=false;Va.bonusfoodvisible=false;Va.timerstarted=false;Va.snakedead=false;Va.recordset=false;Va.foodeated=false;
	Va.ctr=0;Va.speedchange=70;Va.leveln=1;Va.fx=400;Va.fy=320;Va.fxy=15;Va.n=0;Va.highscore=0;
	Va.si=0;Va.cd=0;Va.foodx=0;Va.foody=0;Va.bonusfoodx=0;Va.bonusfoody=0;Va.mx=200;
	for(int i=0;i<Va.sx.length;i++)
	{
	  Va.sx[i]=0;Va.sy[i]=0;
	}
	Va.bonusvalue=new int[]{40,45,50};
	Va.scvalue=new int[]{70,80,90};
	Va.bs=new int[]{80,60,40};
	Va.st=new int[]{10,8,5};
 	Va.cthread=null;
	setSnake();
  }
}