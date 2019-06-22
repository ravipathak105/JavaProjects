import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame implements ActionListener
{
 JPanel pa=new JPanel();
 JButton [] bt=new JButton[20];
 JTextField tb=new JTextField("0");
 int num;
 String op="";
 int flag=0;  
 public Calculator()
 {
	super("Calculator");
	setSize(300,300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	addTextBox();
	addButtons();
	setVisible(true); 
 }
 private void addTextBox()
 {
	tb.setBounds(10,10,270,50);
	tb.setEditable(false);
	tb.setBackground(Color.white);
	tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
	tb.setFont(new Font("Arial",0,25));
	tb.setHorizontalAlignment(JTextField.RIGHT);
	add(tb);
 } 
 private void addButtons()
 {
	pa.setBounds(10,75,270,180);	
	add(pa);
	pa.setLayout(new GridLayout(5,4,5,5));
	String []str={"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	Font fo=new Font("Latin",0,18);
	Insets ins=new Insets(0,0,0,0);
	for(int i=0;i<bt.length;i++)
	{
	  bt[i]=new JButton(str[i]);
	  bt[i].addActionListener(this);
	  bt[i].setFont(fo);
	  bt[i].setMargin(ins);
	  bt[i].setForeground(Color.blue);
	  if(i==3 || i==7 || i==11 || i==15 || i==19 || i==18)
	    bt[i].setForeground(Color.red);
	  pa.add(bt[i]);
	}
 }
 public void actionPerformed(ActionEvent evt)
 {
	JButton bc=(JButton)evt.getSource();  	
	String x=bc.getText();
	String y=tb.getText();
	if(x.equals("+") ||x.equals("-") ||x.equals("*") ||x.equals("/"))
	{
	  num=Integer.parseInt(y);
	  flag=1;
	  op=x;
	}
   	if(x.equals("="))
	{
	  if(op.equals("+"))
	  {
		tb.setText(String.valueOf(num+Integer.parseInt(y)));
	  }
	}
	if(bc==bt[4]||bc==bt[5]||bc==bt[6]||bc==bt[8]||bc==bt[9]||bc==bt[10]||bc==bt[12]||bc==bt[13]||bc==bt[14]||bc==bt[16])
	{
	  if(y.equals("0") || flag==1) 
	  {
	    tb.setText(x);
	    flag=0;
	  }
	  else
	    tb.setText(y+x);
	}
 }
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Calculator();
 }
}







