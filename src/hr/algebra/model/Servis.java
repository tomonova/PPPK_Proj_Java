package hr.algebra.model;

import java.time.LocalDate;

public class Servis {
    private int iDServis;
    private int voziloID;
    private LocalDate datum;
    private double trosak;

    public Servis(int iDServis, int voziloID, LocalDate datum) {
        this.iDServis = iDServis;
        this.voziloID = voziloID;
        this.datum = datum;
    }

    public int getiDServis() {
        return iDServis;
    }


    public int getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(int voziloID) {
        this.voziloID = voziloID;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getTrosak() {
        return trosak;
    }

    public void setTrosak(double trosak) {
        this.trosak = trosak;
    }
    
    @Override
    public String toString() {
        return "Servis{" + "iDServis=" + iDServis + ", voziloID=" + voziloID + ", datum=" + datum + ", trosak=" + trosak + '}';
    }
    
}
