package ExamplesServlet;

import com.e_social.repository.EmployeurRepo;
import com.example.demo1.Employeur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Ajouter_Employeur")
public class EmployeurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        EmployeurRepo rep= new EmployeurRepo();
        if("list".equals(action)){
            List<Employeur> list =rep.findAll();
            req.setAttribute("employeurs",list);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String secteurAcive= req.getParameter("secteurActivite");

        String raisonSocial =req.getParameter("raisonSocial");

        Employeur emp = new Employeur(secteurAcive,raisonSocial);

        EmployeurRepo rep= new EmployeurRepo();

        rep.save(emp);
        resp.sendRedirect("Ajouter_Employeur?action=list");
    }
}
