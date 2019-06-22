abstract class Cal
{
  int num1,num2,res;
  public Cal(int n1,int n2)
  {
	num1=n1;
	num2=n2;
  }
  abstract void performTask();
  void showResult()
  {
	System.out.println(res);
  }
}