class AA extends Thread
{
 public void run()
 {
	System.out.println("A");
	System.out.println("B");
	System.out.println("C");
 }
}
class MT
{
 public static void main(String args[])
 {
	AA th=new AA();
	th.start();
	System.out.println("X");
	System.out.println("y");
	System.out.println("z");
 }
}