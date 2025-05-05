package utils;

import org.json.JSONObject;

import models.Person;


/**
 * Mappers between datatypes are implemented here
 */
public class Mapper {

	
	public static Person mapToPerson(int id, JSONObject jsonObject) {
		String ageStr = jsonObject.getString("age");
		
		Person p = new Person();
		p.setId(id);
		p.setAge(Integer.parseInt(ageStr));
		
		return p;
	}
}
