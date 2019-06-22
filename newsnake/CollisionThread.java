class CollisionThread extends Thread
{
   public void run()
   {
     while(true)
     {
	if(Va.sx[Va.si]<=13 || Va.sy[Va.si]<=0 || Va.sx[Va.si]>=423 || Va.sy[Va.si]>=362 || isCollision())
	{
	  Va.snakedead=true;
	  System.out.println("Collision");
	  for(Thread t:Thread.getAllStackTraces().keySet())
          {
	 	if(t instanceof MyThread)
	        {
		  MyThread mt=(MyThread)t;	
		  mt.li=-1;
	        }
	  }
	  Va.snakedead=true;
	  break;
	}
	Ex.exp();
     }
     new DieThread().start();	
   }
   boolean isCollision()
   {
     int n=Va.si-3; 	 
     for(int i=0;i<n;i++)
     {
	int xd=Va.sx[i]-Va.sx[Va.si];
	int yd=Va.sy[i]-Va.sy[Va.si];
	if((Math.abs(xd)==12 && yd==0)||(Math.abs(yd)==12 && xd==0))
	{
	  System.out.println("Self...");
	  return true;
	}
     } 
     return false;
   }
}