package by.epam.nb.util.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {
	private final static DBResourceManager instance = new DBResourceManager();
	private ResourceBundle bundle =	ResourceBundle.getBundle("by.epam.nb.util.connectionpool.db");
	
	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key){
		return bundle.getString(key);
	}
}