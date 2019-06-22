import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class TestEngine2 extends JFrame implements ActionListener
{
   JPanel tottimepanel,qstansrevpanel,qstanspanel,btnspanel,totqstpanel,timepanel,revpanel,qstpanel,anspanel,showqstpanel,endpanel,rbpanel,revbtnspanel,respanel,resbtnspanel;
   JRadioButton [] ans=new JRadioButton[4];	
   JRadioButton [] ch=new JRadioButton[3];
   JButton [] bt=new JButton[6];
   JButton [] revbt;
   JButton [] resbt;
   ButtonGroup bg=new ButtonGroup();	
   ButtonGroup bg1=new ButtonGroup();	
   CardLayout cl=new CardLayout();
   JScrollPane spans;
   JTextArea ta;
   JLabel tm;
   JLabel rla[]=new JLabel[3];
   int [] clickedans;
   int [] correctans;
   int m,s=0;	
   ResultSet rst;	
   int qst=1,totquestion=0;	
   String paper;	
   public TestEngine2(String paper)
   {
	super("Test Engine");
	this.paper=paper;
	Runtime rt=Runtime.getRuntime();
	JFrame.setDefaultLookAndFeelDecorated(true);
	connect();
	revbt=new JButton[totquestion];
	resbt=new JButton[totquestion];
	clickedans=new int[totquestion];
	m=totquestion/2;
	if(totquestion%2!=0)
	{
	  s=30;
	}
	for(int c=0;c<clickedans.length;c++)
	  clickedans[c]=-1;
	setSize(600,550);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
	setLayout(new BorderLayout(0,10));
	initPanels();
	new TestTime().start();
	setVisible(true);
   }
   void initPanels()
   {
	tottimepanel=new JPanel();
	qstansrevpanel=new JPanel();
	qstanspanel=new JPanel();
	btnspanel=new JPanel();
	totqstpanel=new JPanel();
	timepanel=new JPanel();
	revpanel=new JPanel();
	qstpanel=new JPanel();
	anspanel=new JPanel();
	showqstpanel=new JPanel();
	endpanel=new JPanel();
	rbpanel=new JPanel();
	revbtnspanel=new JPanel();
	respanel=new JPanel();
	resbtnspanel=new JPanel();
	addPanels();
   }
   void addPanels()
   {
	addTotTimePanel();
	addQstAnsrevPanel();
	addButtonsPanel();
   }
   void addTotTimePanel()
   {
	add(tottimepanel,"North");
	tottimepanel.setLayout(new GridLayout(1,2));
	tottimepanel.add(totqstpanel);	
	tottimepanel.add(timepanel);
	totqstpanel.setBackground(Color.cyan);timepanel.setBackground(Color.cyan);
	totqstpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	timepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	totqstpanel.add(new JLabel("Total queation:"+totquestion));
	timepanel.add(tm=new JLabel());
   }
   void addQstAnsrevPanel()
   {
	add(qstansrevpanel,"Center");
	qstansrevpanel.setLayout(cl);
	qstansrevpanel.add(qstanspanel,"qstans");
	qstanspanel.setLayout(new BorderLayout());
	qstansrevpanel.add(revpanel,"rev");
	qstansrevpanel.add(respanel,"result");
	addQstPanel();
	addAnsPanel();
	addResultPanel();
	addReviewPanel();
   }
   void addButtonsPanel()
   {
	add(btnspanel,"South");
	btnspanel.setLayout(new BorderLayout());
	btnspanel.add(showqstpanel,"North");
	btnspanel.add(endpanel,"Center");
	btnspanel.add(rbpanel,"South");
	addShowQstPanel();		
	addRbPanel();	
   }
   void addQstPanel()
   {
	qstanspanel.add(qstpanel,"North");
	qstpanel.setLayout(new BorderLayout());
	try
	{
	  ta=new JTextArea("Question"+qst+"\n"+rst.getString(2)+"?");
	}catch(Exception ex){System.out.println(ex);}
	ta.setLineWrap(true);
	ta.setEditable(false);
	ta.setFont(new Font("Arial",Font.PLAIN,18));
	qstpanel.add(ta);
   }
   void addAnsPanel()
   {
	qstanspanel.add(anspanel,"West");
	anspanel.setLayout(new GridLayout(4,1));
	for(int c=0;c<ans.length;c++)
	{
	   try
	   {
	     ans[c]=new JRadioButton(rst.getString(c+3));
	   }catch(Exception ex){System.out.println(ex);}
	   ans[c].addActionListener(new SetAns());
	   bg.add(ans[c]);
	   anspanel.add(ans[c]);
	}
   }
   void addShowQstPanel()
   {
	showqstpanel.setBackground(new Color(140,230,97));
	endpanel.setBackground(new Color(140,230,97));
	showqstpanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,5));
	String [] str={"First","Previous","Next","Last","End Test","Review"};
	for(int c=0;c<bt.length;c++)
	{
	   bt[c]=new JButton(str[c]);
	   bt[c].addActionListener(this);
	   if(c==4 || c==5)
	     endpanel.add(bt[c]);
	   else
	     showqstpanel.add(bt[c]);
	}
   }
   void addRbPanel()
   {
	String []str={"All","Attempted","Not Attempted"};
	for(int c=0;c<ch.length;c++)
	{
	   ch[c]=new JRadioButton(str[c]);
	   bg1.add(ch[c]);
	   rbpanel.add(ch[c]);
	}
	ch[0].setSelected(true);
	ch[1].setForeground(Color.green);
	ch[2].setForeground(Color.red);
   }
   void addReviewPanel()
   {
	int noc=4;
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	revpanel.setLayout(gbl);   
	revbtnspanel.setBackground(Color.red);
	gbl.setConstraints(revbtnspanel,gbc);
	revpanel.add(revbtnspanel);
	if(totquestion>=15)
	  noc=5;
	int nor=totquestion/noc;
	if(totquestion%noc!=0)
	  nor++;
	revbtnspanel.setLayout(new GridLayout(nor,noc,5,5));	
	revbtnspanel.setBackground(Color.cyan);
	for(int c=0;c<revbt.length;c++)
	{
	  revbt[c]=new JButton(String.valueOf(c+1));
	  revbt[c].setToolTipText("click to see question");
	  revbt[c].addActionListener(new DispQuestion());
	  revbt[c].setForeground(Color.white);
	  revbt[c].setFont(new Font("Arial",Font.BOLD,16));
	  revbtnspanel.add(revbt[c]);
	}
   }
   void addResultPanel()
   {
	int noc=4;
	JPanel mp=new JPanel();
	mp.setLayout(new BorderLayout(0,20));
	GridBagLayout gbl=new GridBagLayout();
	GridBagConstraints gbc=new GridBagConstraints();
	respanel.setLayout(gbl);   
	gbl.setConstraints(mp,gbc);
	respanel.add(mp);
	mp.add(resbtnspanel,"North");
	if(totquestion>=15)
	  noc=5;
	int nor=totquestion/noc;
	if(totquestion%noc!=0)
	  nor++;
	resbtnspanel.setLayout(new GridLayout(nor,noc,5,5));	
	resbtnspanel.setBackground(Color.cyan);
	for(int c=0;c<revbt.length;c++)
	{
	  resbt[c]=new JButton(String.valueOf(c+1));
	  //resbt[c].addActionListener(new DispQuestion());
	  resbt[c].setForeground(Color.white);
	  resbt[c].setFont(new Font("Arial",Font.BOLD,16));
	  resbtnspanel.add(resbt[c]);
	}
	JPanel hintp=new JPanel();
	mp.add(hintp,"Center");
	JButton hbt[]=new JButton[3];
	String [] str={"correct","incorrect","not attempted"};
	for(int c=0;c<hbt.length;c++)
	{
	   hbt[c]=new JButton(str[c]);
	   hbt[c].setForeground(Color.white);
	   hbt[c].setFont(new Font("Arial",Font.BOLD,16));
	   hintp.add(hbt[c]);
	}
	hbt[0].setBackground(Color.green);
	hbt[1].setBackground(Color.red);
	hbt[2].setBackground(Color.blue);
	JPanel rp=new JPanel();
	rp.setBackground(Color.yellow);
	mp.add(rp,"South");
	for(int c=0;c<rla.length;c++)
	{
	  rla[c]=new JLabel();
	  rla[c].setFont(new Font("Arial",Font.BOLD,15));
	  rp.add(rla[c]);
	}
	rla[0].setForeground(Color.green);
	rla[1].setForeground(Color.red);
	rla[2].setForeground(Color.blue);
   }
   class SetAns implements ActionListener
   {	
       public void actionPerformed(ActionEvent evt)
       {
	JRadioButton ra=(JRadioButton)evt.getSource();
	int i=0;
	for(;ra!=ans[i];i++);
	clickedans[qst-1]=i;
       }
   }
   class DispQuestion implements ActionListener
   {	
       public void actionPerformed(ActionEvent evt)
       {
	JButton rbt=(JButton)evt.getSource();
	qst=Integer.parseInt(rbt.getText());
	bt[5].setText("Review");
	edButtons(true);
	cl.show(qstansrevpanel,"qstans");
	showQuestion();
       }
   }
   public void actionPerformed(ActionEvent evt)
   {
	if(evt.getSource()==bt[2])//next button
	   nextQuestion();
	else if(evt.getSource()==bt[1])//revious button
	   prevQuestion();
	else if(evt.getSource()==bt[3])//last button
	   lastQuestion();
	else if(evt.getSource()==bt[0])//first button
	   firstQuestion();
	else if(evt.getSource()==bt[4])//end test button
	   endTest();
	else if(evt.getSource()==bt[5])//review button
	   review();
   }
   void nextQuestion()
   {
	   if(qst==totquestion)
	   {
		JOptionPane.showMessageDialog(this,"This is the last question");
		return;
	   }
	   if(ch[1].isSelected())
	   {
	      boolean attemptfound=false;
	      for(int i=qst;i<totquestion;i++)
	      {
		if(clickedans[i]!=-1)
		{
		   qst=i+1;
		   attemptfound=true;
		   break;
		}
	      }
	      if(!attemptfound)
	      {
	          JOptionPane.showMessageDialog(this,"No more attempt question");
	          return;
	      }
	   }
	   else if(ch[2].isSelected())//not attempt
	   {
	      boolean notattemptfound=false;
	      for(int i=qst;i<totquestion;i++)
	      {
		if(clickedans[i]==-1)
		{
		   qst=i+1;
		   notattemptfound=true;
		   break;
		}
	      }
	      if(!notattemptfound)
	      {
	          JOptionPane.showMessageDialog(this,"No more not attempt question");
	          return;
	      }
	   }
	   else
	     qst++;
	   showQuestion();
   }
   void prevQuestion()
   {
	   if(qst==1)
	   {
		JOptionPane.showMessageDialog(this,"This is the first question");
		return;
	   }
 	   if(ch[1].isSelected())
	   {
	      for(int i=qst-2;i>=0;i--)
	      {
		if(clickedans[i]!=-1)
		{
		   qst=i+1;
		   break;
		}
	      }
	   }
	   else if(ch[2].isSelected())
	   {
	      for(int i=qst-2;i>=0;i--)
	      {
		if(clickedans[i]==-1)
		{
		   qst=i+1;
		   break;
		}
	      }
	   }
	   else
	     qst--;
	   showQuestion();
   }
   void lastQuestion()
   {
	   if(qst==totquestion)
	   {
		JOptionPane.showMessageDialog(this,"This is the first question");
		return;
	   }
	   qst=totquestion;
	   showQuestion();
   }
   void firstQuestion()
   {
 	   if(qst==1)
	   {
		JOptionPane.showMessageDialog(this,"This is the first question");
		return;
	   }
	   qst=1;
	   showQuestion();
   }
   void showQuestion()
   {
           try
           {
	rst.absolute(qst);
	ta.setText("Question"+qst+"\n"+rst.getString(3)+"?");
	for(int c=0;c<4;c++)
	{
	    ans[c].setText(rst.getString(c+4));
	}
	bg.clearSelection();
	if(clickedans[qst-1]!=-1)
	  ans[clickedans[qst-1]].setSelected(true);
           }catch(Exception ex){System.out.println(ex);}
   }
   void endTest()
   {
	if(bt[4].getText().equals("Logout"))
	{
	  System.exit(0);
	}
 	int ch=JOptionPane.showConfirmDialog(this,"are you sure you want to end test");
	if(ch==0)
	{
 	   cl.show(qstansrevpanel,"result");
	   resultReview();
               }
   }
   void review()
   {
	if(bt[5].getText().equals("Review"))
	{
	   cl.show(qstansrevpanel,"rev");
	   qstReview();
	}
	else if(bt[5].getText().equals("Questions"))
	{
	   bt[5].setText("Review");
	   edButtons(true);
	   cl.show(qstansrevpanel,"qstans");
	}
   }
   void qstReview()
   {
	for(int c=0;c<revbt.length;c++)
	{
	  if(clickedans[c]==-1)
	     revbt[c].setBackground(Color.red);
	  else
	     revbt[c].setBackground(Color.green);
	}
	bt[5].setText("Questions");
	edButtons(false);
   }
   void resultReview()
   {
	int tc=0,na=0;
	for(int c=0;c<revbt.length;c++)
	{
	  if(clickedans[c]==-1)
	  {
	     resbt[c].setBackground(Color.blue);
	     na++;
	  }
	  else if(correctans[c]==clickedans[c])
	  {
	     resbt[c].setBackground(Color.green);
	     tc++;
	  }
	  else
	     resbt[c].setBackground(Color.red);
	}
	rla[0].setText("Total correct:"+tc);
	rla[1].setText("Total incorrect:"+(totquestion-(tc+na)));
	rla[2].setText("Total not attempt:"+na);
	bt[5].setEnabled(false);
	bt[4].setText("Logout");
	edButtons(false);
   }
   void edButtons(boolean st)
   {
	for(int c=0;c<4;c++)
	{
	  bt[c].setEnabled(st);
	  ans[c].setEnabled(st);
	}
   }
   class TestTime extends Thread
   {
	public void run()
	{
	   while(true)
	   {
		tm.setText("Remaining Time-->"+(m<10?("0"+m):m)+":"+(s<10?("0"+s):s));
		try
		{
		   sleep(1000);
		}
		catch(Exception ex){}
		if(s==0)
		{
		  if(m==0 && s==0)
		  {
		     edButtons(false);
		     JOptionPane.showMessageDialog(TestEngine2.this,"Your test time is over\nClick end test button to see result");
		     break;
		  }
		  else
		  {
		     s=60;
		     m--;
	                 } 
		}
		s--;
	   }
	}
   }
   void connect()
   {
	try
	{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   //Connection cn=DriverManager.getConnection("jdbc:odbc:testengine");
	   Connection cn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+System.getProperty("user.dir")+"\\TestEngine.mdb");
	   Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   ResultSet totrow=st.executeQuery("Select count(*) from QuestionBank where paper='"+paper+"'");
	   totrow.next();
	   totquestion=totrow.getInt(1);
	   correctans=new int[totquestion];
	   rst=st.executeQuery("select * from QuestionBank where paper='"+paper+"'");
	   int i=0;
	   while(rst.next())
	      correctans[i++]=rst.getInt(8);
	   rst.absolute(1);
	}
	catch(Exception ex)
	{
	   System.out.println("hel"+ex);
	}
   }
}