import java.awt.*;
import javax.swing.*;
class AA extends JFrame
{
  JButton bt;
  public AA()
  {
	super("Calculator");
	setSize(300,300);
	setLocationRelativeTo(null);
	//setDefaultCloseOperation(3);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	bt=new JButton("Submit");
	bt.setBounds(100,50,100,30);
	add(bt);
	setVisible(true);
  }
  public static void main(String []args)
  {
	new AA();
  }
}