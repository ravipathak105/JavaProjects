class Val
{
  public static void main(String []args)
  {
	String db="rehan";
	String str=args[0].trim();
	if(str.equals(db))
	{
	  System.out.println("Valid");
	}
	else
	{
	  System.out.println("Invalid");
	}
  }
}