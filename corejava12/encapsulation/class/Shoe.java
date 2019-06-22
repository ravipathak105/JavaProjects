class Shoe
{
  private String brand;
  private int price;
  private int size;
  private String color;
  public void storeData(String a1,int a2,int a3,String a4)
  {
	brand=a1;
	price=a2;
	size=a3;
	color=a4;
  }
  public void setSize(int s)
  {
	size=s;
  }
  public void setColor(String c)
  {
	color=c;
  }
  public void showData()
  {
	System.out.println("Brand is:"+brand);
	System.out.println("Price is:"+price);
	System.out.println("Size  is:"+size);
	System.out.println("Color is:"+color);
  }
}











