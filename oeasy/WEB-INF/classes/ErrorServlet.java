import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><body>");
        String ErrorMessage = request.getParameter("msg");
        System.out.print("==="+ErrorMessage+"==");
        if(null==ErrorMessage){
            out.print("出错了");
        }
        else if(ErrorMessage.equals("usernameExists")){
            out.print("这个用户名已经存在，请重新选择!");
        }
        else if(ErrorMessage.equals("usernameTooLong")){
            out.print("用户名太长了,不能超过十个字符");
        }
        else if(ErrorMessage.equals("err")){
            out.print("出错了");
        }
        out.print("<a href=\"./prepareInsert.html\">返回注册页面</a>");
        out.println("</body></html>");
    }
}

