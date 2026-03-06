package ExamplesServlet;

import com.e_social.repository.AssureRepo;
import com.e_social.repository.CotisationRepo;
import com.e_social.repository.DeclarationRepo;
import com.example.demo1.*;
import e_Social.jpaUtil.jPA;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Ajouter_Cotisation")
public class CotisationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        CotisationRepo cotisationRepo= new CotisationRepo();
        if("list".equals(action)){
            List<Cotisation> cotisationList=cotisationRepo.findAll();
            req.setAttribute("cotisation",cotisationList);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }

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

                try {
                    Assure as= new  AssureRepo().findId(id_as);
                    Declaration dl= new DeclarationRepo().findId(id_dr);

                    CotisationService service=new CotisationService();
                    Cotisation cotisation =service.calculerCotisation(salaireDr);

                    cotisation.setAssure(as);
                    cotisation.setDeclaration(dl);
                    cotisation.setSalaire_declare(salaireDr);

                    CotisationRepo cotisationRepo= new CotisationRepo();
                    cotisationRepo.save(cotisation);
                 resp.sendRedirect("Ajouter_Cotisation?action=list");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

