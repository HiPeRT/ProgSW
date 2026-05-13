package thirdparty;

/**
 * MongoDb library
 */
public class MongoDb {


	public void externalUpdateBirth(int key, int age) throws Exception {
		System.out.println("Hello, I am an external MongoDb library! I am updating age ("+age+") for user with id '"+key+"'");
	}

}
