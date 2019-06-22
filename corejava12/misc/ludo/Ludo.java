import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class Ludo extends JFrame
{
  JLabel board=new JLabel(new ImageIcon(getClass().getResource("pics/ludoking.png")));
  public Ludo()
  {
	super("Snake");
	setSize(550,550);
	setLocationRelativeTo(null);
	setLayout(null);
	board.setBounds(61,100,378,378);
	board.setLayout(null);
	add(board);
	addGoti();
	addDice();
	addArrow();
	setVisible(true);
  }	
  void addGoti()
  {
    for(int i=0;i<4;i++)
    {		
     for(int j=0;j<4;j++)
     {	   	
       Va.goti[i][j]=new JLabel(new ImageIcon(getClass().getResource("pics/p"+(i+1)+".png")));
       Va.goti[i][j].setBounds(Va.gotix[i][j],Va.gotiy[i][j],26,36);	
       board.add(Va.goti[i][j]);	
     }	
    }
  }
  void addDice()
  {
	Va.dice=new JButton(new ImageIcon(getClass().getResource("pics/dice0.jfif")));
	Va.dice.setBounds(61,20,70,65);
	add(Va.dice);
	Va.dice.addActionListener(new DiceListener());
  }
  void addArrow()
  {
	Va.arrow=new JLabel(new ImageIcon(getClass().getResource("pics/a1.png")));
	Va.arrow.setBounds(200,40,61,30);
	add(Va.arrow);
	new ArrowThread().start();
  }
  public static void main(String []args)
  {
	setDefaultLookAndFeelDecorated(true);
	new Ludo();
  }
}











