import java.awt.*;
class AA extends Frame
{
  Button bt;
  public AA()
  {
	super("Calculator");
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(null);
	bt=new Button("Submit");
	bt.setBounds(100,50,100,30);
	add(bt);
	setVisible(true);
  }
  public static void main(String []args)
  {
	new AA();
  }
}