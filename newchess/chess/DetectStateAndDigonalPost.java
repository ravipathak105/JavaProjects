class DetectStateAndDigonalPost
{
  static void recordStPos(int r,int c)
  {
	for(int i=r-1;i>=0;i--)
	{
  	   if(set(i,c))	
	     break;
	}
	for(int i=r+1;i<=7;i++)
	{
  	   if(set(i,c))	
	     break;
	}
	for(int i=c-1;i>=0;i--)
	{
  	   if(set(r,i))	
	     break;
	}
	for(int i=c+1;i<=7;i++)
	{
  	   if(set(r,i))	
	     break;
	}
  } 
  static void recordDigPos(int r,int c)
  {
	for(int i=r-1,j=c+1;i>=0 && j<=7;i--,j++)
	{
  	   if(set(i,j))	
	     break;
	}
	for(int i=r+1,j=c-1;j>=0 && i<=7;i++,j--)
	{
  	   if(set(i,j))	
	     break;
	}
	for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
	{
  	   if(set(i,j))	
	     break;
	}
	for(int i=r+1,j=c+1;i<=7 && j<=7;i++,j++)
	{
  	   if(set(i,j))	
	     break;
	}
  } 
  static boolean set(int r,int c)
  {
    if(Va.bt[r][c].ei!=0 && Va.bc.pi==Va.bt[r][c].pi)
        return true;
    if(Va.bt[r][c].ei!=0 && Va.bc.pi!=Va.bt[r][c].pi)
    {
	Va.movelist.add(Va.bt[r][c]);
	return true;
    }
    Va.movelist.add(Va.bt[r][c]);
    return false;
  } 
}