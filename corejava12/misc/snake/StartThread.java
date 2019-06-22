class StartThread extends SnakeThread
{
  public void run()
  {
     ti=0;
     while(hi!=0)
     {
	if(this!=VA.cthread)
	  hi--;
	for(int i=ti;i<=hi;i++)
	{
	  int y=VA.sn[i].getY();
	  y-=12;
	  VA.sn[i].setLocation(VA.sn[i].getX(),y); 
	}
	VA.pause();
     }	
  }
}