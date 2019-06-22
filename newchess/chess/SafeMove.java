class SafeMove
{
  static boolean isSafe()
  {
	MButton mt=Va.bc;
	int ei=mt.ei;
	mt.ei=0;
	CheckMate.findCheck();
	mt.ei=ei;
	Va.bc=mt;
	return Va.checker==null;
  } 
}