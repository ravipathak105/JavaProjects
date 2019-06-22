import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
class EatFoodThread extends Thread
{
    public void run()
    {
	while(!Va.snakedead)
	{
	  int cx=Va.sx[Va.si]-Va.foodx;
	  int cy=Va.sy[Va.si]-Va.foody;
	  if(((cx>=-10 && cx<=10) && (cy>=-10 && cy<=10)))
	  {	
	       Va.food.setVisible(false);
	       playSound();	
	       Va.score.setText("SCORE: "+(Va.ctr+=(Va.leveln+Va.speedi)));
	       Va.n++;
	       Va.snake.highest.newRecord();	
	       if(Va.n==5)
	       {  	
		Va.snake.foodobj.bonusFood();
	        if(!Va.timerstarted)
	          Va.snake.time.iterate();
	       }
	       if(Va.cthread.dir==0)
		growSnake(0,-Va.h);
	       else if(Va.cthread.dir==2)
		growSnake(0,Va.h);
	       else if(Va.cthread.dir==1)
		growSnake(Va.w,0);
	       else if(Va.cthread.dir==3)
		growSnake(-Va.w,0);	
	       new ChangeSpeed().start();
	       Ex.exp1(100); 	
	       Va.snake.foodobj.showFood();
	  }
	}
    }
    void playSound()
    {
	Va.clipeatc.play();
	Va.clipeatc=Va.clipeatc==Va.clipeat1?Va.clipeat2:Va.clipeat1;
    }
    void growSnake(int a,int b)
    {
	int i=Va.size;
	Va.sx[i]=Va.sx[Va.si]+a;
	Va.sy[i]=Va.sy[Va.si]+b;
	Va.sn[Va.size].setLocation(Va.sx[i],Va.sy[i]);
	Va.field.add(Va.sn[i]);
	Va.si=i;
	Va.size++;
	Va.cthread.li++;
	new ChangeColor().start();
     } 
 }