import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class BB extends JFrame 
{
  JLabel la=new JLabel("CETPA Infotech");
  public BB()
  {
	super("Title");
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	Font fo=new Font("lucida calligraphy",Font.BOLD,20);
	la.setFont(fo);
	add(la);
	la.addMouseListener(new ColorListener());
   	setVisible(true);
  }
  class ColorListener extends MouseAdapter
  {
    public void mouseEntered(MouseEvent evt)
    {
	la.setForeground(Color.red);
    }
    public void mouseExited(MouseEvent evt)
    {
	la.setForeground(Color.black);
    }
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new BB();
  }
}












