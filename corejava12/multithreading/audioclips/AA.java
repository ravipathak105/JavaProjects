import java.applet.*;
class AA
{
  void playSound()
  {
	AudioClip clip=Applet.newAudioClip(getClass().getResource("sound/gameover.wav"));
	clip.play();
  }
  public static void main(String []args)
  {
	new AA().playSound();
	try{
	  Thread.sleep(30000);
	}catch(Exception ex){}
  }
}