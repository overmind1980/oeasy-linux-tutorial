import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Connection c = null;
        Statement stmt = null;
        try {
            c = DBConUtil.getConn();
            c.setAutoCommit(false);
            out.println("db connection is ok!!<br/>");
            stmt = c.createStatement();
            String Username = request.getParameter("username");
            String Password = request.getParameter("password");
            if(Username!=null&&Username.length()>10){
                System.out.println("=====yes username too loog");
                DBConUtil.close(c,null,stmt,null);
                response.sendRedirect("http://localhost:8080/oeasy/error?msg=usernameTooLong");
            }
            else{
                ResultSet rs = stmt.executeQuery("select * from login where Username='"+Username+"'");
                if(rs.next()){
                    DBConUtil.close(c,null,stmt,rs);
                    response.sendRedirect("http://localhost:8080/oeasy/error?msg=usernameExists");
                }
                else{
                    String sql = "insert into login(username,password) values('"+Username+"','"+Password+"');";
                    System.out.print("sql======================" + sql);
                    stmt.executeUpdate(sql);
                    DBConUtil.close(c,null,stmt,rs);
                    response.sendRedirect("http://localhost:8080/oeasy/select");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            response.sendRedirect("http://localhost:8080/oeasy/error?msg=err");
        }
    }
}
