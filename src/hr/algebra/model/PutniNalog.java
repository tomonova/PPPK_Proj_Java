package hr.algebra.model;

import java.time.LocalDateTime;

public class PutniNalog {
    private int iDNalog;
    private LocalDateTime otvaranje;
    private LocalDateTime zatvaranje;
    private int vozacID;
    private int voziloID;
    private int mjestoStartID;

    public PutniNalog(int iDNalog, LocalDateTime otvaranje, LocalDateTime zatvaranje, int vozacID, int voziloID, int mjestoStartID) {
        this.iDNalog = iDNalog;
        this.otvaranje = otvaranje;
        this.zatvaranje = zatvaranje;
        this.vozacID = vozacID;
        this.voziloID = voziloID;
        this.mjestoStartID = mjestoStartID;
    }

    public int getiDNalog() {
        return iDNalog;
    }

    public LocalDateTime getOtvaranje() {
        return otvaranje;
    }

    public void setOtvaranje(LocalDateTime otvaranje) {
        this.otvaranje = otvaranje;
    }

    public LocalDateTime getZatvaranje() {
        return zatvaranje;
    }

    public void setZatvaranje(LocalDateTime zatvaranje) {
        this.zatvaranje = zatvaranje;
    }

    public int getVozacID() {
        return vozacID;
    }

    public void setVozacID(int vozacID) {
        this.vozacID = vozacID;
    }

    public int getVoziloID() {
        return voziloID;
    }

    public void setVoziloID(int voziloID) {
        this.voziloID = voziloID;
    }

    public int getMjestoStartID() {
        return mjestoStartID;
    }

    public void setMjestoStartID(int mjestoStartID) {
        this.mjestoStartID = mjestoStartID;
    }

    @Override
    public String toString() {
        return "PutniNalog{" + "iDNalog=" + iDNalog + ", otvaranje=" + otvaranje + ", zatvaranje=" + zatvaranje + ", vozacID=" + vozacID + ", voziloID=" + voziloID + ", mjestoStartID=" + mjestoStartID + '}';
    }
    
}
