package ExamplesServlet;

import com.example.demo1.Assure;
import com.example.demo1.Employeur;
import e_Social.jpaUtil.jPA;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/Ajouter_assure")
public class AssureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String salaire = req.getParameter("salaire");
        String employeurId = req.getParameter("employeurId");

        double salaireValue = Double.parseDouble(salaire);
        int idEmp = Integer.parseInt(employeurId);

        EntityManager em = jPA.getEntityManager();

        try {
            em.getTransaction().begin();

            Employeur emp = em.find(Employeur.class, idEmp);

            Assure as = new Assure(nom, salaireValue, emp);

            em.persist(as);

            em.getTransaction().commit();
            resp.sendRedirect("index.jsp");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
}