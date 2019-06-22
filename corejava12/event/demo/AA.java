class AA
{
  Button b1=new Button();
  public AA()
  {
	b1.addActionListener(new BB());
	b1.clickEvent();	
  }
  class BB implements ActionListener
  {
    public void actionPerformed(int num)
    {
	System.out.println("Event handling example");
    }	
  }
  public static void main(String ...s)
  {
	new AA();
  }
}