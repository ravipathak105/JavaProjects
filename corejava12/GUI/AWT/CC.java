import java.awt.*;
import java.util.Random;
class CC extends Frame
{
  Random ra=new Random();
  public CC()
  {
	super("Calculator");
	setSize(300,300);
	setLocationRelativeTo(null);
	int r=ra.nextInt(256);
	int g=ra.nextInt(256);
	int b=ra.nextInt(256);
	setBackground(new Color(r,g,b));
	setVisible(true);
  }
  public static void main(String []args)
  {
	new CC();
  }
}