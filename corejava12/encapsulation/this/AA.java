class AA
{
  int x;
  void set(int a)
  {
	x=a;
  }
  void show(AA t1)
  {
	t1.disp(this);
  }
  void disp(AA t2)
  {
	System.out.println(t2.x);
	System.out.println(this.x);
  }
  public static void main(String []args)
  {
	AA obj1=new AA();
	AA obj2=new AA();
	obj1.set(20);
	obj2.set(90);
	obj1.show(obj2);
	
  }
}

