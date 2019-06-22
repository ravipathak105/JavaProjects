import java.awt.*;
class HighlightBox
{
  Color [] old;
  void highlight()
  {	
      Va.blinking=true;	
      Color color=Color.yellow;   
      int n=Va.movelist.size();
      old=new Color[n];
      int op=Va.getPn();	
      if(n>0)
      {
	Va.bc.setBorder(Va.greenb);			
        for(int i=0;i<n;i++)
          old[i]=Va.movelist.get(i).getBackground();
        for(int i=0;i<n;i++)
	{
	  MButton bt=Va.movelist.get(i);
	  if(bt.pi==op)
	    bt.setBackground(Color.red);		
	  else
	    bt.setBackground(Color.cyan);		
	}
      }   
    } 
    void dehighlight()
    {
      Va.blinking=false;	
      int n=Va.movelist.size();
      if(n>0)
      { 
	Va.bc.setBorder(Va.blackb);				
        for(int i=0;i<n;i++)
	  Va.movelist.get(i).setBackground(old[i]);
        Va.movelist.clear();	
      }	
    }
}