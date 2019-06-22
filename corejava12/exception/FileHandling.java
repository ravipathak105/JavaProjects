import java.io.*;
class FileHandling
{
  static void openFile(String filepath)
  {
	System.out.println("Execution begins...");
	try
	{
	  FileReader reader=new FileReader(filepath);
	  BufferedReader br=new BufferedReader(reader);
	  String str=br.readLine();
	  while(str!=null)
	  {
		System.out.println(str);
		str=br.readLine();
	  }
	}
	catch(FileNotFoundException ex)
	{
	  System.out.println("Specified file is missing...");
	  //System.out.println(ex.toString());
	}
	catch(IOException ex)
	{
	  System.out.println(ex.toString());
	}
	System.out.println("Execution ends...");
  }
  public static void main(String []args)
  {
	openFile("FileHandling.java");
  }
}