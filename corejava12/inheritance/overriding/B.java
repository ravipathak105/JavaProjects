class B extends A
{
  char ch='K';
  String str="Lucknow";
  public void show()
  {
	super.show();
	System.out.println(ch);
	System.out.println(str);
  }
  public static void main(String [] args)
  {
	B obj=new B();
	obj.show();
  } 
}