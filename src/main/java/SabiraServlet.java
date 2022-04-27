import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "sabiraServlet", urlPatterns = {"/sabra"})

public class SabiraServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String aText = req.getParameter("a");
        int a = aText != null && !aText.isBlank() ? Integer.parseInt(aText) : 0;
        String bText = req.getParameter("b");
        int b = bText != null && !bText.isBlank() ? Integer.parseInt(bText) : 0;
        int rezultat = a + b;
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Generator lozinke</title>");
            out.println("<body>");
            out.println("<h1> Rezultat sabiranja: " + rezultat + "</h1>");
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
        processRequest(req, resp);
    }
}
