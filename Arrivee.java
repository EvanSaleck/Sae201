package fr.lannion.sae;

public class Arrivee {
    private int reservationID;
    private int ChambreID;
    private int nbOccupants;
    private int clientID;
    private String clientName;

    public int getReservationID() {
        return reservationID;
    }

    public int getChambreID() {
        return ChambreID;
    }

    public int getNbOccupants() {
        return nbOccupants;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public Arrivee(int reservationID, int chambreID, int nbOccupants, int clientID, String clientName) {
        this.reservationID = reservationID;
        this.ChambreID = chambreID;
        this.nbOccupants = nbOccupants;
        this.clientID = clientID;
        this.clientName = clientName;
    }
}
