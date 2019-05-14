package Storage;

import Map.Section;

public class StorageAPI
{
	//define possible values for the section storage method
	public enum SectionStorageMethod {
		FILE, //MONGODB
	}
	
	//storage methods for different data types
	SectionStorageMethod sectionStorageMethod;
	
	
	//Storage Method classes
	StoreToFile storeToFile;
	
	public StorageAPI()
	{
	
	}
	
	//Store sections of the map
	public void store(Section sectionToStore)
	{
		switch(sectionStorageMethod)
		{
			case FILE:
				storeToFile.storeSection(sectionToStore);
				break;
			//case MONGODB:
				
				//break;
		}
	}
	
	//load sections of the map
	public Section getSection(int x, int y)
	{
		//define a value to return
		Section returnSection;
		
		//get the value that needs to be returned from the correct source
		switch(sectionStorageMethod)
		{
			case FILE:
				returnSection = storeToFile.getSection(x, y);
				break;
			//case MONGODB:
			
			//break;
			default:
				returnSection = null;
				break;
		}
		
		//return the value
		return returnSection;
	}
	
	//set the method (FILE / MONGODB) of section storage
	public void setSectionStorageMethod(SectionStorageMethod sectionStorageMethod)
	{
		this.sectionStorageMethod = sectionStorageMethod;
	}
	
	//get the section storage method
	public SectionStorageMethod getSectionStorageMethod()
	{
		return this.sectionStorageMethod;
	}
}
