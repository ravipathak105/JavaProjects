import javax.swing.*;
import java.awt.*;
class AA extends JFrame
{
  Graphics g;
  public AA()
  {
	setSize(500,500);
	setLocationRelativeTo(null);
	setVisible(true);
  }
  public void paint(Graphics g)
  {
	this.g=g;
	g.drawRect(30,60,400,400);
	drawBox(30,60,Color.red);
	drawBox(280,60,Color.green);
	drawBox(30,310,Color.blue);
	drawBox(280,310,Color.yellow);
  }
  void drawBox(int x,int y,Color col)
  {
	g.setColor(col);
	g.fillRect(x,y,150,150);
	g.setColor(Color.white);
	g.fillRect(x+25,y+25,100,100);
  }
  public static void main(String []args)
  {
	new AA();
  }
}