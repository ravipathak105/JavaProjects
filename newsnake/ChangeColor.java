import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
class ChangeColor extends Thread
{
  public void run()
  {
    Border black=BorderFactory.createLineBorder(Color.black,Va.w);
    Border black1=BorderFactory.createLineBorder(Color.black,Va.w,true);
    Border white1=BorderFactory.createLineBorder(Color.white,Va.w,true);
    Va.sn[Va.si].setBorder(black);
    Border temp=white1; 	
    for(int i=Va.si-1;i>=0;i--)
    {
    	Va.sn[i].setBorder(temp);	
	temp=temp==white1?black1:white1;
    } 	
  }
}