class Demo
{
  static void method1()
  {
	System.out.println("Method1 executed");
  }
  static void method2()
  {
	System.out.println("Method2 executed");
	method1();
  }
  public static void main(String []args)
  {
	System.out.println("Main executed");
	method2();
  }
}