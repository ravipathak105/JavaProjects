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
	ColorListener listener=new ColorListener();
   	b1.addActionListener(listener);
   	b2.addActionListener(listener);
   	setVisible(true);
  }
  class ColorListener implements ActionListener//Event listener
  {
    public void actionPerformed(ActionEvent evt)
    {
      if(evt.getSource()==b1) 	
	getContentPane().setBackground(Color.red);
      if(evt.getSource()==b2)
	getContentPane().setBackground(Color.green);
    }
  }
  public static void main(String []args)
  {
	new BB();
  }
}









