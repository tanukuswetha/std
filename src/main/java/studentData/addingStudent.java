package studentData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class addingStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String stdid=request.getParameter("id");
       String first=request.getParameter("fname");
       String last=request.getParameter("lname");
       String email=request.getParameter("mail");
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
    PreparedStatement ps=con.prepareStatement("insert into dates values(?,?,?,?)");
    int x=Integer.parseInt(stdid);
    ps.setInt(1,x);
    ps.setString(2,first);
    ps.setString(3,last);
    ps.setString(4,email);
    
    int a=ps.executeUpdate();
    if (a>0)
    {
    	response.getWriter().println(a + " student record inserted!!");
       
    }
    else{
        PrintWriter out=response.getWriter();
        out.print("couldn't register please try again!!");
    }
 }
 catch(Exception e)
 {
     e.printStackTrace();
 }
	}

}
