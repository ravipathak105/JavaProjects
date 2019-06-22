class BB
{
  public static void main(String []args)
  {
	int x=10;
	int y=9;
	int m=x>y?x:y;
	int n=m;
	while(true)
	{
	  if(m%x==0 && m%y==0)
	  {
		System.out.println(m);
		break;
	  }
	  m+=n;
	}
  }
}