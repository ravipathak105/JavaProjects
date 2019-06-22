class Cal1
{
  int x,y,z;
  void set(int a,int b)
  {
	x=a;//this.x=a;
	y=b;//this.y=b;
  }
  void add()
  {
	z=x+y;//this.z=this.x+this.y
	System.out.println(this.z);
  }
  void multiply()
  {
	z=x*y;
	System.out.println(z);
  }
  public static void main(String []args)
  {
	Cal1 obj=new Cal1();
	obj.set(80,40);
	obj.add();
	obj.multiply();
  }
}