package co.eju.prj.comm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {//dao data access object
	private static DataSource dataSource = new DataSource(); //singleton클래스
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	//database에서 다룰 매개변수들
	
	private DataSource() { config();}
	//singleton 클래스로 외부에서 생성자를 만들지 못하도록 하기위함.
		
	public static DataSource getInstance() {
		return dataSource;
	}
	//db.properties를 읽어오자
	private void config() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();//resource파일을 읽겠다는 뜻
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		}catch(IOException e) { //file을 읽어들여야하니까 필요
			e.printStackTrace();
		}
	}
	
	//connection을 얻어오자
	public Connection getConnection() {
//		config(); //config()메소드를 호츨해와야함
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
