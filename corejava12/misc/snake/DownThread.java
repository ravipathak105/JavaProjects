class DownThread extends SnakeThread
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
	  int y=VA.sn[i].getY();
	  y+=12;
	  VA.sn[i].setLocation(VA.sn[i].getX(),y); 
	}
	if(ti!=0)
	  ti--;
	VA.pause();
     }	
  }
}