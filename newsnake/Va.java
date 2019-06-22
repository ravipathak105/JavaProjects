import javax.swing.*;
import java.awt.*;
import java.applet.AudioClip;
class Va
{
  static Snake snake;
  static MainClass stsnake;
  static JLabel field,foodtimer,bonusfood,playerscore,score,level,marquee;
  static JProgressBar timer;
  static JLabel food=new JLabel();
  static JLabel start=new JLabel("Press Enter to Start");
  static JLabel [] sn=new JLabel[100];
  static JPanel mp,spa;
  static int []sy=new int[100];
  static int []sx=new int[100];
  static int[][] speedinc={{200,50,40,20,10,8,7,6,5,4,3,2,1,0,0,0,0,0,0,0,0},{150,40,20,15,10,8,6,4,3,2,1,0,0,0,0,0,0,0,0,0,0},{100,20,10,8,6,4,3,2,1,1,0,0,0,0,0,0,0,0,0,0,0}};
  static int[] bonusvalue={40,45,50};
  static int [] scvalue={70,80,90};
  static int [] bs={80,60,40};
  static int []st={10,8,5};
  static int w=12,h=12,si,size=4,foodx,foody,speed=200,bonusfoodx,bonusfoody,mx=200;
  static MyThread cthread;
  static boolean bonusfoodvisible=false,timerstarted=false,snakedead=false,recordset=false,foodeated=false,started=false;;
  static Font fo=new Font("elephant",1,20);
  static Font fo2=new Font("elephant",0,18);
  static int speedi,ctr,speedchange=70,leveln=1,fx=400,fy=320,fxy=15,n,highscore,px=15,py=360,cd=0;
  static AudioClip clipdie,clipeat1,clipeat2,clipmove,clipeatc;
  static String username,name;	
}
