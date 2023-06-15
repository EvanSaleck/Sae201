package fr.lannion.sae;

public class Client {
    private int id;
    static int nbClients = 0;
    private String nom;

    public Client(String nom) {
        nbClients++;
        this.id = nbClients;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public static void main(String[] args) {
        Client jean = new Client("jean");
        Client baba = new Client("baba");
    }
}
