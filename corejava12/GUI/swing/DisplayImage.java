import java.awt.*;
import javax.swing.*;
import java.net.URL;
class DisplayImage extends JFrame
{
  public DisplayImage()
  {
	setSize(300,300);
	setLocationRelativeTo(null);
	URL obj=getClass().getResource("pics/india.gif");
	ImageIcon icon=new ImageIcon(obj);
	JLabel la=new JLabel(icon);
	add(la);
	setVisible(true);
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new DisplayImage();
  }
}