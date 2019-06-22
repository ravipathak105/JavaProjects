class AA
{
  public AA()
  {
	System.out.println("1");
  }
  public AA(int x)
  {
	System.out.println("2");
  }
  public AA(int x,int y)
  {
	System.out.println("3");
  }
  public static void main(String []args)
  {
	new AA("CETPA");
  }
}