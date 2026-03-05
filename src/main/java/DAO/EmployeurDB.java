package DAO;

import com.example.demo1.DBConnection;
import com.example.demo1.Employeur;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeurDB {
    public void Enregistre(Employeur employeur){
        try {
            Connection cnx= DBConnection.geConnection();
            String sql="INSERT into employeur(secteurAcive,raisonSocial)values(?,?)";
            PreparedStatement ps =cnx.prepareStatement(sql);
            ps.setString(1,employeur.getSecteurActive());
            ps.setString(2,employeur.getRaisonSocial());
            ps.executeUpdate();
            ps.close();
            cnx.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
