import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class NumberPuzzle extends JFrame
{
 JPanel pa=new JPanel();
 PButton [][] bt=new PButton[4][4];
 PButton bb;
 int []num=new int[16];
 public NumberPuzzle()
 {
	super("Number Puzzle");
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	pa.setBounds(50,30,300,300);
	pa.setBackground(Color.yellow);
	pa.setBorder(BorderFactory.createLineBorder(Color.red,2));
	add(pa);
	pa.setLayout(new GridLayout(4,4));
	ra();
	addButtons();
	setVisible(true); 
 }
 void addButtons()
 {
   Font fo=new Font("lucida calligraphy",0,25);	
   PuzzleListener listener=new PuzzleListener();	
   int k=-1;
   for(int i=0;i<4;i++)
   {
      for(int j=0;j<4;j++) 
      {
	bt[i][j]=new PButton(String.valueOf(num[++k]),i,j);
	bt[i][j].addActionListener(listener);
	bt[i][j].setForeground(Color.blue);
	bt[i][j].setFont(fo);
	pa.add(bt[i][j]);
      } 	
   }	
   bt[3][3].setText("");
   bb=bt[3][3];
 }  
 class PuzzleListener implements ActionListener
 {
   public void actionPerformed(ActionEvent evt)
   {
	PButton bc=(PButton)evt.getSource();
	if((bc.r==bb.r && Math.abs(bc.c-bb.c)==1) || (bc.c==bb.c && Math.abs(bc.r-bb.r)==1))
	{
	  bb.setText(bc.getText());
	  bc.setText("");
	  bb=bc;
	}
   }	
 } 
 void ra()
 {
   Random ra=new Random();
   boolean [] available=new boolean[16];
   int i=-1;
   do
   {
     int n=ra.nextInt(15);
     if(!available[n]) 		
     {
	num[++i]=n+1;
	available[n]=true;
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
