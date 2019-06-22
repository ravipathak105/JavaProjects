import javax.swing.*;
import java.awt.*;
import java.applet.*;
class InfoPanel
{
  JPanel [] infopa=new JPanel[3];
  void addInfo()
  {
  	JPanel mpa=new JPanel();
	mpa.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
	mpa.setBounds(0,0,490,35);
	Va.snake.add(mpa);
	mpa.setLayout(new GridLayout(1,3));
	for(int i=0;i<3;i++)
	{
	  infopa[i]=new JPanel();
	  infopa[i].setBackground(Color.blue);
	  mpa.add(infopa[i]); 
	}
	Va.score=new JLabel("SCORE: 0");
	Va.score.setForeground(Color.white);
	Va.score.setFont(Va.fo);
	infopa[2].add(Va.score);
	infopa[1].add(Va.timer);
	Va.timer.setVisible(false);
	Va.level=new JLabel("LAVEL: 1");
	Va.level.setForeground(Color.white);
	Va.level.setFont(Va.fo);
	infopa[0].add(Va.level);
	Va.start.setFont(Va.fo);
	Va.start.setBounds(120,100,250,30);
	Va.field.add(Va.start);
	maxScoreBoard();
	setMarquee();
	loadSound();
  }
  void maxScoreBoard()
  {
	Va.spa=new JPanel();
	Va.spa.setBounds(0,40,490,35);
	Va.spa.setBackground(Color.white);
	Va.playerscore=new JLabel();
	Va.playerscore.setFont(new Font("Arial",0,20));
	Va.playerscore.setForeground(Color.blue);
	Va.spa.add(Va.playerscore);
	Va.snake.add(Va.spa);
	//Va.spa.setVisible(false);
  }
  void setMarquee()
  {
	Va.mp=new JPanel();
	Va.mp.setLayout(null);
	Va.mp.setBounds(0,40,490,35);
	Va.mp.setBackground(Color.white);
	Va.marquee=new JLabel("Eat APPLE to get bonus point");
	Va.marquee.setFont(Va.fo2);
	Va.marquee.setForeground(Color.magenta);
	Va.marquee.setBounds(200,2,290,30);
	Va.mp.add(Va.marquee);
	Va.snake.add(Va.mp);
	//Va.mp.setVisible(true);
  }
  void loadSound()
  {
    try
    {
	Va.clipdie=Applet.newAudioClip(getClass().getResource("sound/gameover.wav"));
	Va.clipeat1=Applet.newAudioClip(getClass().getResource("sound/eat.wav"));
	Va.clipeat2=Applet.newAudioClip(getClass().getResource("sound/eat.wav"));
	Va.clipmove=Applet.newAudioClip(getClass().getResource("sound/enter.wav"));
	Va.clipeatc=Va.clipeat1;
    }catch(Exception ex){}	
  }
}