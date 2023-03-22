

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCode
 */
@WebServlet("/UpdateCode")
public class UpdateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("pswd");
		String email=request.getParameter("email");
		long mobilenumber=Long.parseLong(request.getParameter("mobno"));
		String address=request.getParameter("add");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vara","vara");
			PreparedStatement ps=con.prepareStatement("update empmanagement1 set password=?,address=?,email=? where name=?");
			ps.setString(1,password);
			ps.setString(2,email);
			ps.setString(3,address);
			ps.setLong(4,mobilenumber);
			ps.setString(5,name);

			int i=ps.executeUpdate();
			out.print(i+"one record is updated");
		}
		catch(Exception e)
		{
			out.print(e);
		

		}

		
	}

	}
