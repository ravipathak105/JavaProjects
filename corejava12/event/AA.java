import java.awt.*;
import java.awt.event.*;
class AA extends Frame 
{
  Button b1=new Button("Red");//Event source
  Button b2=new Button("Blue");//Event source
  public AA()
  {
	super("Title");
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	add(b1);
	add(b2);
   	//b1.addActionListener(new RedListener());//Registration
   	b2.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent evt)
	    {
		setBackground(Color.blue);
	    }
	});
	setVisible(true);
  }
  class RedListener implements ActionListener//Event listener
  {
    public void actionPerformed(ActionEvent evt)
    {
	setBackground(Color.red);
    }
  }
  public static void main(String []args)
  {
	new AA();
  }
}