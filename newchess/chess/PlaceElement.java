import javax.swing.*;
import java.awt.*;
class PlaceElement
{
   void moveElement()
   {
	if(Va.bc.ei==5 && (Va.p1castl || Va.p2castl))
	{
  	  if(Castling.detect())
	    return;
	}
	CutOpponent();
	Va.mbc.setIcon(Va.bc.getIcon());
	Va.bc.setIcon(null);
	Va.mbc.ei=Va.bc.ei;
	Va.mbc.pi=Va.bc.pi;
	if(Va.bc.ei==1)
	{
	  if(Va.bc.r==0)
 	    Va.hm[Va.pln][0]=true; 
	  else
 	    Va.hm[Va.pln][1]=true; 
	}
	Va.bc.ei=0;
	Va.bc.pi=-1;
	Va.chess.box.dehighlight();
	if(Va.mbc.ei==6 && (Va.mbc.r==0 || Va.mbc.r==7))
	{
	    Va.promote=true;	
	    new PromotePaidal().setVisible(true);	 
	}
	if(Va.checker!=null)
	{
	  resetCheck();
	}
	if(!Va.promote)
	{
	  reset();
	}
   }
   static void reset()
   {
	Va.elementlist[Va.pln].remove(Va.bc);
	Va.elementlist[Va.pln].add(Va.mbc);
	Va.lblturn[Va.pln].setText("");
	if(Va.mbc.ei==5)	
	{
	  Va.kp[Va.pln]=Va.mbc;
	  Va.km[Va.pln]=true;
	}
	Va.pln=Va.getPn();
	CheckMate.check();
	String msg="It's your turn...";
	if(Va.checker!=null)
	{
	  msg="<html><font color='red'>It's Check..Save your king</font></html>"; 	  
	  if(CheckMate.isCheckMate())
	  {
		msg="<html><font color='red'>It's Checkmate..game is over</font></html>";
	  }
	}
	Va.lblturn[Va.pln].setText(msg);
	Va.bc=Va.mbc=null;
   }
   void CutOpponent()
   {
	if(Va.mbc.ei!=0)
	{
	  if(Va.mbc.pi==1)
	  {
	    Va.left.add(new JLabel(new ImageIcon(getClass().getResource("images/cb"+Va.mbc.ei+".gif"))));
	    Va.elementlist[1].remove(Va.mbc);
	  }
	  else
	  {
	    Va.right.add(new JLabel(new ImageIcon(getClass().getResource("images/cw"+Va.mbc.ei+".gif"))));
	    Va.elementlist[0].remove(Va.mbc);
	  }
	}
   } 
   void resetCheck()
   {
	Va.checkerlist.clear();
	Va.checker.setBorder(BorderFactory.createLineBorder(Color.black,1));
	Va.kingchecked.setBorder(BorderFactory.createLineBorder(Color.black,1));
	Va.checker=null;
   }
}