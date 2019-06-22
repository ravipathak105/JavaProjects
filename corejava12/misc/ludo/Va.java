import javax.swing.*;
class Va
{
  static JLabel [][] goti=new JLabel[4][4];
  static int [][]gotix={{37,87,37,85},{262,312,262,312},{37,87,37,85},{262,312,262,312}};
  static int [][]gotiy={{20,20,70,70},{20,20,70,70},{245,245,295,295},{245,245,295,295}};
  static JButton dice;
  static JLabel arrow;
  static boolean move=true;
  static void pause(int time)
  {
	try{
	  Thread.sleep(time);
	}catch(Exception ex){}
  }
}