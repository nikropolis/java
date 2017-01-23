package test_sql;

import java.sql.*;

public class Main {
	
	public static void main(String[] args){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c = DriverManager.getConnection("jdbc:odbc:test_Employee");
			Statement s = c.createStatement();

			s.executeUpdate("insert into employee values('name','Nick')");
			s.executeUpdate("insert into employee values('salary','10000')");
			c.commit();
			
			ResultSet rs = s.executeQuery("select * from employee");
			String str = "";
			
			while( rs.next() ){

				str += "["+ rs.getString(1) + "]";
				str += "["+ rs.getString(2) + "]";
				str += "["+ rs.getString(3) + "]";
				str += "["+ rs.getString(4) + "]";
				System.out.println(str);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
