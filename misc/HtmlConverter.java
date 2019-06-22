import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class HtmlConverter extends JFrame
{
 JTextArea ta=new JTextArea();
 JPanel p1=new JPanel();
 JPanel p2=new JPanel();  
 JLabel la=new JLabel();	
 public HtmlConverter()
 {
	setSize(700,500);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout());
	p1.setBorder(BorderFactory.createLineBorder(Color.red,2));
	p2.setBorder(BorderFactory.createLineBorder(Color.blue,2));
	p1.setPreferredSize(new Dimension(320,450));
	add(p1);
	p2.setPreferredSize(new Dimension(320,450));
	add(p2);
	p1.setLayout(new BorderLayout());
	p2.setLayout(new BorderLayout());
	JScrollPane ps=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	p1.add(ps);
	p2.add(la);
	ta.setFont(new Font("arial",0,18));
	ta.addKeyListener(new HtmlListener());
	setVisible(true);
 }
 class HtmlListener extends KeyAdapter
 {
  public void keyPressed(KeyEvent evt)	
  {
	la.setText(ta.getText());
  }
 }
 public static void main(String ...s)
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new HtmlConverter();
 }
}