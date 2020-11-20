import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.io.*;
public class Connectionfactory {
	private static Connection connection=null;
	
	//singleton factory
	private Connectionfactory()
	{
		
	}
	
	public static Connection getConnection()
	{
		InputStream is=Connectionfactory
				.class
				.getClassLoader()
				.getResourceAsStream("db.properties");
		Properties properties=new Properties();
		try {
			properties.load(is);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String driver=properties.getProperty("db.driver");
		String url=properties.getProperty("db.url");
		String username=properties.getProperty("db.username");
		String password=properties.getProperty("db.password");
	//load the driver
	try
	{		
	Class.forName(driver);
	
	}
	catch(ClassNotFoundException ex)
	{		
		ex.printStackTrace();
	}
	
	try
	{

		connection =DriverManager.getConnection(url, username, password);
		
	}
	catch(SQLException e) {
		e.printStackTrace();

}
	return connection;
}
}
