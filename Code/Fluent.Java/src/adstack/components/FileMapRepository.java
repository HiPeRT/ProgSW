package adstack.components;

import adstack.models.IMap;
import adstack.models.Map;

public class FileMapRepository {

	public FileMapRepository(String fileName) {
	}
	
	public IMap get(String city)
    {
        return new Map();
    }

}
