class DetectRajaPos
{
 static void detect()
  {
	int r=Va.bc.r;
	int c=Va.bc.c;
	if(r==7 || r==0)
	 setCastling(c);
	recordPos(r,c);
  }
  static void recordPos(int r,int c)
  {
  	   set(r,c+1);
  	   set(r,c-1);
  	   set(r+1,c);
  	   set(r-1,c);
  	   set(r+1,c+1);
	   set(r+1,c-1);
	   set(r-1,c-1);
	   set(r-1,c+1);
  }	
  static void set(int r,int c)
  {
    if(r<0 || c<0 || r>7 || c>7)
	return;
    if(Va.bt[r][c].ei!=0 && Va.bc.pi==Va.bt[r][c].pi)
        return;
    if(Va.bt[r][c].ei!=0 && Va.bc.pi!=Va.bt[r][c].pi)
    {
	Va.movelist.add(Va.bt[r][c]);
	return;
    }
    Va.movelist.add(Va.bt[r][c]);
    return;
  } 
  static void setCastling(int c)
  {
     int pi=Va.bc.pi;		
     if(!Va.km[pi] && Va.p1castl && pi==0 && (!Va.hm[pi][0] || !Va.hm[pi][1]))
     {
	setC(7,c);
     }	
     if(!Va.km[pi] && Va.p2castl && pi==1 && !(Va.hm[pi][0] || !Va.hm[pi][1]))
     {
	setC(0,c);
     }
  }
  static void setC(int r,int c)
  {
	if(Va.bc.r==r && Va.bc.c==4 && Va.bt[r][7].ei==1 && Va.bt[r][6].ei==0 && Va.bt[r][5].ei==0)
	{
	   Va.movelist.add(Va.bt[r][c+2]);
	}
	else if(Va.bc.r==r && Va.bc.c==4 && Va.bt[r][0].ei==1 && Va.bt[r][1].ei==0 && Va.bt[r][2].ei==0 && Va.bt[r][3].ei==0)
	{
	   Va.movelist.add(Va.bt[r][c-2]);
	}
  }
}