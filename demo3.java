package simple;

	    
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
class demo3 {
	public static void main (String[]args) throws SQLException 
	{
	
		String url="jdbc:mysql://localhost:3306/demovirtusa";
	    String name="root";
	    String password="";
	    try
	    {
	    	Connection c=DriverManager.getConnection(url,name,password);
	    	if (c!=null)
	    	{
	    		System.out.println("output running ");
	    		String sql="INSERT INTO Employee(empname,empdesg,empage,empsalary) VALUES(?,?,?,?)";
	    		 PreparedStatement statement = c.prepareStatement(sql);
	                statement.setString(1, "Sarah");
	                statement.setString(2, "Admin");
	                statement.setInt(3, 30);
	                statement.setInt(4,55000);      
	                int rowsInserted =statement.executeUpdate();
	                if(rowsInserted>0) {
	                    System.out.print("inserted!!!!!!");
	    	}
	                else
	                {
	                	System.out.println("donne");
	                }
	                c.close();
	    	}
	    	else 
	    	{
	    		System.out.println("over");
	    	}
	    	c.close();
	}
	 /*  finally 
	   {
		   System.out.println("excution over");
	   }*/
	    catch(SQLException ex)
	    {
	    	 ex.printStackTrace();
	    }
	    }
}