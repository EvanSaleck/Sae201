package fr.lannion.sae;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Arrivee {
    private int numresColumn;
    private int numchambColumn;
    private int nboccup;
    private int num;
    private String nom;
    private String date;

    public Arrivee(int numresColumn, int numchambColumn, int nboccup, int num, String nom, String date) {
        this.numresColumn = numresColumn;
        this.numchambColumn = numchambColumn;
        this.nboccup = nboccup;
        this.num = num;
        this.nom = nom;
        this.date = date;
    }

    public int getNumresColumn() {
        return numresColumn;
    }

    public int getNumchambColumn() {
        return numchambColumn;
    }

    public int getNboccup() {
        return nboccup;
    }

    public int getNum() {
        return num;
    }

    public String getDate() {
        return this.date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static LocalDate convertDateToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate convertDateToLocalDateOld(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }
}