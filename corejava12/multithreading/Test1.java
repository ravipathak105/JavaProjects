class AA extends Thread
{
  public void run()
  {
	System.out.println("A");
	System.out.println("B");
	System.out.println("C");
  }
}
class Test1 
{
  public static void main(String []args)
  {
	AA th=new AA();//mew state
	th.start();//runnable state
	System.out.println("X");
	System.out.println("Y");
	System.out.println("Z");	
  }
}