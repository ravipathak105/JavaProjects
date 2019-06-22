class Product
{
  String name;
  int price;
  public Product(String n,int p)
  {
	name=n;
	price=p;
  }
  public void show()
  {
	System.out.println(name+" "+price);
  }
  public static void main(String []args)
  {
	Product p1=new Product("AAA",8000)
	p1.show();
  }
}