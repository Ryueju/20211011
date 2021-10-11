package co.eju.prj.comm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {//dao data access object
	private static DataSource dataSource = new DataSource(); //singletonŬ����
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	//database���� �ٷ� �Ű�������
	
	private DataSource() { config();}
	//singleton Ŭ������ �ܺο��� �����ڸ� ������ ���ϵ��� �ϱ�����.
		
	public static DataSource getInstance() {
		return dataSource;
	}
	//db.properties�� �о����
	private void config() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();//resource������ �аڴٴ� ��
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		}catch(IOException e) { //file�� �о�鿩���ϴϱ� �ʿ�
			e.printStackTrace();
		}
	}
	
	//connection�� ������
	public Connection getConnection() {
//		config(); //config()�޼ҵ带 ȣ���ؿ;���
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
