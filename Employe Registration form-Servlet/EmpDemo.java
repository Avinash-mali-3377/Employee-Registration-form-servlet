package jbkDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/emp_info")
public class EmpDemo extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	 String fname = request.getParameter("fname");
     String lname = request.getParameter("lname");
     int salary = Integer.parseInt(request.getParameter("salary"));
     String role = request.getParameter("role");
     String joinDate = request.getParameter("join_date");
     String experience = request.getParameter("experience");
     String city = request.getParameter("city");
     String country = request.getParameter("country");
     String email = request.getParameter("email");
//     int mobno =Integer.parseInt( request.getParameter("mobno"));
     long mobno = Long.parseLong(request.getParameter("mobno"));
     int age =Integer.parseInt( request.getParameter("age"));
     String maritalStatus = request.getParameter("marital_status");
     String dob = request.getParameter("dob");
     String password = request.getParameter("password");
     
     try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/204db","root","4828");
    	 PreparedStatement ps= c.prepareStatement("insert into emp_info (First_name,Last_name,salary,role,join_date,experience,City,Country,Email,Mobile_number,age,Marital_Status,DOB,Password)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	 ps.setString(1, fname);
    	 ps.setString(2, lname);
    	 ps.setLong(3, salary);
    	 ps.setString(4, role);
    	 ps.setString(5, joinDate);
    	 ps.setString(6, experience);
    	 ps.setString(7, city);
    	 ps.setString(8, country);
    	 ps.setString(9, email);
    	 ps.setLong(10, mobno);
    	 ps.setLong(11, age);
    	 ps.setString(12, maritalStatus);
    	 ps.setString(13, dob);
    	 ps.setString(14, password);
    	 ps.executeUpdate();
    	 
    	 PrintWriter out=response.getWriter();
    	 System.out.println("Your data has been Inserted ....");
    	 out.print("<h1>"+"Data has been inserted succesfully.."+"</h1>");
    	 c.close();    	 
     }catch (Exception e) {
		
	}
}
}
