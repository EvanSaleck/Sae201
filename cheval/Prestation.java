package cheval;

import java.time.LocalDate;

import javafx.beans.property.*;

public class Prestation {


	    private String libelle;
	    private String type;
	    private double prix;
	    private LocalDate date;

	    public Prestation(String libelle, String type, double prix, LocalDate date2)
	            throws LibelleInvalideException, TarifInvalideException {
	        if (!estLibelleValide(libelle)) {
	            throw new LibelleInvalideException("Le libellé de la prestation est invalide.");
	        }

	        if (!estTarifValide(prix)) {
	            throw new TarifInvalideException("Le tarif de la prestation est invalide.");
	        }

	        this.libelle = libelle;
	        this.type = type;
	        this.prix = prix;
	        this.date = date2;
	    }

	    // Méthodes getters et setters pour les propriétés observables

	    public String getLibelle() {
	        return libelle;
	    }

	    public void setLibelle(String libelle) {
	        this.libelle = libelle;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public double getPrix() {
	        return prix;
	    }

	    public void setPrix(double prix) {
	        this.prix = prix;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }


        private boolean estLibelleValide(String libelle) {
            return libelle.matches("[a-zA-Z0-9]+");
        }

        private boolean estTarifValide(double prix) {
            return prix >= 0 && prix <= 999;
        }
    }


