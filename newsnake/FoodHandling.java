import javax.swing.*;
import java.awt.*;
import java.util.*;
class FoodHandling
{
  Random ra=new Random();
  void addFood()
  {
	Va.food.setBorder(BorderFactory.createLineBorder(Color.red,12,true));
	Va.field.add(Va.food);
	Va.bonusfood=new JLabel(new ImageIcon(getClass().getResource("images/app.png")));
	Va.field.add(Va.bonusfood);
  }
  void showFood()
  {
	Va.food.setVisible(true);
	Va.foodx=ra.nextInt(Va.fx)+Va.fxy;	
	Va.foody=ra.nextInt(Va.fy)+Va.fxy;	
	Va.food.setBounds(Va.foodx,Va.foody,Va.w,Va.h);
  }
  void bonusFood()
  {
	Va.bonusfoodx=ra.nextInt(360)+20;	
	Va.bonusfoody=ra.nextInt(280)+24;	
	Va.bonusfood.setBounds(Va.bonusfoodx,Va.bonusfoody,20,24);
	Va.bonusfoodvisible=true;
	Va.bonusfood.setVisible(true);	
	new  BonusFood().start();
  }	
}