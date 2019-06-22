class TableUser
{
  public static void main(String []args)
  {
	TableThread t1=new TableThread(34);
	TableThread t2=new TableThread(56);
	TableThread t3=new TableThread(23);
	t1.start();
	t2.start();
	t3.start();
  }
}