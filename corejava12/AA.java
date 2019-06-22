import java.util.Random;
class AA
{
 public static void main(String []args)
 {
	Random ra=new Random();
	int num=ra.nextInt(6)+1;
	if(num!=6)
	{
	  int n=ra.nextInt(4);
	  if(n==2)
	  {
		num=6;
	  }  	 	
        }
	System.out.println(num);
  }
}