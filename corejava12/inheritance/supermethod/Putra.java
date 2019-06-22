class Dada
{
  int amount=8000; 
}
class Pita extends Dada
{
  int amount=300000;
}
class Putra extends Pita
{
  int amount=1000;
  void showAmount()
  {
	System.out.println(this.amount);
	System.out.println(super.amount);
	System.out.println(((Pita)this).amount);
	System.out.println(((Dada)this).amount);
  }
  public static void main(String []args)
  {
	new Putra().showAmount();
  }
}