abstract class X
{
  abstract void show();
}
class BB
{
  public static void main(String []args)
  {
	X obj=new X()
	{
	  void show()
	  {
		System.out.println("Cetpa");
	  } 	
	};
	obj.show();
  }
}