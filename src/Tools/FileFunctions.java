package Tools;

import java.io.*;

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

	public static String readFile(String relativeFilePath)
	{
		Debug debug = new Debug("FileFunctions - readFile", true, false);
		File file = new File(relativeFilePath);
		if(file.exists())
		{
			try
			{
				String fileString = "";
				BufferedReader br = new BufferedReader(new FileReader(file));

				String readString = "";
				while((readString = br.readLine()) != null)
				{
					fileString += readString;
				}

				br.close();
				debug.log(fileString);
				return fileString;
			}
			catch (FileNotFoundException ex)
			{
				System.out.println("ERROR - FileManager could not find the file specified");
			}
			catch (IOException ex)
			{
				System.out.println("ERROR - FileManager could not read from the buffer from secure file");
			}
		}

		return "";
	}

	/*public static int writeSecureFile(String relativeFilePath, String data)
	{
		File file = new File(relativeFilePath);
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			} catch (IOException ex)
			{
				System.out.println("ERROR - FileManager could not create new file for path specified");
				return -1;
			}
		}

		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			byte[] encryptedData = Base64.getEncoder().encode(data.getBytes());
			bw.write(new String(encryptedData));

			bw.flush();
			bw.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("ERROR - FileManager could not find the specified file");
			return -1;
		}
		catch (IOException ex)
		{
			System.out.println("ERROR - FileManager could not create file writer for specified file");
			return -1;
		}
		return 0;
	}*/

	/*public static String readSecureFile(String relativeFilePath)
	{
		File file = new File(relativeFilePath);
		if(file.exists()){
			try
			{
				String encryptedString = "";
				BufferedReader br = new BufferedReader(new FileReader(file));

				String readString = "";
				while((readString = br.readLine()) != null)
				{
					encryptedString += readString;
				}
				String decryptedString = new String(Base64.getDecoder().decode(encryptedString));

				br.close();
				return decryptedString;
			}
			catch (FileNotFoundException ex)
			{
				System.out.println("ERROR - FileManager could not find the file specified");
			}
			catch (IOException ex)
			{
				System.out.println("ERROR - FileManager could not read from the buffer from secure file");
			}
		}

		return "";
	}*/
}
