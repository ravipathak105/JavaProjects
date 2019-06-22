class DetectPaidalPos
{
  static void detect()
  {
	int r=Va.bc.r;
	int c=Va.bc.c;
	if(Va.bc.pi==1)
	{
	  elementAtDig(r+1,c+1); 
	  elementAtDig(r+1,c-1);
	  elementAtSt(r+1,c);
	  if(r==1)
	  {
	    if(Va.bt[r+1][c].ei==0)
	      elementAtSt(r+2,c);
	  }
 	}
	if(Va.bc.pi==0)
	{
	  elementAtDig(r-1,c+1); 
	  elementAtDig(r-1,c-1); 
	  elementAtSt(r-1,c);
	  if(r==6)
	  {
	    if(Va.bt[r-1][c].ei==0)
	      elementAtSt(r-2,c);
	  } 	
        }
  } 
  static void elementAtDig(int r,int c)
  {
    if(c<0 || c>7 || r<0 || r>7)
      return;  	 	
    if(Va.bt[r][c].ei!=0 && Va.bt[r][c].pi!=Va.bc.pi)
    {
	Va.movelist.add(Va.bt[r][c]);	  
    }
  }
  static void elementAtSt(int r,int c)
  {
    if(r<0)
     return;		
    if(Va.bt[r][c].ei==0)
    {
	Va.movelist.add(Va.bt[r][c]);		  
    }	
  }
}