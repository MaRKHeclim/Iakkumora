package Storage;

import Map.Section;

public class StorageAPI
{
	public enum SectionStorageMethod {
		FILE, MONGODB
	}
	
	SectionStorageMethod sectionStorageMethod;
	StoreToFile storeToFile;
	
	public StorageAPI(SectionStorageMethod mapStorageMethod)
	{
		this.sectionStorageMethod = mapStorageMethod;
	}
	
	public void store(Section sectionToStore)
	{
		switch(sectionStorageMethod)
		{
			case FILE:
				storeToFile.storeSection(sectionToStore);
				break;
			case MONGODB:
				
				break;
		}
	}
}
