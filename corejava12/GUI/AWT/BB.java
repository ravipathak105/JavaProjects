import java.awt.*;
import java.util.Random;
class BB
{
  Frame fr;
  Random ra=new Random();
  public BB()
  {
	fr=new Frame();
	fr.setSize(300,300);
	fr.setLocationRelativeTo(null);
	int r=ra.nextInt(256);
	int g=ra.nextInt(256);
	int b=ra.nextInt(256);
	fr.setBackground(new Color(r,g,b));
	fr.setVisible(true);
  }
  public static void main(String []args)
  {
	new BB();
  }
}