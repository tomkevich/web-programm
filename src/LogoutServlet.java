import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* удаляем сессию */
        HttpSession session = request.getSession();
        session.invalidate();

        /* удаляем куки */
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            loginCookie = cookie;
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("helloPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
