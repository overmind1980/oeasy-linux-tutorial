import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.naming.*;
import com.mycompany.MyBean;
public class JNDIServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException
    {
        System.out.println("OeasyServlet begin====");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            MyBean bean = (MyBean) envCtx.lookup("bean/MyBeanFactory");

            out.println("foo = " + bean.getFoo() + ", bar = " +
                    bean.getBar());

        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("OeasyServlet end====");
    }
}
