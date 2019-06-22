class AA extends Thread
{
 public void run()
 {
   for(int ctr=1;ctr<=10;ctr++)
   {
	System.out.println(ctr);
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
class ShowNumber
{
 public static void main(String args[])
 {
	AA th=new AA();
	th.start();
 }
}