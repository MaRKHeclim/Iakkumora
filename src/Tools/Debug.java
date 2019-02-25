package Tools;

public class Debug
{
	private String source;
	private Boolean enableGlobalLogging;
	private Boolean enableLocalLogging;
	private Boolean enableGlobalStackTracing;
	private Boolean enableLocalStackTracing;
	
	public Debug(String from, Boolean logEnable, Boolean stackEnable)//constructor
	{
		enableGlobalLogging = false;
		enableGlobalStackTracing = false;
		source = from;
		enableLocalLogging = logEnable;
		enableLocalStackTracing = stackEnable;
	}
	
	public void log(String message)
	{
		if(enableGlobalLogging || enableLocalLogging)
		{
			System.out.println(message + " in " + source);
		}
		if(enableGlobalStackTracing || enableLocalStackTracing)
		{
			new Exception().printStackTrace();
		}
	}
	
	public void dumpObject(Object obj)
	{
		//TODO add a method to dump an object in JSON to the console
	}
}
