import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame
{
 JTextField tb=new JTextField("0");
 JPanel pa=new JPanel();
 JButton [] bt=new JButton[20]; 
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
	add(tb);
	tb.setEditable(false);
	tb.setBackground(Color.white);
	tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
	tb.setHorizontalAlignment(JTextField.RIGHT);
	tb.setFont(new Font("arial",Font.PLAIN,20));
 }  
 private void addButtons()
 {
	pa.setBounds(10,70,270,180);
	add(pa);
	pa.setLayout(new GridLayout(5,4,5,5));
	String []str={"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	Font fo=new Font("arial",0,20);
	Insets ins=new Insets(0,0,0,0);
	CalListener listener=new CalListener();
	for(int i=0;i<20;i++)
	{
	  bt[i]=new JButton(str[i]);
	  bt[i].addActionListener(listener);
	  bt[i].setFont(fo);
	  bt[i].setMargin(ins);
	  bt[i].setForeground(Color.blue);
	  if(i==3 ||i==7|| i==11|| i==15 || i==19 || i==18)
	    bt[i].setForeground(Color.red);
	  pa.add(bt[i]);
	}
 } 
 class CalListener implements ActionListener
 {
   boolean operation=false;
   String op="";
   int num;
   public void actionPerformed(ActionEvent evt)
   {
	JButton bc=(JButton)evt.getSource();
	String b1=bc.getText();
	String t1=tb.getText();
	if(b1.equals("+")||b1.equals("-")||b1.equals("*")||b1.equals("/"))
	{
	  operation=true;
	  op=b1;  
	  num=Integer.parseInt(t1);
	}
	if(bc==bt[4]|bc==bt[5]||bc==bt[6]||bc==bt[8]||bc==bt[9]||bc==bt[10]||bc==bt[12]||bc==bt[13]||bc==bt[14]||bc==bt[16])
	{
	  if(t1.equals("0") || operation)
	  {
	    tb.setText(b1);
	    operation=false;
	  }
	  else
	    tb.setText(t1+b1);
	}
  	if(bc==bt[18])//== button
	{
	  if(op.equals("+"))
	    tb.setText(String.valueOf(num+Integer.parseInt(t1)));
	  if(op.equals("/"))
	    tb.setText(String.valueOf(num/Float.parseFloat(t1)));
	}
	if(bc==bt[0])//Back button
	{
	  if(!t1.equals("0"))
	  {
	     if(t1.length()==1)
	     {
		tb.setText("0");
		return;
	     }  	
	     t1=t1.substring(0,t1.length()-1);
	     tb.setText(t1);	
	  }
	}
        if(bc==bt[1])//CE button
	{
	  tb.setText("0");
	}
   }	
 }   
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Calculator();
 }
}







