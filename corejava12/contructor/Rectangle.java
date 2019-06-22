class Rectangle
{
  int length;
  int breadth;
  Rectangle(int x,int y)
  {
	length=x;
	breadth=y;
	System.out.println("Constructor executed");
  }
  void showArea()
  {
	int area=length*breadth;
	System.out.println("Area of rectangle:"+area);
  }
  public static void main(String []args)
  {
	Rectangle r=new Rectangle(30,50);
	r.showArea();
  }
}