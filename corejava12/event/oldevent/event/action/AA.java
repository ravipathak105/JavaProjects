import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AA extends JFrame
{
 JButton b1=new JButton("Set Background");
 JLabel la;
 public AA()
 {
	setSize(400,400);
	la=new JLabel();
	add(la);
	la.setLayout(new FlowLayout());
	la.add(b1);
	b1.addActionListener(new ImgListener());
	setVisible(true);
 }
 class ImgListener implements ActionListener
 {
  public void actionPerformed(ActionEvent evt)
  {
	la.setIcon(new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/Tulips.jpg"));
  }
 }
 public static void main(String args[])
 {
	new AA();
 }
}