package com.example.demo1;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "declaration")
public class Declaration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mois;
    private int annee;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "employeur_id")
    private Employeur employeur;
    @OneToMany(mappedBy="declaration")
    private List<Cotisation> cotisations;
    public Declaration(){}
    public Declaration(int id, int mois, int annee, LocalDate date, Employeur employeur) {
        this.id = id;
        this.mois = mois;
        this.annee = annee;
        this.date = date;
        this.employeur = employeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Employeur getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
    }
}
