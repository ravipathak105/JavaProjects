import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
class Notepad extends JFrame
{
 JTextArea ta;
 JMenuBar mb;
 JMenu []menu=new JMenu[5];
 JMenuItem []items=new JMenuItem[23];
 public Notepad()
 {
	super("Untitled - Notepad");
	setSize(600,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	addTextArea();
	addMenu();
	setVisible(true);
 }
 private void addTextArea()
 {
	ta=new JTextArea();
	JScrollPane pa=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	add(pa)	;
	Font fo=new Font("arial",Font.PLAIN,20);
	ta.setFont(fo);
 } 
 private void addMenu()
 {
	mb=new JMenuBar();
	setJMenuBar(mb);
	String [] t1={"File","Edit","Format","View","Help"};
	char [] t2={'F','E','o','V','H'};
	for(int i=0;i<menu.length;i++)
	{
	 menu[i]=new JMenu(t1[i]);
	 menu[i].setMnemonic(t2[i]);
	 mb.add(menu[i]);
	}
	addMenuItem();
 }
 private void addMenuItem()
 {
	int x=0;
	String [] str={"New","Open...","Save","Save As...","Page Setup...","Print...","Exit","Undo","Cut","Copy","Paste","Delete","Find...","Find Next","Replace...","Go To...","Select All","Time/Date","Word Wrap","Font...","Status Bar","View Help","About Notepad"};
	for(int i=0;i<items.length;i++)
	{
	  items[i]=new JMenuItem(str[i]); 
	  if(i==7 || i==18 || i==20 || i==21)
	    x++;
	  menu[x].add(items[i]);
	  if(i==3 || i==5 || i==7 || i==11 || i==15|| i==21)
	   menu[x].addSeparator();
	}
	KeyStroke k1=KeyStroke.getKeyStroke('N',KeyEvent.CTRL_DOWN_MASK);
	items[0].setAccelerator(k1);
	FileListener listener=new FileListener();
	items[1].addActionListener(listener);
	items[2].addActionListener(listener);
 }
 class FileListener implements ActionListener
 {
  public void actionPerformed(ActionEvent evt)
  {
     try
     {  	
	if(evt.getSource()==items[1])//open file
	{
	 FileDialog fd=new FileDialog(Notepad.this);
	 fd.setVisible(true);
	 String pa=fd.getDirectory()+fd.getFile();
	 FileReader fr=new FileReader(pa);
	 BufferedReader br=new BufferedReader(fr);
	 ta.setText("");
	 String str=br.readLine();
	 while(str!=null)
	 {
		ta.append(str+"\n");
		str=br.readLine();
	 } 
	 setTitle("Notepad - "+fd.getFile());
	}
	if(evt.getSource()==items[2])//save file
	{
	 FileDialog fd=new FileDialog(Notepad.this);
	 fd.setMode(FileDialog.SAVE);
	 fd.setVisible(true);
	 String pa=fd.getDirectory()+fd.getFile();
	 FileWriter fw=new FileWriter(pa);
	 PrintWriter pw=new PrintWriter(fw);
	 pw.println(ta.getText()); 
	 pw.flush();
	 setTitle("Notepad - "+fd.getFile());
	}
     }
     catch(Exception ex)
     {
	System.out.println(ex);
     } 
  }	
 }
 public static void main(String args[])
 {
	new Notepad();
 }
}

