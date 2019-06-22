class Cal
{
  int x,y,z;
  static void set(int a,int b,Cal t)
  {
	t.x=a;
	t.y=b;
  }
  static void add(Cal t)
  {
	t.z=t.x+t.y;
	System.out.println(t.z);
  }
  static void multiply(Cal t)
  {
	t.z=t.x*t.y;
	System.out.println(t.z);
  }
  public static void main(String []args)
  {
	Cal obj=new Cal();
	set(80,40,obj);
	add(obj);
	multiply(obj);
  }
}