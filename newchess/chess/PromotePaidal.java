import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PromotePaidal extends JFrame
{
  JButton [] bt=new JButton[4];
  public PromotePaidal()
  {
	setSize(350,150);
	setLocationRelativeTo(null);
	setResizable(false);
	setLayout(new FlowLayout());
	addPanel();
  }
  void addPanel()
  {
	add(new JLabel("<html><h3>Promote your paidal in one of the following</h3></html>"));	
	String [] str={"Wazeer","Hathi","Oont","Ghoda"};
	PromoteListener listener=new PromoteListener();
	for(int i=0;i<bt.length;i++)
	{
	  bt[i]=new JButton(str[i]);
	  bt[i].addActionListener(listener);
	  add(bt[i]);
	}
  }  
  class PromoteListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
	if(evt.getSource()==bt[0])
	  setN(4);
	else if(evt.getSource()==bt[1])
	  setN(1);
	else if(evt.getSource()==bt[2])
	  setN(3);
	else 
	  setN(2);
    }
    void setN(int ei)
    {
	if(Va.pln==0)
	{
	  Va.mbc.setIcon(new ImageIcon(getClass().getResource("images/w"+(ei-1)+".gif")));
	  Va.mbc.pi=0;
	}
	else
	{
	  Va.mbc.setIcon(new ImageIcon(getClass().getResource("images/b"+(ei-1)+".gif")));
	  Va.mbc.pi=1;
	}
	Va.mbc.ei=ei;
	Va.promote=false;
	PlaceElement.reset();
	setVisible(false);
    }
  }
}