import java.awt.*;
import java.awt.event.*;
class AA extends Frame
{
 Button b1,b2;//event source
 public AA()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	b1=new Button("Red");
	b2=new Button("Green");
	add(b1);
	ColorListener listener=new ColorListener();
	b1.addActionListener(listener);//registration
	b2.addActionListener(listener);//registration
	add(b2);
	setVisible(true);
 } 
 class ColorListener implements ActionListener//listener class
 {
  public void actionPerformed(ActionEvent evt)
  {
     if(evt.getSource()==b1)	
	setBackground(Color.red);
     else if(evt.getSource()==b2)	
	setBackground(Color.green);
  }
 }
 public static void main(String args[])
 {
	new AA();
 }
}