interface X
{
  void show();
}
class AA
{
  static void disp(X obj)
  {
	obj.show();
  }
  public static void main(String []args)
  {
	AA.disp(new X()
	{
	  public void show()
	  {
		System.out.println("Example of anonymous class");
 	  }
	});
  }
}