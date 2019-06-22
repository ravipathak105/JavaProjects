class MarqueeThread extends Thread
{
  public void run()
  {
    int x=Va.mx;
    int z=-5;
    while(!Va.foodeated)
    {
	for(int c=1;c<30;c++)
	{
	  Va.marquee.setLocation(x,2);
	  x+=z;	
	  Ex.exp1(30);
	}
	z=0-z;
    }
    Va.marquee.setLocation(Va.mx,2);
    Va.foodeated=false;		
  }
}