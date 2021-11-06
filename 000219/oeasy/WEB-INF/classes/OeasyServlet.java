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
public class OeasyServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException{
		Connection c = null;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/oeasy",
						"postgres", "oeasy@linux");
			c.setAutoCommit(false);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from urls");
			while(rs.next()){
				String topic  = rs.getString("topic");
				String url = rs.getString("url");
		        out.print(topic + ":" + url);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
}
