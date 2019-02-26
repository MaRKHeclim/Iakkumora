package Tools;

import com.google.gson.GsonBuilder;

public class Debug
{
	private String source;
	private Boolean enableLogging;
	private Boolean enableAllLogging;
	private Boolean enableLocalLogging;
	private Boolean enableStackTracing;
	private Boolean enableAllStackTracing;
	private Boolean enableLocalStackTracing;
	
	public Debug(String from, Boolean logEnable, Boolean stackEnable)//constructor
	{
		enableLogging = true;
		enableAllLogging = false;
		enableStackTracing = true;
		enableAllStackTracing = false;
		source = from;
		enableLocalLogging = logEnable;
		enableLocalStackTracing = stackEnable;
	}
	
	public void log(String message)
	{
		if(enableLogging && (enableAllLogging || enableLocalLogging))
		{
			System.out.println(message + " in " + source);
		}
		if(enableStackTracing && (enableAllStackTracing || enableLocalStackTracing))
		{
			new Exception().printStackTrace();
		}
	}
	
	public void dumpObject(Object obj)
	{
		//TODO Test the heck out of this
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));
	}
}
