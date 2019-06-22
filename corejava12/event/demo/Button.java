class Button
{
  ActionListener listener;
  public void addActionListener(ActionListener obj)
  {
	listener=obj;
  }
  public void clickEvent()
  {
	listener.actionPerformed(90);
  }
}