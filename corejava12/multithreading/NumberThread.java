class NumberThread extends Thread
{
  public void run()
  {
    for(int c=10;c>=1;c--)
    {
	System.out.println(c);
	try
	{
	  Thread.sleep(1000);
	}
	catch(InterruptedException ex)
	{
	  System.out.println(ex);
	}
    }  	
  }
}
class Test2
{
  public static void main(String []args)
  {
	new NumberThread().start();
  }
}