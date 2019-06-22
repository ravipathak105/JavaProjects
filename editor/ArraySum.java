import java.util.Scanner;
class ArraySum
{
  public static void main(String[]args)
  {
  	int arr[]=new int [5];
  	System.out.println("Enter Elements of Array");
  	Scanner sc=new Scanner(System.in);
  	
  	for(int i=0;i<arr.length;i++)
  	{
        arr[i]=sc.nextInt();
  	}
  	for(int x:arr)
  	{
      System.out.println(x);
  	}
  }


}