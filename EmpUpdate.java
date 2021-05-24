package simple;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 class EmpUpdate {

	public static void main(String[] args) {
		
   String dbURL="jdbc:mysql://localhost:3306/demovirtusa";
   String username="root";
   String password="";
   try {
	   Connection c=DriverManager.getConnection(dbURL,username,password);
	   if(c!=null)
	   {
		   System.out.print(" we got Connected....");
		   String sql = "UPDATE Employee SET empdesg='Sr.Software Engineer' where empage>25";
		   String sql1 = "select * from employee  where empage>25";
		
			Statement statement = c.createStatement();
		    ResultSet res=statement.executeQuery(sql1);
			int count=0;
			while(res.next()) {
			String empname=res.getString(2);
			String empdesg=res.getString(3);
			Integer empage=res.getInt(4);
			Integer empsalary=res.getInt(5);
			String out="User  #%d:%s-%s-%d-%d";
			System.out.printf(out,++count,empname,empdesg,empage,empsalary);
	   }
			PreparedStatement statement1 = c.prepareStatement(sql);
			
			/*statement.setString(1, "Mahi");
			statement.setString(2, "1354");
			statement.setString(3, "Mahesh");
			statement.setString(4, "Mahesh@gmail.com"); */
			int rowsUpdated = statement1.executeUpdate();
			if(rowsUpdated>0){
				System.out.print("Updated");
			}else
			{
				System.out.print("Not Updated");
			}
		}
	   else
	   {
		   System.out.print("uff we didn't get connected....");
	   }
   c.close();
   }
   catch(SQLException e)
   {
	  e.printStackTrace();
   }
   }
	}







