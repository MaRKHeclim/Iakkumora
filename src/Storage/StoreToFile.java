package Storage;

import Map.Section;
import Tools.Debug;

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
	}
	
	public Section getSection(int x, int y)
	{
		return null;
	}
}
