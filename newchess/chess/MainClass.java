import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class MainClass extends JFrame
{
  HighlightBox box=new HighlightBox();
  public MainClass()
  {
	super("Chess");
	Va.chess=this;
	setSize(700,620);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);	
	setLayout(null);
	getContentPane().setBackground(new Color(150,100,0));
	Va.board.setBounds(100,45,500,500);
	Va.board.setBorder(BorderFactory.createLineBorder(Color.red,3));
	add(Va.board);
	Va.board.setLayout(new GridLayout(8,8));
	addBoard();
	addPanel();
	setVisible(true);
  }
  void addBoard()
  {
	int x=0;
	Color black=new Color(150,150,255);
        ElementClickListener listener=new ElementClickListener();
	for(int i=0;i<Va.elementlist.length;i++)
	{
	  Va.elementlist[i]=new ArrayList<MButton>();
	}
	for(int i=0;i<8;i++)
	{
	  for(int j=0;j<8;j++)
	  {
		Va.bt[i][j]=new MButton();
	        if(i==0 || i==1)
	 	  Va.elementlist[1].add(Va.bt[i][j]);
	        else if(i==6 || i==7)
	 	  Va.elementlist[0].add(Va.bt[i][j]);
		Va.bt[i][j].setOpaque(true);
		Va.bt[i][j].setBorder(Va.blackb);
		Va.bt[i][j].setHorizontalAlignment(MButton.CENTER);
		Va.bt[i][j].r=i;Va.bt[i][j].c=j;
		Va.bt[i][j].addActionListener(listener);
		if(j%2==x)
		  Va.bt[i][j].setBackground(Color.white);
		else
		  Va.bt[i][j].setBackground(black);
	        Va.board.add(Va.bt[i][j]);
	  }
	  x=1-x;
	}
	Va.kp[0]=Va.bt[7][4];
	Va.kp[1]=Va.bt[0][4];
	arrangeElements();
	setPosition();
	playerTurn();
  }
  void playerTurn()
  {
	JPanel []msgpa=new JPanel[2];
	int y=550;
	Color [] col={Color.white,new Color(150,150,255)};
	for(int i=0;i<2;i++)
	{
	  msgpa[i]=new JPanel();
	  msgpa[i].setBounds(100,y,500,30);
	  msgpa[i].setBackground(col[i]);
	  add(msgpa[i]);
	  Va.lblturn[i]=new JLabel();
	  Va.lblturn[i].setForeground(Color.black);
	  Va.lblturn[i].setFont(Va.fo);
	  msgpa[i].add(Va.lblturn[i]);
	  y-=545;
	}
	Va.lblturn[0].setText("It's your turn...");
  }
  void arrangeElements()
  {
	for(int i=0;i<8;i++)
	{
	  Va.bt[0][i].setIcon(new ImageIcon(getClass().getResource("images/b"+i+".gif")));
	  Va.bt[0][i].pi=1;
	  Va.bt[7][i].setIcon(new ImageIcon(getClass().getResource("images/w"+i+".gif")));
	  Va.bt[7][i].pi=0;
	}
	for(int i=0;i<8;i++)
	{
	  Va.bt[1][i].setIcon(new ImageIcon(getClass().getResource("images/bp.gif")));
	  Va.bt[1][i].pi=1;
	  Va.bt[1][i].ei=6;
	  Va.bt[6][i].setIcon(new ImageIcon(getClass().getResource("images/wp.gif")));
	  Va.bt[6][i].pi=0;
	  Va.bt[6][i].ei=6;
	}
  }
  void setPosition()
  {
	for(int i=0;i<2;i++)
	{
	  i=i==0?0:7;
	  Va.bt[i][0].ei=1;Va.bt[i][7].ei=1;Va.bt[i][1].ei=2;Va.bt[i][6].ei=2;
	  Va.bt[i][2].ei=3;Va.bt[i][5].ei=3;Va.bt[i][3].ei=4;Va.bt[i][4].ei=5;
	}
	
  }
  void addPanel()
  {
	Va.left.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
	Va.right.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
    	Va.left.setBounds(20,45,50,500);	
    	Va.right.setBounds(625,45,50,500);	
	Va.left.setBackground(new Color(150,150,255));
	Va.right.setBackground(Color.white);	
	add(Va.left);add(Va.right);
  }
  public static void main(String args[])
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	Va.chess=new MainClass();
  }
}