class ChangeSpeed extends Thread
{
  public void run()
  {
	if(Va.ctr>=Va.speedchange)
	{
	  if(Va.leveln<=20)
	  {
	   Va.bs[Va.speedi]-=2;
	   Va.speed=Va.speed-Va.speedinc[Va.speedi][Va.leveln];
	   Va.speedchange=Va.speedchange+Va.scvalue[Va.speedi];	
	   Va.scvalue[Va.speedi]+=10;
   	   Va.leveln++;
	   Va.level.setText("LEVEL: "+Va.leveln);
	   System.out.println("Current speed:"+Va.speed);
          } 
	  if(Va.leveln==6-Va.speedi)
	  {
		Va.fx=Va.fx-Va.fxy;
		Va.fy=Va.fy-Va.fxy;
		Va.fxy=2*Va.fxy;
	  } 
	}
  }
 
}