import java.awt.*;
import javax.swing.*;
class SnakeHome extends JFrame
{
  JLabel la;
  JButton bt;
  public SnakeHome()
  {
	setSize(600,490);
	setLocationRelativeTo(null);
	setResizable(false);
ImageIcon icon=new ImageIcon(getClass().getResource("pics/home.jpg"));
	la=new JLabel(icon);
	add(la);
	la.setLayout(null);
ImageIcon icon1=new ImageIcon(getClass().getResource("pics/bt.png"));
	bt=new JButton("Play",icon1);
	bt.setMargin(new Insets(0,0,0,0));
	bt.setBounds(200,100,80,40);
	la.add(bt);
	setVisible(true);
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new SnakeHome();
  }
}