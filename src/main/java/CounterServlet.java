import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@WebServlet (name = "brojac", urlPatterns = {"/count"})

public class CounterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        ServletContext context = getServletContext();
        Counter totalcounter = (Counter) context.getAttribute("total");
        if (totalcounter==null){
            totalcounter = new Counter();
            context.setAttribute("total", totalcounter);
        }
        totalcounter.increment();

        HttpSession session = req.getSession();
        String sessionID = session.getId();
        Counter pojedinacniCounter = (Counter) session.getAttribute("pojedinacni");
        if (pojedinacniCounter==null){
            pojedinacniCounter = new Counter();
            context.setAttribute("pojedinacni", pojedinacniCounter);
        }
        pojedinacniCounter.increment();

        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Brojac</title>");
            out.println("<body>");
            out.println("<h2>Ukupan broj posjeta je: " +totalcounter.getCount()+ "</h2>");
            out.println("<h2>Pojedinačni broj posjeta je: " +pojedinacniCounter.getCount()+ "</h2>");
            out.println("<h3>SessionID/Cookie je: " +sessionID+ "</h3>");
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
        }
    }
}



