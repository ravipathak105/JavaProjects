class StartThread extends MyThread
{
    public void run()
    {
	fi=0;
	while(li!=-1)
	{
	  if(this!=Va.cthread)
	    li--;
	  for(int i=li;i>=fi;i--)
	  {
	    Va.sy[i]-=Va.h;
	    Va.sn[i].setLocation(Va.sx[i],Va.sy[i]);
	  }
	  Ex.exp();
	}
    }	
}
