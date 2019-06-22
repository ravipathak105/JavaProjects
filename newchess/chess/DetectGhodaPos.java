import java.util.ArrayList;
class DetectGhodaPos
{
  static void detect()
  {
	int r=Va.bc.r;int c=Va.bc.c;
	recordPos(r-2,c+1);
	recordPos(r-2,c-1);
	recordPos(r-1,c+2);
	recordPos(r-1,c-2);
	recordPos(r+2,c+1);
	recordPos(r+2,c-1);
	recordPos(r+1,c+2);
	recordPos(r+1,c-2);
  }  
  static void recordPos(int r,int c)	
  {
    if(r<0 || r>7 || c<0 ||c>7)
      return;
    if(Va.bt[r][c].ei!=0 && Va.bt[r][c].pi==Va.bc.pi)	
      return;	
    Va.movelist.add(Va.bt[r][c]);		
  }
}