class VLA1
{
  static void showLength(int ...y)
  {
	System.out.println(y.length);
  }
  public static void main(String ...args)
  {
	int []x={10,20,30};
	showLength(x);
	showLength(10,60,40,30,90);
	showLength(10,50);
	showLength();
  }
}