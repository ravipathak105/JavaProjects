import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class PicPuzzle1 extends JFrame
{
  JButton []bt=new JButton[10];
  JPanel pb=new JPanel();
  PicPuzzle1()
  {
    	super("Pic puzzle by Rehan Ahmad");
	setLayout(null);
	setSize(600,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	pb.setBorder(BorderFactory.createLineBorder(Color.red,3));	
	pb.setBounds(10,120,285,286);
	add(pb);
	pb.setLayout(new GridLayout(3,3));
	PuzzleListener listener=new PuzzleListener();
	for(int i=0;i<9;i++)
	{
	  bt[i]=new JButton(new ImageIcon(getClass().getResource("images/"+i+".jpg")));
	  bt[i].addActionListener(listener);
	  pb.add(bt[i]);
	}
	addSample();
	addInstruction();
	setVisible(true);
  }
  private void addSample()
  {
	JLabel sample=new JLabel("<html><h2>Sample</h2></html>");
	sample.setBounds(450,120,100,30);
	add(sample);
	bt[9]=new JButton(new ImageIcon(getClass().getResource("images/main.jpg")));
	bt[9].setBounds(380,150,200,200);
	add(bt[9]);
  }
  private void addInstruction()
  {
	JLabel note=new JLabel("<html><font color='red'>NOTE:</font> <b>Icon has power to swap with neighbour icon==></b></html>");
	note.setBounds(10,30,320,30);
	add(note);
	JLabel noteimg=new JLabel(new ImageIcon(getClass().getResource("images/note.jpg")));
	noteimg.setBounds(330,20,41,41);
	add(noteimg);
  }
  class PuzzleListener implements ActionListener
  {
   int bi=3;
   public void actionPerformed(ActionEvent evt)
   {
	JButton bc=(JButton)evt.getSource();
	int ci=0;
	for(;bt[ci]!=bc;ci++);
	if(bi-ci==1 || bi-ci==-1 || bi-ci==3 || bi-ci==-3)
	{
	  Icon ic=bt[bi].getIcon();
	  bt[bi].setIcon(bc.getIcon());
	  bc.setIcon(ic);
	  bi=ci;
	}
   }
  }
  public static void main(String args[])
  {
	new PicPuzzle1();
  }
}