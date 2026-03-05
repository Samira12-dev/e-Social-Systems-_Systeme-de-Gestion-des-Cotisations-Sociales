package ExamplesServlet;

import com.example.demo1.Assure;
import com.example.demo1.Cotisation;
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

@WebServlet("/Ajouter_Cotisation")
public class CotisationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id_As= req.getParameter("assureId");
       String id_Dr= req.getParameter("declarationId");
       String salaireDeclare =req.getParameter("salaireDeclare");
       String cotSalariale =req.getParameter("cotSalariale");
       String cotPatronale =req.getParameter("cotPatronale");

       int id_as= Integer.parseInt(id_As);
       int id_dr= Integer.parseInt(id_Dr);
       double salaireDr= Double.parseDouble(salaireDeclare);
       double cotsalairy= Double.parseDouble(cotSalariale);
       double cotPartonal= Double.parseDouble(cotPatronale);
        EntityManager et= jPA.getEntityManager();
        Assure as= et.find(Assure.class,id_as);
        Declaration dl= et.find(Declaration.class,id_dr);

        Cotisation cotisation= new Cotisation(salaireDr,cotsalairy,cotPartonal,dl,as);

        try {
            et.getTransaction().begin();
            et.persist(cotisation);
            et.getTransaction().commit();
            resp.sendRedirect("index.jsp");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

