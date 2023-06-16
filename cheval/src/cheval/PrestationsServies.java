package cheval;

public class PrestationsServies {
    private String date;
    private String type;
    private String libelle;
    private int quantite;

    public PrestationsServies(String date, String type, String libelle, int quantite) {
        this.date = date;
        this.type = type;
        this.libelle = libelle;
        this.quantite = quantite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
