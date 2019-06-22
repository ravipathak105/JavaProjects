import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Registration extends JFrame
{
  JLabel la[]=new JLabel[6];
  JPanel pa=new JPanel();
  TextField [] tf=new TextField[6];
  JButton bt1=new JButton("Register me");
  JButton bt2=new JButton("Close Form");
  public Registration()
  {
	super("Registration Form");
	setSize(600,550);
	setLocationRelativeTo(null);
	setLayout(null);
	pa.setBounds(80,50,420,400);
	add(pa);
	pa.setBackground(Color.yellow);
	pa.setLayout(null);
	pa.setBorder(BorderFactory.createLineBorder(Color.red,4));
	String [] str={"First name","Last name","User id","Password","Retype password","Phone number"};
	int y=30;
	Font fo=new Font("arial",0,20);
	Font fo1=new Font("arial",0,18);
	for(int i=0;i<la.length;i++)
	{
	  la[i]=new JLabel(str[i]);
	  la[i].setBounds(30,y,170,30);
	  la[i].setFont(fo);
	  la[i].setForeground(Color.blue);
	  pa.add(la[i]);
  	  tf[i]=new TextField();
	  tf[i].setBounds(200,y,200,30);
	  tf[i].setFont(fo1);
	  pa.add(tf[i]);
	  y+=50;
	}
	tf[3].setEchoChar('*');
	tf[4].setEchoChar('*');
	bt1.setBounds(80,340,130,30);
 	pa.add(bt1);
	RegisterListener listener=new RegisterListener();
	bt1.addActionListener(listener);
	bt2.setBounds(220,340,130,30);
 	pa.add(bt2);
	bt2.addActionListener(listener);
	setVisible(true);
  } 
  class RegisterListener implements ActionListener
  {
     public void actionPerformed(ActionEvent evt)
     {
	if(evt.getSource()==bt2)
	{
	  setVisible(false);
	  return;	
	}
	for(int i=0;i<tf.length;i++)
	{
	  if(tf[i].getText().equals(""))
	  {
		JOptionPane.showMessageDialog(Registration.this,"None of the field can be left blank");
		return;
	  }
	}
	if(!tf[4].getText().equals(tf[3].getText()))
	{
		JOptionPane.showMessageDialog(Registration.this,"Retype password does not match with password");
		return;
	}
	if(isFound())
	{
  	   JOptionPane.showMessageDialog(Registration.this,"Sorry!!!"+tf[0].getText()+" "+tf[1].getText()+"\nThis id is already in use...");
	   return;
	} 
	try
	{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   PreparedStatement ps=cn.prepareStatement("insert into LoginInfo values(?,?,?,?,?)");
                ps.setString(1,tf[0].getText());
                ps.setString(2,tf[1].getText());
                ps.setString(3,tf[2].getText());
                ps.setString(4,tf[3].getText());
                ps.setString(5,tf[5].getText());
	   ps.executeUpdate();
  	   JOptionPane.showMessageDialog(Registration.this,"Congratulation!!!"+tf[0].getText()+" "+tf[1].getText()+"\nYou have registered...");
	}
	catch(Exception ex)
	{
	   System.out.println("hel"+ex);
	}
     } 
  }
  boolean isFound()
  {
	boolean found=true;
	try
	{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   PreparedStatement ps=cn.prepareStatement("select * from LoginInfo where userid=?");
                ps.setString(1,tf[2].getText());
	   ResultSet rst=ps.executeQuery();
	   found=rst.next();
	}
	catch(Exception ex)
	{
	   System.out.println("hel"+ex);
	}
	return found;
  }
  public static void main(String ...s)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Registration();
  }
}