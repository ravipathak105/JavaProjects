import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ElementClickListener implements ActionListener
{
    PlaceElement dp=new PlaceElement();
    MButton btn;
    public void actionPerformed(ActionEvent evt)
    {
       try{      
	btn=(MButton)evt.getSource();
	if(isInvalidMove())
	  return;
	if(Va.blinking)
	{
	  Va.mbc=btn;
	  if(!isValidMove())
	    return;
	  dp.moveElement();
	  return;	  	
	}
	if(Va.pln!=btn.pi)
	  return;
	Va.bc=btn;
	if(Va.checker!=null)
	{
	  saveKing();
	  return;
	}
	if(btn.ei==5)
	{
	    RajaValidMove.findValidPosition();
	    return;
	}
        if(!SafeMove.isSafe())
	{
	   Va.checker=null;
	   Va.checkerlist.clear();
	   return;
	}
	DetectMovePosition.detect();
      }catch(Exception ex){ex.printStackTrace();}
    }
    boolean isInvalidMove()
    {
	if(Va.bc==null && (btn.ei==0 || btn.pi!=Va.pln))
	  return true;
	if(Va.bc!=null && Va.bc==btn)
	{
	  Va.chess.box.dehighlight();
	  Va.bc=null;;
	  return true;
	}
	if(btn.pi==Va.pln)
	  Va.chess.box.dehighlight();
	return false;
    }
    void saveKing()
    {
	if(Va.bc.ei==5)
	{
	  RajaValidMove.findValidPosition();
	  return;
	}
	if(Va.checkerlist.size()==1)
	{
	  FindSavePosition.findPosition();
	}
    }
    boolean isValidMove()
    {	
	int n=Va.movelist.size();
	for(int i=0;i<n;i++)
	{
	  if(Va.mbc==Va.movelist.get(i))
	   return true;
	}
	return false;
    }
}