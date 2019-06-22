class BonusFood extends Thread
{
   public void run()
   {
	while(Va.bonusfoodvisible)
        {
       	    Va.n=0;
	    int cx=Va.sx[Va.si]-Va.bonusfoodx;
	    int cy=Va.sy[Va.si]-Va.bonusfoody;
	    if(((cx>=-13 && cx<=20) && (cy>=-10 && cy<=20)) || ((cy>=-13 && cy<=20) && (cx>=-10 && cx<=20)))
	    {	
	       playSound();
	       Va.score.setText("SCORE: "+(Va.ctr+=Va.bonusvalue[Va.speedi]));
	       Va.bonusvalue[Va.speedi]+=5;	
	       Va.bonusfood.setVisible(false);	
	       Va.bonusfoodvisible=false;
	       new ChangeSpeed().start();
	       Va.snake.highest.newRecord();
	    }
	  }
    }
    void playSound()
    {
	Va.clipeatc.play();
	Va.clipeatc=Va.clipeatc==Va.clipeat1?Va.clipeat2:Va.clipeat1;
    }
   
}