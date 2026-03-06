package ExamplesServlet;

import com.e_social.repository.DeclarationRepo;
import com.e_social.repository.EmployeurRepo;
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
import java.util.List;

@WebServlet("/Ajouter_Declaration")
public class DeclarationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String  action = req.getParameter("action");
DeclarationRepo declarationRepo = new DeclarationRepo();
if("list".equals(action)){
    List<Declaration> list =declarationRepo.findAll();
    req.setAttribute("declaration",list);
    req.getRequestDispatcher("index.jsp").forward(req, resp);

}
    }

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


        try {
            Employeur ep= new EmployeurRepo().findID(idemp);
            Declaration dr= new Declaration(idemp,mois,anne,dateNow,ep);
            DeclarationRepo declarationRepo= new DeclarationRepo();
            declarationRepo.save(dr);
            resp.sendRedirect("Ajouter_Declaration?action=list");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
