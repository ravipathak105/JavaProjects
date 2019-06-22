class LeftThread extends MyThread
{
    public void run()
    {
	Va.snake.intt();
	while(li!=-1)
	{
	  if(this!=Va.cthread)
	    li--;
	  if(fi!=0)
	     fi--;
	  for(int i=li;i>=fi;i--)
	  {
	    Va.sx[i]-=Va.w;
	    Va.sn[i].setLocation(Va.sx[i],Va.sy[i]);
	  }
	  Ex.exp();
	}
    }	
}