import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        /* Создаем сессию */
        HttpSession session = null;
        session = request.getSession();
        session.setAttribute("user", login);

        /* Создаем куки */
        Cookie loginCookie = new Cookie("login", login);
        loginCookie.setMaxAge(1);
        response.addCookie(loginCookie);
        response.sendRedirect("helloPage.jsp");

        try {
            DataBase.createUser(login, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
