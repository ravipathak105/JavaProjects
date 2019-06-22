import java.util.Scanner;
class Factorial
{
	static int x,fact=0;
	public static void main(String...args)
	{
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Number to find Factorial");
		x=s.nextInt();

		for(int i=0;i<=x;i++)
		{
			if(x==0)
		{
			fact=1;
		}
			fact=fact*i;
		}
		System.out.println(fact);


	}
}