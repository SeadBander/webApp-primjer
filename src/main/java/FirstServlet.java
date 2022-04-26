import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FirstServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Prvi servlet</title>");
            out.println("<body>");
            out.println("Pozdrav iz PROG SERVLETA. Uspio si. Tacno vrijeme je: " + LocalDateTime.now());
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
