package com.example.demo1;

import jakarta.persistence.*;

@Entity
@Table(name = "cotisation")
public class Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  int count=0;
    private double salaire_declare;
    private double  cotisation_salaire;
    private double coisation_patronale;

    @ManyToOne
    @JoinColumn(name = "declaration_id")
    private Declaration declaration;

    @ManyToOne
    @JoinColumn(name = "assure_id")
    private Assure assure;
     public Cotisation(){}

    public Cotisation(double salaire_declare, double cotisation_salaire,
                      double coisation_patronale, Declaration declaration, Assure assure) {
        this.id = count++;
        this.salaire_declare = salaire_declare;
        this.cotisation_salaire = cotisation_salaire;
        this.coisation_patronale = coisation_patronale;
        this.declaration = declaration;
        this.assure = assure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalaire_declare() {
        return salaire_declare;
    }

    public void setSalaire_declare(double salaire_declare) {
        this.salaire_declare = salaire_declare;
    }

    public double getCotisation_salaire() {
        return cotisation_salaire;
    }

    public void setCotisation_salaire(double cotisation_salaire) {
        this.cotisation_salaire = cotisation_salaire;
    }

    public double getCoisation_patronale() {
        return coisation_patronale;
    }

    public void setCoisation_patronale(double coisation_patronale) {
        this.coisation_patronale = coisation_patronale;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }
}
