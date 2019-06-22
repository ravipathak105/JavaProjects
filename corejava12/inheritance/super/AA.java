class AA
{
  int x=10;
}
class BB extends AA
{
  int y=60;
  void show()
  {
	int z=100;
	System.out.println(x);
	System.out.println(y);
	System.out.println(z);
  }
  public static void main(String []args)
  {
	BB obj=new BB();
	obj.show();
  }
}