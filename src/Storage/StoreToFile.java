package Storage;

import Map.Section;
import Tools.Debug;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static Tools.FileFunctions.writeFile;

public class StoreToFile
{
	String mapFilePath;
	//index file:
	/*
	[
	{x, y, line},
	{x, y, line},
	.
	.
	.
	]
	 */
//	ArrayList<StoreToFileIndexEntry> Index = new ArrayList<StoreToFileIndexEntry>();
	//map file:
	/*
	[
	{Section 1},
	{Section 2}
	.
	.
	.
	]
	 */
	public StoreToFile(FileParameters fileParameters)
	{
		mapFilePath = fileParameters.MapFilePath;
	}
	
	public void storeSection(Section sectionToStore)
	{
		Debug debug = new Debug("StoreToFile storeSection", true, false);
		debug.log("here: x: " + sectionToStore.getX() + " y: " + sectionToStore.getY());
		//debug.dumpObject(sectionToStore);
		
		//IndexEntry:
//		debug.log(Index.size() + "");
//		Index.add(new StoreToFileIndexEntry(sectionToStore.getX(), sectionToStore.getY(), Index.size()));
		//debug.dumpObject(Index);
//		writeFile(mapFilePath + "Index.txt", new GsonBuilder().setPrettyPrinting().create().toJson(Index));
		
		//Name Section File
		String sectionFilePath = mapFilePath + "\\";
		if(sectionToStore.getX() < 0)
		{
			sectionFilePath += "x_minus_" + sectionToStore.getX();
		}
		else
		{
			sectionFilePath += "x_" + sectionToStore.getX();
		}
		if(sectionToStore.getY() < 0)
		{
			sectionFilePath += "_y_minus_" + sectionToStore.getY();
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
		return null;
	}
	/*
	private class StoreToFileIndexEntry
	{
		private int x;
		private int y;
		private int line;
		
		StoreToFileIndexEntry(int x, int y, int line)
		{
			this.x = x;
			this.y = y;
			this.line = line;
		}
		
		public int getX()
		{
			return x;
		}
		
		public int getY()
		{
			return y;
		}
		
		public int getLine()
		{
			return line;
		}
		
		public void setLine(int line)
		{
			this.line = line;
		}
	}
	*/
}
