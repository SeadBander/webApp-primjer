import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Random;

@WebServlet (name = "GeneratorLozinke", urlPatterns = {"/generisi"})

public class GeneratorServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = resp.getWriter()) {
            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Generator lozinke</title>");
            out.println("<body>");
            out.println("<h1> Generisana lozinka: " + generatePasswort() + "</h1>");
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
        }
    }

    private String generatePasswort() {
        Random random = new Random();
        int duzinalozinke = 5+random.nextInt(11);
        String moguciKarakteri = "absdefghijklmnoprstABCD123456789!?";
        StringBuilder lozinkaSB = new StringBuilder();
        for (int i = 0; i<duzinalozinke; i++){
            int slucajnaPozicija = random.nextInt(moguciKarakteri.length());
            char slucajniKarakter = moguciKarakteri.charAt(slucajnaPozicija);
            lozinkaSB.append(slucajniKarakter);
        }
        return lozinkaSB.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
