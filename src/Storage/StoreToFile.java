package Storage;

import Map.Section;
import Tools.Debug;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static Tools.FileFunctions.writeFile;

public class StoreToFile
{
	String mapFilePath;
	
	public StoreToFile(FileParameters fileParameters)
	{
		mapFilePath = fileParameters.MapFilePath;
	}
	
	public void storeSection(Section sectionToStore)
	{
		Debug debug = new Debug("StoreToFile storeSection", true, false);
		debug.log("here: x: " + sectionToStore.getX() + " y: " + sectionToStore.getY());
		//debug.dumpObject(sectionToStore);

		//Name Section File
		String sectionFilePath = mapFilePath + "\\";
		if(sectionToStore.getX() < 0)
		{
			sectionFilePath += "x_minus_" + Math.abs(sectionToStore.getX());
		}
		else
		{
			sectionFilePath += "x_" + sectionToStore.getX();
		}
		if(sectionToStore.getY() < 0)
		{
			sectionFilePath += "_y_minus_" + Math.abs(sectionToStore.getY());
		}
		else
		{
			sectionFilePath += "_y_" + sectionToStore.getY();
		}
		sectionFilePath += ".txt";
		writeFile(sectionFilePath, new GsonBuilder().setPrettyPrinting().create().toJson(sectionToStore));
	}
	
	public Section getSection(int x, int y)
	{
		String sectionFilePath = mapFilePath + "\\";
		if(x < 0)
		{
			sectionFilePath += "x_minus_" + Math.abs(x);
		}
		else
		{
			sectionFilePath += "x_" + x;
		}
		if(y < 0)
		{
			sectionFilePath += "_y_minus_" + Math.abs(y);
		}
		else
		{
			sectionFilePath += "_y_" + y;
		}
		sectionFilePath += ".txt";
		//readFile(sectionFilePath);
		//regenerate/recreate section
		return null;
	}
}
