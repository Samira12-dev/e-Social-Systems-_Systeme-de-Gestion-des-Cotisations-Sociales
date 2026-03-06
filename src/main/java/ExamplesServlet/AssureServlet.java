package ExamplesServlet;

import com.e_social.repository.AssureRepo;
import com.e_social.repository.EmployeurRepo;
import com.example.demo1.Assure;
import com.example.demo1.Employeur;
import e_Social.jpaUtil.jPA;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/Ajouter_assure")
public class AssureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        AssureRepo repo = new AssureRepo();

        if ("list".equals(action)) {

            List<Assure> assures = repo.findAll();
            req.setAttribute("assures", assures);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String salaire = req.getParameter("salaire");
        String employeurId = req.getParameter("employeurId");

        double salaireValue = Double.parseDouble(salaire);
        int idEmp = Integer.parseInt(employeurId);

        try {
        Employeur emp = new EmployeurRepo().findID(idEmp);

        Assure as = new Assure(nom, salaireValue, emp);
        AssureRepo assureRepo = new AssureRepo();
         assureRepo.save(as);

          resp.sendRedirect("Ajouter_Assure?action=list");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}