package com.nextech.dscrm.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.nextech.dscrm.pojo.UserRequest;

/**
 * Servlet implementation class UserRequestServlet
 */
@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Inside goGet login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.sendRedirect("userRequest.jsp");
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String requirement = request.getParameter("requirementDescription");
	        String mobile = request.getParameter("mobile");
	 
	       /* try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = (Connection) DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/dscrm", "root", "root");
	 
	            PreparedStatement ps = ((java.sql.Connection) con)
	                    .prepareStatement("insert into USERREQUEST values(?,?,?,?)");
	 
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, requirement);
	            ps.setString(4, mobile);
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	                out.print("You are data inserted successfully..");
	 
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
	 
	       out.close();
	       // doGet(request, response);
		//request.getRequestDispatcher("/userrequest.jsp").forward(request, response);
	       // request.getRequestDispatcher("/userRequest.jsp").forward(request, response);
	        //System.out.println("Inside post login");
*/
	}
	
	public  void view() throws ClassNotFoundException
    {

        try
        {
            String sql="select * from USERREQUEST";
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm", "root", "root");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=((java.sql.Statement) stmt).executeQuery(sql);

            while(rs.next())
            {
                rs.getString("name");
                rs.getString("email");
                rs.getString("descritpion");
                rs.getString("mobile");
               System.out.println(rs.getString("name"));

            }

        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return;

    }

    public  String insertuser() throws SQLException
    {

        String sql = "insert into userrequest(name,email,requirementDescription,mobile) values(?,?,?,?)";
        Connection con = null;
        PreparedStatement prep = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
            prep = con.prepareStatement(sql);
            prep.setString(1, "name");
            prep.setString(2, "email");
            prep.setString(3, "requirement");
            prep.setString(4, "mobile");
            prep.executeUpdate();
            prep.close();

        } 
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return "successfully added";
    }
    public  String update() throws SQLException
    {

        String sql = "update userrequest set email=?,requirementDescription=?,mobile=? where name=?";
        Connection con = null;
        PreparedStatement prep = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm", "root", "android");
            prep = con.prepareStatement(sql);
            prep.setString(1, "name");
            prep.setString(2, "email");
            prep.setString(3, "requirement");
            prep.setString(4, "mobile");
            prep.executeUpdate();
            prep.close();

        } 
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return "successfully update";
    }

public  String delete() throws SQLException
{

    String sql = "delete form userrequest where name=?";
    Connection con = null;
    PreparedStatement prep = null;

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dscrm", "root", "root");
        prep = con.prepareStatement(sql);

    } 
    catch (ClassNotFoundException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }
    return "successfully delete";
}

}
