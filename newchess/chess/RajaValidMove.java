import java.util.ArrayList;
class RajaValidMove
{
  static ArrayList<MButton> validlist=new ArrayList<MButton>();  
  static ArrayList<MButton> tlist=new ArrayList<MButton>();  
  static MButton tbc;
  static void findValidPosition()
  {
     findPosition();
     Va.bc=tbc;	
     int m=validlist.size();
     System.out.println("after:"+m); 	
     Va.bc=tbc;	
     validlist.clear();
     Va.chess.box.highlight();
  }
  static void findPosition()
  {
    	tbc=Va.bc;
	validlist.clear();
	DetectRajaPos.detect();
	validlist.addAll(Va.movelist);
	System.out.println("before:"+validlist.size()); 	
	Va.movelist.clear();
	findP();
  }
  static void findP()
  {
    int pi=Va.getPn();
    int n=Va.elementlist[pi].size();	
    tlist.addAll(validlist);
    tbc.ei=0;
    for(int c=0;c<tlist.size();c++)
    {	
      MButton rbt=tlist.get(c); 
      int pn=rbt.pi;rbt.pi=Va.pln;int ei=rbt.ei;rbt.ei=5;	
      for(int i=0;i<n;i++)	
      {
	MButton mb=Va.elementlist[pi].get(i);
	/*if(mb==rbt)
	{
          System.out.println(mb.ei+" can cut by raja"); 
	  continue;
	}*/
	Va.bc=mb;
	DetectMovePosition.findPosition();
	if(Va.movelist.size()>0 && Va.movelist.contains(rbt))
	{
	  validlist.remove(rbt);
	  break;
	}
	Va.movelist.clear();
       }
       rbt.pi=pn;rbt.ei=ei;
      }
      tbc.ei=5;
      Va.movelist.clear();
      Va.movelist.addAll(validlist);
      System.out.println("m:"+Va.movelist.size());	
      tlist.clear();	
  }
}