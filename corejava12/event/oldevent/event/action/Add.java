import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Add extends JFrame
{
 JButton b1=new JButton("Add Numbers");
 JTextField t1=new JTextField();
 JTextField t2=new JTextField();
 JLabel lres=new JLabel("Result");
 public Add()
 {
	setSize(300,300);
	setLocationRelativeTo(null);
	setLayout(null);
	t1.setBounds(50,30,80,30);
	add(t1);
	t2.setBounds(150,30,80,30);
	add(t2);
	lres.setBounds(100,100,120,30);
	lres.setFont(new Font("magneto",0,20));
	add(lres);
	b1.setMnemonic('A');
	b1.setBounds(90,180,120,30);
	add(b1);
	b1.addActionListener(new AddListener());
	getContentPane().setBackground(new Color(150,200,255));
	setVisible(true);
 }
 class AddListener implements ActionListener
 {
  public void actionPerformed(ActionEvent evt)
  {
	int n1=0,n2=0;
	String x=t1.getText();
	String y=t2.getText();
	if(x.equals("")||y.equals(""))
	{
	  JOptionPane.showMessageDialog(Add.this,"None of the field can be blank");
	  return;//it terminates execution of method
	}
	n1=Integer.parseInt(x);
	n2=Integer.parseInt(y);
	int z=n1+n2;
	lres.setText(String.valueOf(z));
  }
 }
 public static void main(String args[])
 {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Add();
 }
}