import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloWorldExample extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
		throws IOException, ServletException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("你好,Tomcat!");
	}
}
