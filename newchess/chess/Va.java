import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;
class Va
{
  static MainClass chess;
  static MButton [][] bt=new MButton[8][8];
  static MButton []kp=new MButton[2];
  static MButton bc,mbc,checker,kingchecked;
  static JLabel []lblturn=new JLabel[2];
  static JPanel board=new JPanel(); 
  static JPanel left=new JPanel(); 
  static JPanel right=new JPanel(); 
  static JLabel ppa=new JLabel();
  static boolean castleligible=false,p1castl=true,p2castl=true,iscutting=false;
  static boolean blinking=false,promote=false,kingmove=true;
  static boolean [] km={false,false};
  static boolean [][] hm={{false,false},{false,false}};
  static Font fo=new Font("elephant",0,20);
  static int pln=0; 	
  static int [][]xy={{230,550},{230,10}};
  static int [] leftb={0,8,16,};
  @SuppressWarnings("unchecked") 
  static ArrayList<MButton> []elementlist=new ArrayList[2]; 
  static ArrayList<MButton> checkerlist=new ArrayList<MButton>(); 
  static ArrayList<MButton> movelist=new ArrayList<MButton>(); 
  static int getPn()
  {
	return pln==0?1:0;
  }
  static Border greenb=BorderFactory.createLineBorder(Color.green,3);
  static Border blackb=BorderFactory.createLineBorder(Color.black,1);
}