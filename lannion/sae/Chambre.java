package fr.lannion.sae;

import javafx.scene.layout.StackPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class Chambre {

    private int IDchambre;

    private int nbPersonne;

    private String categorie;

    private boolean estLibre;
    private String dateDebut;
    private String dateFin;

    public Chambre(int IDchambre, int nbPersonne, String categorie, String dateDebut, String dateFin) {
        this.IDchambre = IDchambre;
        this.nbPersonne = nbPersonne;
        this.categorie = categorie;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        if(estLibrePourDate(LocalDate.now())) this.estLibre = true;

    }

    public boolean estLibre() {
        return this.estLibre;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public boolean estLibrePourDate(LocalDate laDate) {
        LocalDate dateDebut = Arrivee.convertDateToLocalDate(this.dateDebut);
        LocalDate dateFin = Arrivee.convertDateToLocalDate(this.dateFin);

        if((dateDebut.isBefore(laDate) || dateDebut.isEqual(laDate)) && dateFin.isAfter(laDate)) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean estLibrePourPeriode(LocalDate laDate1, LocalDate laDate2) {
        LocalDate dateDebut = Arrivee.convertDateToLocalDate(this.dateDebut);
        LocalDate dateFin = Arrivee.convertDateToLocalDate(this.dateFin);

        if((dateDebut.isBefore(laDate1) || dateDebut.isEqual(laDate1)) && dateFin.isAfter(laDate2)) {
            return false;
        }
        else {
            return true;
        }
    }

    public static ArrayList<LocalDate> getAllDatesInRange(LocalDate startDate, LocalDate endDate) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public static void main(String[] args) {
        ArrayList<LocalDate> list = getAllDatesInRange(Arrivee.convertDateToLocalDate("13-06-2023"), Arrivee.convertDateToLocalDate("2023-06-16"));

        System.out.println(list);
    }
}
