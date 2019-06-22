import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class TestAdmin extends JFrame implements ActionListener
{
   JLabel [] la=new JLabel[6];
   TextArea [] ta=new TextArea[5];
   JButton bsave,logout;
   JPanel mainpanel;
   JComboBox cb,paper;
   public TestAdmin()
   {
	super("Test Engine");
	setSize(600,560);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setLayout(null);   
	mainpanel=new JPanel();
	mainpanel.setBounds(10,10,530,520);
	mainpanel.setBackground(new Color(214,206,203));
	add(mainpanel);
	addControl();
	setVisible(true);
   }
   void addControl()
   {
	Font fo=new Font("Arial",Font.BOLD,16);
	JLabel lp=new JLabel("Select paper");
	lp.setFont(fo);
	lp.setBounds(20,20,120,28);
	mainpanel.add(lp);
	String [] pa={"Core Java","Advance Java","C Language","Data Structure","ASP.Net","C++","Visual Basic","Database"};
	paper=new JComboBox(pa);
	paper.setBounds(150,20,200,28);
	mainpanel.add(paper);
	int y=80;
	mainpanel.setLayout(null);
	String [] str={"question","answer1","answe2","answer3","answer4"};
	for(int c=0;c<ta.length;c++)
	{
	    la[c]=new JLabel("Type "+str[c]);
	    la[c].setBounds(20,y,120,28);
	    la[c].setFont(fo);
	    mainpanel.add(la[c]);
	    ta[c]=new TextArea();
	    ta[c].setBounds(150,y,300,50);
	    mainpanel.add(ta[c]);
	    y+=70;
	}
	ta[0].setBounds(150,70,350,70);
	la[5]=new JLabel("Correct answer");
	la[5].setBounds(20,y,120,28);
	la[5].setFont(new Font("Arial",Font.BOLD,16));
	mainpanel.add(la[5]);
	String [] ca={"0","1","2","3"};
	cb=new JComboBox(ca);
	cb.setBounds(150,y,50,28);
	mainpanel.add(cb);
	bsave=new JButton("Save Record");
	bsave.setBounds(150,y+=40,120,28);
	bsave.addActionListener(this);
	mainpanel.add(bsave);
	logout=new JButton("Logout");
	logout.setBounds(280,y,120,28);
	logout.addActionListener(this);
	mainpanel.add(logout);
   }
   public void actionPerformed(ActionEvent evt)
   {
	if(evt.getSource()==logout)
	  System.exit(0);
	else if(evt.getSource()==bsave)
	  saveRecord();
   }
   void saveRecord()
   {
	try
	{
   	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   Statement st=cn.createStatement();
	   ResultSet rst=st.executeQuery("select max(qid) from QuestionBank");
	   rst.next();
	   int qid=rst.getInt(1)+1;
	   String qr="insert into QuestionBank values("+qid+",'"+paper.getSelectedItem().toString()+"','"+ta[0].getText()+"','"+ta[1].getText()+"','"+ta[2].getText()+"','"+ta[3].getText()+"','"+ta[4].getText()+"',"+cb.getSelectedItem().toString()+")";
	   st.executeUpdate(qr);
	   JOptionPane.showMessageDialog(mainpanel,"Record saved....");
	}
	catch(Exception ex)
	{
	   System.out.println(ex); 
	}
   }
   public static void main(String ...s)
   {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new TestAdmin();
   }
}