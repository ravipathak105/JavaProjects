class AA
{
  void show()
  {
    java.net.URL obj=getClass().getResource("pics/india.gif");
    System.out.println(obj.toString());	 
  }
  public static void main(String []args)
  {
	new AA().show();
  }
}