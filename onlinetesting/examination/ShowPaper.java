import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class ShowPaper extends JFrame
{
  JComboBox <String>items;
  JButton bt;
  ResultSet rst;
  public ShowPaper()
  {
	super("Select Paper");
	setSize(600,550);
	setLocationRelativeTo(null);
	setLayout(new FlowLayout(FlowLayout.CENTER,400,100));
	items=new JComboBox<String>();
	add(items);
	paper();
	bt=new JButton("Start Test");
	bt.addActionListener(new MyListener());
	add(bt);
	Font fo=new Font("arial",0,20);
	items.setFont(fo);
	bt.setFont(fo);
	bt.setMnemonic('S');
	setVisible(true);
  } 
  void paper()
  {
	try
	{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   rst=st.executeQuery("Select distinct paper from QuestionBank");
	   while(rst.next())
	   {
		items.addItem(rst.getString(1));
	   }
	}
	catch(Exception ex)
	{
	   System.out.println("hel"+ex);
	}
  }
  class MyListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
	new TestEngine2(items.getSelectedItem().toString());
    }
  }
  public static void main(String ...s)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new ShowPaper();
  }
}