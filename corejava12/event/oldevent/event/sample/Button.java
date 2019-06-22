public class Button
{
 ActionListener listener;
 void clickEvent()
 {
	listener.performTask();
 }
 void addActionListener(ActionListener obj)
 {
	listener=obj;
 }
}