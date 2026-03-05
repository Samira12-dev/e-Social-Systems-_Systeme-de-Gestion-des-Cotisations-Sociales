package com.example.demo1;
import jakarta.persistence.*;

@Entity
@Table(name = "assure")
public class Assure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    @Column(name="salaire_mensuel")
    private double salaireMensuel;

    @ManyToOne
    @JoinColumn(name="employeur_id")
    private Employeur employeur;

    public Assure(){}

    public Assure( String nom, double salaireMensuel, Employeur employeur) {

        this.nom = nom;
        this.salaireMensuel = salaireMensuel;
        this.employeur = employeur;
    }


    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getSalaireMensuel() { return salaireMensuel; }
    public void setSalaireMensuel(double salaireMensuel) { this.salaireMensuel = salaireMensuel; }

    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }
}
