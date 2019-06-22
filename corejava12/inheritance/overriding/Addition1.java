class Addition1 extends Addition
{
  int z;
  public Addition1(int a,int b,int c)
  {
	super(a,b);
	z=c;
  }
  public void add()
  {
	super.add();
	res=x+y+z;
  }
  public static void main(String []args)
  {
	Addition1 obj=new Addition1(900,400,200);
	obj.add();
	obj.showResult();
  }
}



















