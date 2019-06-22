class CalUser
{
  public static void main(String []args)
  {
	Addition obj1=new Addition();
	Multiplication obj2=new Multiplication();
	obj1.acceptNumber(900,400);
	obj2.acceptNumber(90,40);
	obj1.add();
	obj2.multiply();
	obj1.showResult();
	obj2.showResult();
  }
}