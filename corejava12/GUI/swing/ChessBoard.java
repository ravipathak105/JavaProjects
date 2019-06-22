import java.awt.*;
import javax.swing.*;
class ChessBoard extends JFrame
{
  JButton [][]bt=new JButton[8][8];
  JPanel pa=new JPanel();
  public ChessBoard()
  {
	setSize(800,600);
	setLocationRelativeTo(null);
	setResizable(false);
	setLayout(null);
	pa.setBounds(90,40,600,500);
	add(pa);
	pa.setLayout(new GridLayout(8,8));
	addButtons();
	setImage();
	setVisible(true);
  }
  void addButtons()
  {
    int c=0; 
    for(int i=0;i<8;i++)
    {
	for(int j=0;j<8;j++)
	{
	  bt[i][j]=new JButton();
	  if(j%2==c)
	    bt[i][j].setBackground(Color.white);
	  else
	    bt[i][j].setBackground(new Color(100,100,255));
	  pa.add(bt[i][j]);	
	}
        c=1-c;
    } 	
  }
  void setImage()
  {
     for(int i=0;i<8;i++)
     {
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/b"+i+".gif"));
	bt[0][i].setIcon(icon1);
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/bp.gif"));
	bt[1][i].setIcon(icon2);
	ImageIcon icon3=new ImageIcon(getClass().getResource("images/w"+i+".gif"));
	bt[7][i].setIcon(icon3);
	ImageIcon icon4=new ImageIcon(getClass().getResource("images/wp.gif"));
	bt[6][i].setIcon(icon4);
	bt[5][0].setIcon(bt[6][0].getIcon());
	//bt[6][0].setIcon(null);
     } 		
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new ChessBoard();
  }
}