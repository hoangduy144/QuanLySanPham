package hcmus.edu.vn.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerService {
	protected Connection conn=null;
	public SQLServerService()
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl=
					"jdbc:sqlserver://DESKTOP-QA475V7\\SQLEXPRESS:1433;"
							+ "user=sa;password=123456;databaseName=dbQuanLySanPham;"
							+ "integratedSecurity=true;encrypt=false";
			conn= DriverManager.getConnection(connectionUrl);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
