package ExamplesServlet;

import com.example.demo1.Declaration;
import com.example.demo1.Employeur;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Ajouter_Declaration")
public class DeclarationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_emp= req.getParameter("employeurId");
        String moi= req.getParameter("mois");
        String annee = req.getParameter("annee");
        String date = req.getParameter("dateDeclaration");
        int idemp= Integer.parseInt(id_emp);
        int mois= Integer.parseInt(moi);
        int anne= Integer.parseInt(annee);
        LocalDate dateNow= LocalDate.parse(date.toString());

        EntityManager et= jPA.getEntityManager();
        Employeur ep= et.find(Employeur.class,idemp);
        Declaration dr= new Declaration(idemp,mois,anne,dateNow,ep);

        try {
            et.getTransaction().begin();
            et.persist(dr);
            et.getTransaction().commit();
            resp.sendRedirect("index.jsp");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
