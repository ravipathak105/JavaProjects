class DetectMovePosition
{
  static void detect()
  {
	findPosition();	
	if(Va.movelist.size()>0)
	  Va.chess.box.highlight();
  }  
  static void findPosition()
  {
	int ei=Va.bc.ei;
	if(ei==6)//Paidal
	{
	  DetectPaidalPos.detect();
	}
	else if(ei==1)//Hathi
	{
	  DetectStateAndDigonalPost.recordStPos(Va.bc.r,Va.bc.c);
	}
	else if(ei==2)//Ghoda
	{
	  DetectGhodaPos.detect();
	}
	else if(ei==3)//Unt
	{
	  DetectStateAndDigonalPost.recordDigPos(Va.bc.r,Va.bc.c);
	}
	else if(ei==4)//Wazeer
	{
	  DetectStateAndDigonalPost.recordStPos(Va.bc.r,Va.bc.c);
	  DetectStateAndDigonalPost.recordDigPos(Va.bc.r,Va.bc.c);
	}
	else if(ei==5)//raja
	{
	  DetectRajaPos.detect();
	}
  }
}