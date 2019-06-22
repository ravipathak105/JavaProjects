import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login2 extends JFrame implements ActionListener
{
   JLabel [] la=new JLabel[4];
   TextField [] tb=new TextField[4];
   JButton b1,b2;
   JPanel toppanel,centerpanel,userpanel,adminpanel,loginpanel;
   JButton [] menubt=new JButton[2];
   CardLayout cl=new CardLayout();
   public Login2()
   {
	super("Test Engine");
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	setSize(600,550);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(d.width/2-300,d.height/2-290);
	setResizable(false);
	toppanel=new JPanel();
	add(toppanel,"North");
	centerpanel=new JPanel();
	add(centerpanel,"Center");
	addMenu();
	setVisible(true);
   }
   void addMenu()
   {
	String [] str={"Test user login","Admin login"};
	for(int c=0;c<menubt.length;c++)
	{
	   menubt[c]=new JButton(str[c]);
	   menubt[c].addActionListener(this);
	   toppanel.add(menubt[c]);
	}
	addLogin();
   }
   void addLogin()
   {
	centerpanel.setLayout(cl);
	centerpanel.add(userpanel=new JPanel(),"user");
	centerpanel.add(adminpanel=new JPanel(),"admin");
	addUserLogin();
	addAdminLogin();
   }
   void addUserLogin()
   {
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	userpanel.setLayout(gbl);   
	gbl.setConstraints(loginpanel=new JPanel(),gbc);
	userpanel.add(loginpanel);
	loginpanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
	loginPanel("user");
   }
   void addAdminLogin()
   {
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	adminpanel.setLayout(gbl);   
	gbl.setConstraints(loginpanel=new JPanel(),gbc);
	adminpanel.add(loginpanel);
	loginpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
	loginPanel("admin");
   }
   void loginPanel(String dt)
   {
	loginpanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
	JPanel lp1=new JPanel();
	loginpanel.add(lp1);
	lp1.setLayout(new BorderLayout());
	JPanel lp=new JPanel();
	lp1.add(lp,"North");
	JPanel lpbt=new JPanel();
	lp1.add(lpbt,"Center");
	lp.setLayout(new GridLayout(3,2,3,20));
	loginpanel.setBackground(new Color(214,206,203));
	lp.setBackground(new Color(214,206,203));
	lpbt.setBackground(new Color(214,206,203));
	String [] str={"code","password"};
	if(dt.equals("user"))
	{
	   for(int c=0;c<2;c++)
	   {
	      la[c]=new JLabel("Test user "+str[c]);
	      la[c].setForeground(Color.blue);
	      la[c].setFont(new Font("Arial",Font.PLAIN,17));
	      lp.add(la[c]);
	      tb[c]=new TextField(12); 
	      tb[c].setFont(new Font("Arial",Font.PLAIN,17));
	      lp.add(tb[c]);
	   }
	   tb[1].setEchoChar('*');
	   b1=new JButton("Test user login");
	   b1.addActionListener(new ValidateLogin());
	   lpbt.add(b1);
	}
	else if(dt.equals("admin"))
	{
	   for(int c=2;c<la.length;c++)
	   {
	      la[c]=new JLabel("Test admin "+str[c-2]);
	      la[c].setForeground(Color.blue);
	      la[c].setFont(new Font("Arial",Font.PLAIN,17));
	      lp.add(la[c]);
	      tb[c]=new TextField(12); 
	      tb[c].setFont(new Font("Arial",Font.PLAIN,17));
	      lp.add(tb[c]);
	   }
	   tb[3].setEchoChar('*');
	   b2=new JButton("Test admin login");
	   b2.addActionListener(new ValidateLogin());
	   lpbt.add(b2);
	}
   }
   public void actionPerformed(ActionEvent evt)
   {
	if(evt.getSource()==menubt[0])
	  cl.show(centerpanel,"user");
	else if(evt.getSource()==menubt[1])
	  cl.show(centerpanel,"admin");
   }
   class ValidateLogin implements ActionListener
   {
	public void actionPerformed(ActionEvent evt)
	{
 	    if(evt.getSource()==b1)
	     validateUser();
	   else
	     validateAdmin();
	}
   }
   void validateUser()
   {
	try
	{
   	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   ResultSet rst=st.executeQuery("Select * from LoginInfo where userid='"+tb[0].getText()+"' and password='"+tb[1].getText()+"'");
	   if(rst.next())
	   {
		new TestEngine2();
		setVisible(false);
	   }
	   else
	    JOptionPane.showMessageDialog(loginpanel,"Incorrect user code or password..");
	}
	catch(Exception ex)
	{
	   System.out.println(ex); 
	}
   }
   void validateAdmin()
   {
	if(tb[2].getText().equals("admin") && tb[3].getText().equals("admin"))
	{
	   new TestAdmin();
	   setVisible(false);
	}
	else
	    JOptionPane.showMessageDialog(loginpanel,"Incorrect admin code or password..");
   }
   public static void main(String ...s)
   {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Login2();
   }
}