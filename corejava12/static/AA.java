class AA
{
  int x;
  static int y;
  public static void main(String []args)
  {
	AA obj=new AA();
	obj.x=90;
	AA.y=20;
	System.out.println(obj.x);
	System.out.println(AA.y);
  }
}







