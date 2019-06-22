class AB
{
  int x;
  static void show(AB obj2)
  {
	obj2.x=90;
  }
  public static void main(String []args)
  {
	AB obj1=new AB();
	obj1.x=20;
	show(obj1);
	System.out.println(obj1.x);
  }
}