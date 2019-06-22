class Display
{
  public static void main(String []args)
  {
	String []name={"Atul","Amit","Rahul","Suman","Alok","Hemant"};
	for(int i=0;i<name.length;i++)
	{
	  char ch=name[i].charAt(name[i].length()-1);
	  if(ch=='T' || ch=='t')
	    System.out.println(name[i]);
	}
  }
}