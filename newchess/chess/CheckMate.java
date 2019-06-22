import javax.swing.*;
import java.awt.*;
class CheckMate
{
  static void check()
  {
	findCheck();
	if(Va.checker!=null)
	{
	  Va.kingchecked.setBorder(BorderFactory.createLineBorder(Color.red,5));
	  Va.bc.setBorder(BorderFactory.createLineBorder(Color.green,5));
	}
  } 
  static void findCheck()
  {
	int pi=Va.getPn();
        int n=Va.elementlist[pi].size();
	Va.movelist.clear();		
	for(int i=0;i<n;i++)
	{
	  Va.bc=Va.elementlist[pi].get(i);
	  DetectMovePosition.findPosition();
	  if(Va.movelist.size()>0 && Va.movelist.contains(Va.kp[Va.pln]))
	  {
		Va.kingchecked=Va.kp[Va.pln];
		Va.checker=Va.bc;
		Va.checkerlist.add(Va.bc);
	  }
	  Va.movelist.clear();	
	}
  }
  static boolean isCheckMate()
  {
	Va.movelist.clear();
	Va.bc=Va.kingchecked;
	RajaValidMove.findPosition();
	if(Va.movelist.size()>0)
	{
	    System.out.println("cm:"+Va.movelist.size());
	    Va.movelist.clear();
	    return false; 
	}
	Va.movelist.clear();
	int c=Va.pln;
	int n=Va.elementlist[c].size();
	for(int i=0;i<n;i++)
	{
	  MButton bt=Va.elementlist[c].get(i);
	  Va.bc=bt;
	  if(bt==Va.kingchecked)
	   continue;
	  FindSavePosition.recordPosition();
	  if(Va.movelist.size()>0)
	  {
	    System.out.println("dm:"+Va.movelist.size());
	   Va.movelist.clear();
	   return false;
	  }
	  Va.movelist.clear();
	}
	return true;	
  }
}