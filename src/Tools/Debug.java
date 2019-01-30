package Tools;

public class Debug
{
	String source;
	Boolean enableGlobalLogging = false;
	Boolean enableLocalLogging;
	
	public Debug(String from, Boolean enable)//constructor
	{
		source = from;
		enableLocalLogging = enable;
	}
	
	public void log(String message)
	{
		if(enableGlobalLogging || enableLocalLogging)
		{
			System.out.println(message + " in " + source);
		}
	}
}
