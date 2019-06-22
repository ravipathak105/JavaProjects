class DD
{
  public static void main(String []args)
  {
    /*Product p1,p2,p3,p4;
    p1=new Product("AAA",900);	
    p2=new Product("BBB",100);
    p3=new Product("CCC",400);
    p4=new Product("DDD",600);*/

    Product [] pb={new Product("AAA",900),new Product("BBB",100),new Product("CCC",400),new Product("DDD",600)};	
    for(int i=0;i<pb.length;i++)
    {
	pb[i].showData();
    } 	  
  }
}