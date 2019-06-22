class DieThread extends Thread
{
  public void run()
  {
    boolean blink=true; 
    int time=150;	
    int ctr=0; 	
    Va.clipmove.stop();
    Va.clipdie.play();
    Va.timer.setVisible(false);
    if(Va.ctr>=Va.highscore)
    {
	Va.snake.highest.save();
    }
    while(time<=200)
    {
	for(int i=0;i<Va.size;i++)
	{
	  Va.sn[i].setVisible(blink);
	}
	blink=!blink;
	try{
	  Thread.sleep(time);
	}catch(Exception ex){}
	ctr++;
	if(ctr%2==1)
	  time+=10;
    } 
    Va.snake.over.pa.setVisible(true);	
  }
}
