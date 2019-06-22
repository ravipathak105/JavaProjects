class Product
{
  private String name;
  private int price;
  public void storeData(String n,int p)
  {
	name=n;
	price=p;
  }
  public void showData()
  {
	System.out.println(name+"  "+price);
  }
  public static void main(String [] args)
  {
	Product p1,p2,p3,o1,o2,o3;
	o1=p1=new Product();
	o2=p2=new Product();
	o3=p3=new Product();
	p2=p1;
	p1.storeData("AAA",8000);
	p3=p2;
	p2.storeData("BBB",1000);
	p1=p3;
	p3.storeData("CCC",3000);
	o1.showData();
	o2.showData();
	o3.showData();
  }
}




























