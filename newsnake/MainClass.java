import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class MainClass extends JFrame
{
  JLabel bg=new JLabel(new ImageIcon(getClass().getResource("images/home.jpg")));
  JButton bt=new JButton("Play",new ImageIcon(getClass().getResource("images/play.png")));
  JRadioButton []speed=new JRadioButton[3];
  public MainClass()
  {
	super("Snake");
	setSize(600,490);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	bg.setBounds(0,0,600,490);
	add(bg);
	bg.setLayout(null);
	bt.setBounds(230,270,90,35);
	bt.setMargin(new Insets(0,0,0,0));
	bt.setMnemonic('P');
	bg.add(bt);
	addSpeed();
        addKeyListener(new KL());
	bt.addActionListener(new ActionListener()
	{
	  public void actionPerformed(ActionEvent evt)
	  {
		startGame();
	  }
	});
	setVisible(true);
  }
  void startGame()
  {
	Va.username=JOptionPane.showInputDialog(this,"Enter your name:");
	if(Va.username==null || Va.username.equals(""))
	  Va.username="Anonymous user";
	setSpeed();
	Va.snake=new Snake();
	setVisible(false);
  } 
  void addSpeed()
  {	
    JLabel ch=new JLabel("--Choose Speed--");
    ch.setForeground(Color.cyan); 
    ch.setFont(Va.fo);
    ch.setBounds(200,40,200,30);	
    bg.add(ch);	
    JPanel pa=new JPanel();
    pa.setBounds(150,80,300,40);
    bg.add(pa);  
    pa.setBackground(Color.yellow);	
    pa.setOpaque(false);	
    String []str={"Slow","Medium","Fast"};	
    char []chh={'S','M','F'};	
    ButtonGroup gr=new ButtonGroup();		
    KL kl=new KL();
    for(int i=0;i<3;i++)
    {
	speed[i]=new JRadioButton(str[i]);
	gr.add(speed[i]);
        speed[i].addKeyListener(kl);
	speed[i].setFont(Va.fo);
	speed[i].setMnemonic(chh[i]);
        speed[i].setBackground(Color.yellow);	
	pa.add(speed[i]);
    }	
    speed[2].setSelected(true);	
  }
  void setSpeed()
  {
	for(int i=0;i<3;i++)
	{
	  if(speed[i].isSelected())
	  {
		Va.speedi=i;
		Va.speed=Va.speedinc[i][0];
		Va.speedchange=Va.scvalue[i];
		break;
	  }
	}
  }
  class KL extends KeyAdapter
  {
    public void keyPressed(KeyEvent evt)
    {
	if(evt.getKeyCode()==KeyEvent.VK_ENTER)
	{
	  startGame();
	}
    }	
  }
  public static void main(String args[])
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	Va.stsnake=new MainClass();
  }
}