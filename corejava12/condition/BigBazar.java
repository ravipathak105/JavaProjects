class BigBazar
{
  static void findDiscount(int amount)
  {
	double discount=0.0;
	if(amount>=5000)
	  discount=amount*.15;
	else if(amount>=3000)
	  discount=amount*.10;
	else if(amount>=1000)
	  discount=amount*.05;
	System.out.println(discount);
  }
  public static void main(String [] args)
  {
	findDiscount(2000);
  }
}





