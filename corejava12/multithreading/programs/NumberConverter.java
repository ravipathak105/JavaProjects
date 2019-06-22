import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class NumberConverter extends JFrame
{
 JTextField tb=new JTextField(15);
 JPanel p1=new JPanel();
 JPanel p2=new JPanel();  
 JLabel la=new JLabel("result");
 Font fo=new Font("arial",0,20);	
 public NumberConverter()
 {
	setSize(350,300);
	setLocationRelativeTo(null);
	add(p1,"North");
	p1.add(tb);
	add(p2,"South");
	p2.setLayout(new BorderLayout());
	la.setHorizontalAlignment(JLabel.CENTER);
	p2.add(la);
	tb.addKeyListener(new HtmlListener());
	tb.setFont(fo);
	la.setFont(fo);
	la.setForeground(Color.blue);
	setVisible(true);
 }
 class HtmlListener extends KeyAdapter
 {
  String [] x={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
  String [] y={"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
  String res="";
  public void keyReleased(KeyEvent evt)	
  {
	res="";
	String str=tb.getText();
	if(str.equals(""))
	{
	 la.setText(""); 
	 return;
	}
	int num=Integer.parseInt(str);
	if(num>=10000000 && num<=999999999)
	{
	  convert(num/10000000);
	  res=res+" crore ";
	  convert(num%10000000);
	}
	else
	 convert(num);
	la.setText("<html><p style='word-warp:break-word'>"+res+"</html><p>");
  }
  void convert(int num)
  {
	if(num>=1 && num<=19)
	  res=res+x[num];
	else if(num>=20 && num<=99)
	  res=res+(y[num/10]+" "+x[num%10]);
	if(num>=100 && num<=999)
	{
	  convert(num/100);
	  res=res+" hundred ";
	  convert(num%100);
	}
	if(num>=1000 && num<=99999)
	{
	  convert(num/1000);
	  res=res+" thousand ";
	  convert(num%1000);
	}
	if(num>=100000 && num<=9999999)
	{
	  convert(num/100000);
	  res=res+" lakh ";
	  convert(num%100000);
	}
  }
 }
 public static void main(String ...s)
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new NumberConverter();
 }
}

