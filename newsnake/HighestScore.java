import java.io.*;
class HighestScore
{
  public void save()
  {
    try
    {
	FileWriter fw=new FileWriter("score.dat");
	PrintWriter pw=new PrintWriter(fw);
	pw.println("Name:"+Va.username);
	pw.println("Score:"+Va.ctr);
	pw.close();
	fw.close();
    }catch(Exception ex){}  	
  }
  public void hiddenFile()
  {
	try{FileWriter fw=new FileWriter("score.dat");
	Runtime.getRuntime().exec("attrib+h score.dat");
	}catch(Exception ex){}
  }
  public void fetch()
  {
    try
    {
	BufferedReader br=new BufferedReader(new FileReader("score.dat"));
	Va.name=br.readLine();
	Va.name=Va.name.substring(5);
	String score=br.readLine();
	Va.highscore=Integer.parseInt(score.substring(6));
	Va.playerscore.setText("Highest score is "+Va.highscore+" by "+Va.name);
    }catch(Exception ex)
    {
	Va.playerscore.setText("You are first player...");
    }  	
  }
  public void newRecord()
  {
   if(!Va.recordset && Va.ctr>Va.highscore)
   {
	Va.playerscore.setFont(Va.fo);
	Va.recordset=true;
	Va.playerscore.setText("<html><font color='red'>You have set a new record...</font></html>");
	new BlinkRecord().start();
   }
  }
  class BlinkRecord extends Thread
  {
    public void run()
    {
	boolean blink=false;
	int sp=30;
	while(sp<=200)
	{
	  Va.playerscore.setVisible(blink=!blink); 
	  Ex.exp1(sp);
	  Va.playerscore.setVisible(blink=!blink); 
	  Ex.exp1(sp);
	  sp+=10;
	}
	Va.playerscore.setVisible(true);
    }	
  }
}