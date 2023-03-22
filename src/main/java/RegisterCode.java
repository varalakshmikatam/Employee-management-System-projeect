

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
 * Servlet implementation class RegisterCode
 */
@WebServlet("/RegisterCode")
public class RegisterCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCode() {
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
		String gender=request.getParameter("gender");
		long mobilenumber=Long.parseLong(request.getParameter("mobno"));
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String address=request.getParameter("add");


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vara","vara");
			PreparedStatement ps=con.prepareStatement("insert into empmanagement1 values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setLong(5,mobilenumber);
			ps.setString(6,state);
			ps.setString(7,country);
			ps.setString(8,address);

			int i=ps.executeUpdate();
			out.print(i+"one row is inserted");
		}
		catch(Exception e)
		{
			out.print(e);
		

		}

		
	}
}
