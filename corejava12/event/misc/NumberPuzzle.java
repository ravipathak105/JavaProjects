import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class NumberPuzzle extends JFrame
{
  PuzzleButton [][]bt=new PuzzleButton[4][4];
  JPanel pa=new JPanel();
  PuzzleButton bb;
  JLabel la=new JLabel("No of clicks:0");
  int click=0;
  public NumberPuzzle()
  {
	super("Number puzlle");
	setSize(400,440);
	setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	la.setBounds(150,20,100,30);
	add(la);
	pa.setBounds(50,70,300,300);
	pa.setBorder(BorderFactory.createLineBorder(Color.red,4));
	add(pa);
	pa.setLayout(new GridLayout(4,4));	
	addButtons();
	setVisible(true);
  }
  private void addButtons()
  {
    String []str={"10","12","9","15","11","7","3","6","8","1","14","2","4","5","13",""}; 
    int c=-1;
    Font fo=new Font("magneto",Font.PLAIN,25);	
    PuzzleListener listener=new PuzzleListener();
    for(int i=0;i<4;i++)
    {
      for(int j=0;j<4;j++)
      {
	bt[i][j]=new PuzzleButton(str[++c],i,j);
	bt[i][j].setFont(fo);
	bt[i][j].setForeground(Color.blue);
	bt[i][j].addActionListener(listener);
	pa.add(bt[i][j]);
      }
    }
    bb=bt[3][3];    	
  }
  class PuzzleListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
	PuzzleButton cc=(PuzzleButton)evt.getSource();
	if((bb.r==cc.r && Math.abs(bb.c-cc.c)==1) || (bb.c==cc.c && Math.abs(bb.r-cc.r)==1))
	{
	  bb.setText(cc.getText());
	  cc.setText("");
	  bb=cc;
	  la.setText("No of clicks:"+(++click));
	}
    }
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new NumberPuzzle();
  }
}



