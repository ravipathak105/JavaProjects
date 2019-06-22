class LeftThread extends SnakeThread
{
  public void run()
  {
     VA.intt();
     while(hi!=0)
     {
	if(this!=VA.cthread)
	  hi--;
	for(int i=ti;i<=hi;i++)
	{
	  int x=VA.sn[i].getX();
	  x-=12;
	  VA.sn[i].setLocation(x,VA.sn[i].getY()); 
	}
	if(ti!=0)
	  ti--;
	VA.pause();
     }	
  }
}