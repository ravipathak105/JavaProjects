class ArrowThread extends Thread
{
  public void run()
  {
     int y=-2;
     while(Va.move)
     {
       for(int c=0;c<35;c++)
       {	
	int x=Va.arrow.getX();
	x+=y;
	Va.arrow.setLocation(x,Va.arrow.getY());
        Va.pause(10);
       }
       y=0-y; 	  	
     }			
  }
}