package com.example.demo1;

import java.util.List;

public class CotisationService {
    private static final double tuax_partial = 0.04;
    private static final double taux_patronal = 0.06;
    private static final double PLAFOND = 6000;

    public Cotisation calculerCotisation(double salaire){

        double salaireUtilise = salaire;

        if(salaire > PLAFOND){
            salaireUtilise = PLAFOND;
        }

        double cotisationSalariale = salaireUtilise * tuax_partial;
        double cotisationPatronale = salaireUtilise * taux_patronal;

        Cotisation cot = new Cotisation();
        cot.setCotisation_salaire(cotisationSalariale);
        cot.setCoisation_patronale(cotisationPatronale);
        return cot;
    }
    public double calculTotalEmployeur(List<Cotisation> list){

        double total = 0;

        for(Cotisation c : list){

            total = total + c.getCoisation_patronale() + c.getCotisation_salaire();

        }

        return total;
    }
}
