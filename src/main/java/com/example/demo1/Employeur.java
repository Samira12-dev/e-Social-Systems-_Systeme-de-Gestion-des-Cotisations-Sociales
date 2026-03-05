package com.example.demo1;

import jakarta.persistence.*;

@Entity
@Table(name = "employeur")
public class Employeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private static int count=0;
    @Column(name = "secteurActivite")
    private  String secteurActive;
    private  String raisonSocial;

    public Employeur(){}
    public Employeur( String secteurActive, String raisonSocial) {
        this.id = count++;
        this.secteurActive = secteurActive;
        this.raisonSocial = raisonSocial;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employeur.count = count;
    }

    public String getSecteurActive() {
        return secteurActive;
    }

    public void setSecteurActive(String secteurActive) {
        this.secteurActive = secteurActive;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }
}
