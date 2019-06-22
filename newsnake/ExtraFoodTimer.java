import javax.swing.*;
class ExtraFoodTimer extends Thread
{

  public void run()
  {
      	
    Va.foodtimer.setVisible(true);
    Va.timerstarted=true;	
    int c=Va.st[Va.speedi];
    for(;c>=1;c--)
    {
	if(!Va.bonusfoodvisible)
	  break;
	Va.foodtimer.setText(String.valueOf(c));
	Ex.exp1(1000);
    } 	
    Va.foodtimer.setVisible(false);
    Va.timerstarted=false;
    if(c==0)
    { 	
       Va.bonusfood.setVisible(false);	 	
       Va.bonusfoodvisible=false;
    } 	
  }
}