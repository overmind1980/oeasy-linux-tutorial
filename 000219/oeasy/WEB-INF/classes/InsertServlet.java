import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class InsertServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException{
		String topic = request.getParameter("topic");
		String url = request.getParameter("url");
		Connection c = null;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/oeasy",
						"postgres", "oeasy@linux");
			Statement stmt = c.createStatement();
		    String sql = "insert into urls(topic,url) values('"+topic+"','"+url+"')";
			stmt.executeUpdate(sql);
			System.out.println("======"+sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
}
