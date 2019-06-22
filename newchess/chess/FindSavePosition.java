import java.util.ArrayList;
import javax.swing.*;
class FindSavePosition
{
  static MButton tbc;
  static ArrayList<MButton> listc=new ArrayList<MButton>();
  static ArrayList<MButton> lists=new ArrayList<MButton>();
  static ArrayList<MButton> listp=new ArrayList<MButton>();
  static boolean cutting=false;
  static void findPosition() 
  {
	recordPosition();
	if(lists.size()>0)
	  setMax();
	else
	  JOptionPane.showMessageDialog(Va.chess,"Invalid move...");
        listc.clear();
        lists.clear();  
  }
  static void recordPosition()
  {
        listc.clear();
        lists.clear();  
	Va.movelist.clear();
	if(Va.bc.ei==5)
	{
	  RajaValidMove.findValidPosition();
	  return;
	}
	DetectMovePosition.findPosition();
	listc.addAll(Va.movelist);
	Va.movelist.clear();
	tbc=Va.bc;
	Va.bc=Va.checker;
	DetectMovePosition.findPosition();
	record();
  }
  static void record()  
  {
    int n=Va.movelist.size(); 	
    for(int i=0;i<n;i++)
    {
	if(listc.contains(Va.movelist.get(i)))
	{
	  lists.add(Va.movelist.get(i));
	}
    }
    if(listc.contains(Va.checker))
        cutting=true;		
    Va.movelist.clear(); 	
    findP();	
  }
  static void findP()
  {
    int n=lists.size();	
    listp.addAll(lists);	
    for(int i=0;i<n;i++)	
    {
	MButton bt=listp.get(i);
	bt.ei=tbc.ei;bt.pi=tbc.pi;
	Va.bc=Va.checker;
	DetectMovePosition.findPosition();
	int m=Va.movelist.size();
	for(int j=0;j<m;j++)
	{
	  if(Va.movelist.get(j).ei==5)
	  {
	    bt.ei=0;bt.pi=-1;
	    lists.remove(bt);
	  }
	}
	bt.ei=0;bt.pi=-1;
	Va.movelist.clear();	
    }
    listp.clear();	
    if(cutting)
    {
	lists.add(Va.checker);
	cutting=false;
    }	
    Va.movelist.addAll(lists);		
  }
  static void setMax()
  {
    Va.bc=tbc;		
    Va.chess.box.highlight();
  }
}