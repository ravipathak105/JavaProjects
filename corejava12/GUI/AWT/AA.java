import java.awt.*;
class AA 
{
  Frame fr;
  public AA()
  {
	fr=new Frame();
	fr.setSize(300,300);
	//fr.setLocation(100,50);
	fr.setLocationRelativeTo(null);
	fr.setResizable(false);
	fr.setBackground(Color.red);
	fr.setVisible(true);
  }
  public static void main(String []args)
  {
	new AA();
  }
}