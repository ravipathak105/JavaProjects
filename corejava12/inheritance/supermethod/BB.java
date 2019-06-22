class AA
{
  int x,y,z;
  public AA(){}
  public AA(int a,int b,int c)
  {
	x=a;
	y=b;
	z=c;
  }
}
class BB extends AA
{
  char ch;
  String str;
  public BB(char a1,String a2)
  {
	ch=a1;
	str=a2;
  }
  public BB(int a1,int a2,int a3,char a4,String a5)
  {
	ch=a4;
	str=a5;
  }
  public static void main(String [] args)
  {
	new BB(90,40,30,'h',"Cetpa");
	new BB('h',"Cetpa");
  }
}





