package Tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileFunctions
{
	public static int writeFile(String relativeFilePath, String data)
	{
		File file = new File(relativeFilePath);
		if(!file.exists())
		{
			try
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			catch (IOException ex)
			{
				System.out.println("ERROR - FileManager could not create new file for path specified");
				return -1;
			}
		}
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(data);
			bw.flush();
			bw.close();
		}
		catch (IOException ex)
		{
			System.out.println("ERROR - FileManager could not create file writer for specified file");
			System.out.println(ex.getMessage());
			return -1;
		}
		return 0;
	}
	
	public static int appendFile(String relativeFilePath, String data){
		File file = new File(relativeFilePath);
		if(!file.exists())
		{
			try
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			catch (IOException ex)
			{
				System.out.println("ERROR - FileManager could not create new file for path specified");
				return -1;
			}
		}
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.append(data);
			bw.flush();
			bw.close();
		}
		catch (IOException ex)
		{
			System.out.println("ERROR - FileManager could not create file writer for specified file");
			return -1;
		}
		return 0;
	}
}
