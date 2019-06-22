class Product
{
  String name;
  int price;
  public Product(String n,int p)
  {
	name=n;
	price=p;
  }
  Product(Product t)
  {	
	this.name=t.name;
	this.price=t.price;
  }
  public void show()
  {
	System.out.println(name+" "+price);
  }
  public static void main(String []args)
  {
	Product p1=new Product("AAA",8000);
	Product p2=new Product(p1);
	p2.show();
  }
}








