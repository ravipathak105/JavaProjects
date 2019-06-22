import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class NumberPuzzle extends JFrame
{
 JPanel pa=new JPanel();
 PButton [] bt=new PButton[16];
 JLabel la=new JLabel("Clicks:0");
 int []num=new int[16];
 JButton bb;int bi=15;
 public NumberPuzzle()
 {
	super("Number Puzzle");
	rn();
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	la.setBounds(200,10,100,30);
	add(la);
	pa.setBounds(50,50,300,300);
	pa.setBorder(BorderFactory.createLineBorder(Color.red,4));
	add(pa);
	pa.setLayout(new GridLayout(4,4));
	Font fo=new Font("magneto",1,25);
	PuzzleListener listener=new PuzzleListener();
	for(int i=0;i<bt.length;i++)
	{
	  bt[i]=new PButton(String.valueOf(num[i]));
	  bt[i].i=i;
	  bt[i].setForeground(Color.blue);
	  bt[i].setFont(fo);
	  bt[i].addActionListener(listener);
	  pa.add(bt[i]);
	}
	bt[15].setText("");
 	setVisible(true); 
 }
 class PuzzleListener implements ActionListener
 {
  public void actionPerformed(ActionEvent evt)
  {
	PButton bc=(PButton)evt.getSource();	
	int ci=bc.i;
	if(Math.abs(bi-ci)==4 || Math.abs(bi-ci)==1)
	{
	  bt[bi].setText(bc.getText());	
	  bc.setText("");
	  bi=ci;
	}
  } 	
 }
 void rn()
 {
	Random ra=new Random();
  	int i=-1;
	do
	{
	  int x=ra.nextInt(15)+1; 
	  int j=0;
	  for(;j<=i && x!=num[j];j++);
	  if(j>i)
	  {
		num[++i]=x;
		if(i==14)
		 break;
	  }
	}while(true);
 }
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new NumberPuzzle();
 }
}