import javax.swing.*;
class VA
{
  static JLabel [] sn=new JLabel[10];
  static SnakeThread cthread;
  static void pause()
  {
    try	
    {
	Thread.sleep(1000);
    }catch(Exception ex){}
  }
  static void intt()
  {
      for(Thread t:Thread.getAllStackTraces().keySet())
      {
	if(t.getState()==Thread.State.TIMED_WAITING)
	{
	  try
          {
		t.interrupt();
	  }catch(Exception ex){} 	
	}
      }
  }
}









