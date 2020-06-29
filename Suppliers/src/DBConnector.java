import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
private static Connection conn=null;
public static Connection getConnection() {
	try {
		Class.forName("org.h2.Driver");
		conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return conn;
}
public static MyModel SelectAll(String tableName) {
	String selsql="select * from "+tableName;
	conn=getConnection();
	MyModel model=null;
	ResultSet result=null;
	try {
		PreparedStatement state=conn.prepareStatement(selsql);
		result=state.executeQuery();
		model=new MyModel(result);
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return model;
}
public static MyModel Search(String field,String field1) {
	 String sql = "SELECT R.ID, Part_Name, Name, quantity\n" +
			 "FROM Suppliers_parts  R JOIN Parts P\n" +
			 "ON R.Part_id = P.Part_id\n" +
			 "JOIN Suppliers C\n" +
			 "ON R.SID = C.SID\n" +  
			 "WHERE QUANTITY"
			 + " like '%"+ field+ "%'" + " UNION "
			 + "SELECT R.ID, Part_Name, Name, quantity\n" +
			 "FROM Suppliers_parts  R JOIN Parts P\n" +
			 "ON R.Part_id = P.Part_id\n" +
			 "JOIN Suppliers C\n" +
			 "ON R.SID = C.SID\n" +  
			 "WHERE NAME"
			 + " like '%"+ field1+ "%'"; 				
	conn=getConnection();
	MyModel model=null;
	ResultSet result=null;
	try {
		PreparedStatement state=conn.prepareStatement(sql);
		result=state.executeQuery();
		model=new MyModel(result);
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return model;
}
public static MyModel Search1(String field) {
	 String sql = "SELECT R.ID, Part_Name, Name, quantity\n" +
			 "FROM Suppliers_parts  R JOIN Parts P\n" +
			 "ON R.Part_id = P.Part_id\n" +
			 "JOIN Suppliers C\n" +
			 "ON R.SID = C.SID\n" +  
			 "WHERE NAME"
			 + " like '%"+ field+ "%'"; 				
	conn=getConnection();
	MyModel model=null;
	ResultSet result=null;
	try {
		PreparedStatement state=conn.prepareStatement(sql);
		result=state.executeQuery();
		model=new MyModel(result);
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return model;
}
public static MyModel Search2(String field) {
	 String sql = "SELECT R.ID, Part_Name, Name, quantity\n" +
			 "FROM Suppliers_parts  R JOIN Parts P\n" +
			 "ON R.Part_id = P.Part_id\n" +
			 "JOIN Suppliers C\n" +
			 "ON R.SID = C.SID\n" +  
			 "WHERE PART_NAME"
			 + " like '%"+ field+ "%'"; 				
	conn=getConnection();
	MyModel model=null;
	ResultSet result=null;
	try {
		PreparedStatement state=conn.prepareStatement(sql);
		result=state.executeQuery();
		model=new MyModel(result);
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return model;
}
public static  ResultSet  getAllFromTable(String tname) {
	String sql="select * from "+tname;
	conn=getConnection();
	ResultSet reSet=null;
	try {
		PreparedStatement state=conn.prepareStatement(sql);
		reSet=state.executeQuery();
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	} catch (Exception e1) {
		// TODO: handle exception
		e1.printStackTrace();
	}
	return reSet;
}
public static MyModel SearchByField(String txt) {
	String selsql="select * from suppliers "+ " where suppliers.city=txt;";
	conn=getConnection();
	MyModel model=null;
	ResultSet result=null;
	try {
		PreparedStatement state=conn.prepareStatement(selsql);
		result=state.executeQuery();
		model=new MyModel(result);
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return model;
}


	
	
	
	
	
	
	
	
	
}
