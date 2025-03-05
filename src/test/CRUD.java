package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class CRUD {
	public static void main(String[] args) {
		 Connection con=null;
		 Statement st=null;
	     PreparedStatement ps=null;
	     ResultSet rs=null;
	     
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME IN DATABASE SERVERE");System.out.println();
		System.out.println("What you want to do..\nChoose the options ------> ");
		System.out.println("1 : Insert\n2 : Update\n3 : Find\n4 : Delete\n5 : Fetch all data");
		String ex="exit";
		int input=sc.nextInt();
		
		while(input!=6) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company?user=root&&password=root");
			switch (input) {
//			insert the record in table......
			case 1:{
				    ps=con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
					System.out.println("Enter the emp id : " );
					int id=sc.nextInt();
					System.out.println("Enter the emp name : " );
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Enter the emp salary : " );
					double sal=sc.nextDouble();
					System.out.println("enter address :");
					String add=sc.next();
					System.out.println("enter contact : ");
					String no=sc.next();
					System.out.println("enter department :");
					String dept=sc.next();
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setDouble(3, sal);
					ps.setString(4, add);
					ps.setString(5, no);
					ps.setString(6,dept);
					ps.executeUpdate();
					System.out.println("record inserted succesfully....");
			}
			break;
			
//			update the record based on eid.......
			case 2: {
				 ps=con.prepareStatement("update emp set ename=?,esal=?,eaddress=?,econtact=? where eid=?");
				 System.out.println("enter id number of the record  which you want to update : ");
				 int id=sc.nextInt();
				 ps.setInt(5, id);
				 
				 System.out.println("enter updated name :");
				 String name=sc.next();
				 ps.setString(1, name);
				 
				 System.out.println("enter updated salary :");
				 double sal=sc.nextInt();
				 ps.setDouble(2, sal);
				 
				 
				 System.out.println("enter updated address :");
				 sc.nextLine();
				 String add=sc.nextLine();
				 ps.setString(3, add);
				 
				 System.out.println("enter updated contact :");
				 String no=sc.next();
				 ps.setString(4, no);
				
				ps.executeUpdate();
				System.out.println("succesfully updated succesfully....");
			}
			break;
			
//			find the record based on eid.......
			case 3:{
				System.out.println("enter id number which you want : ");
				ps=con.prepareStatement("select * from emp where eid=?");
				int eid=sc.nextInt();
				ps.setInt(1,eid);
				rs=ps.executeQuery();
				rs.next();
				System.out.println("emp ID : "+rs.getInt(1)+"\n emp Name : "+rs.getString(2)+"\n emp Salary : "+rs.getDouble(3)+"\n emp Address : "+rs.getString(4)+"\n emp contact : "+rs.getInt(5)+"\n emp Department : "+rs.getString(6));
				
			}
			break;
			
//			delet the record based on eid.......
			case 4:{
				System.out.println("enter id number which you want delete : ");
				int id=sc.nextInt();
				ps=con.prepareStatement("delete from emp where eid = ?");
				ps.setInt(1, id);
				ps.executeUpdate();
				System.out.println("deleted succesfully");
			}
			break;
			
//			fetch all the records.....
			case 5:{
			 st=con.createStatement();
		     	rs=st.executeQuery("select * from emp");
				while(rs.next()) {
					System.out.println("emp ID : "+rs.getInt(1)+"\n emp Name : "+rs.getString(2)+"\n emp Salary : "+rs.getDouble(3)+"\n emp Address : "+rs.getString(4)+"\n emp contact : "+rs.getInt(5)+"\n emp Department : "+rs.getString(6));
			}
			}
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println();
		System.out.println("What to do...");
		System.out.println("1 : Insert\n2 : Update\n3 : Find\n4 : delete\n5 : Fetch all data\n6 : Exit");
		 input=sc.nextInt();
		 if(input==6) System.out.println("exited from database...");
		}

	}

}

