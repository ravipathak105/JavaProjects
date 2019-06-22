class AA
{
  public static void main(String []args)
  {
	int x=10;
	int y=4;
	int s=x<y?x:y;
	while(s>=1)
	{
	  if(x%s==0 && y%s==0)
	  {
		System.out.println(s);
		break;
	  }
          s--; 
	}
  }
}