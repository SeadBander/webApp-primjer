import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet (name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    static final String USERNAME = "admin@gmail.com";
    static final String PASSWORD = "admin";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, NoSuchAlgorithmException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hashPassword = generateHash(password);
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<body>");
            if (username.equals(USERNAME)&&password.equals(PASSWORD)){
                out.println("<h1>Korisnik je uspjesno logovan sa email adresom: " + USERNAME + " i sa passwordom: " + hashPassword +" </h1>");
            }else {
                out.println("<h1>Pogrešna email adresa ili password</h1>");
                out.println("<a href='http://localhost:8080/webAppFinal'>Pokušajte ponovo</a>");
            }
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
        }
    }
    private String generateHash (String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        return new String(messageDigest.digest(password.getBytes()));
    }
}
