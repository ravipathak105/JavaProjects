import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class BB extends JFrame 
{
  JButton b1=new JButton("Red");
  JButton b2=new JButton("Blue");
  public BB()
  {
	super("Title");
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	add(b1);
	add(b2);
   	b1.addActionListener(new RedListener());//Registration
   	b2.addActionListener(new GreenListener());//Registration
   	setVisible(true);
  }
  class RedListener implements ActionListener//Event listener
  {
    public void actionPerformed(ActionEvent evt)
    {
	Container con=getContentPane();
	con.setBackground(Color.red);
    }
  }
  class GreenListener implements ActionListener//Event listener
  {
    public void actionPerformed(ActionEvent evt)
    {
	getContentPane().setBackground(Color.green);
    }
  }
  public static void main(String []args)
  {
	new BB();
  }
}