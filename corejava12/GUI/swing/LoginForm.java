import java.awt.*;
import javax.swing.*;
class LoginForm extends JFrame
{
  JLabel luid,lpass;
  JTextField tuid;
  JPasswordField tpass;
  JCheckBox cb;
  JButton bt;
  JLabel bg;
  public LoginForm()
  {
	super("Login Form");
	setSize(300,300);
	setLocationRelativeTo(null);
	setImage();
	luid=new JLabel("Enter user id:");
	luid.setForeground(Color.blue);
	luid.setBounds(30,20,100,30);
	bg.add(luid);
	lpass=new JLabel("Enter password:");
	lpass.setBounds(30,70,100,30);
	bg.add(lpass);

	tuid=new JTextField();
	tuid.setBounds(130,20,150,30);
	bg.add(tuid);
	tpass=new JPasswordField();
	tpass.setBounds(130,70,150,30);
	bg.add(tpass);

	cb=new JCheckBox("Keep me signed in...");
	cb.setMnemonic('K');
	cb.setBounds(20,140,200,30);
	bg.add(cb);

	bt=new JButton("Login");
	bt.setMnemonic('L');
	bt.setBounds(200,190,80,30);
	bg.add(bt);
	setVisible(true);
  }
  void setImage()
  {
	bg=new JLabel(new ImageIcon(getClass().getResource("pics/india.gif")));
	add(bg);
	bg.setLayout(null);
  }
  public static void main(String []args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new LoginForm();
  }
}