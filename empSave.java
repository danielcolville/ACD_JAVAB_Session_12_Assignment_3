package dbservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import books.DBConnection;

/**
 * Servlet implementation class empSave
 */
@WebServlet("/empSave")
public class empSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		con=DBConnection.getDBInstance();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public static void insertEmp(Connection con,String name,String em,String gr,String join) {
		String query="insert into `payroll`.employee (emp_name,email,name_grade,join_date) values"
				+ "('"+name+"','"+em+"','"+gr+"','"+join+"');";
		try {
			System.out.println(query);
			PreparedStatement st=con.prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nm=request.getParameter("name");
		String em=request.getParameter("em");
		String ng=request.getParameter("grade");
		String jd=request.getParameter("join");
		empSave.insertEmp(con,nm,em,ng,jd);
		response.setContentType("text/html");
		response.getWriter().append("Employee Saved Successfully ");
		response.getWriter().append("<meta http-equiv='refresh' content='5; url=http://localhost:8080/HelloWorld/employee.jsp'>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
