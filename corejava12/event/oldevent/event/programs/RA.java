import java.util.Random;
class RA
{
 public static void main(String args[])
 {
	int [] num=new int[15];
	Random ra=new Random();
  	int i=-1;
	do
	{
	  int x=ra.nextInt(15)+1; 
	  int j=0;
	  for(;j<=i && x!=num[j];j++);
	  if(j>i)
	  {
		System.out.println(x);
		num[++i]=x;
		if(i==14)
		 break;
	  }
	}while(true);
 }
}