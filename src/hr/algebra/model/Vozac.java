package hr.algebra.model;

import java.util.Objects;

public class Vozac {
    private int iDVozac;
    private String ime;
    private String prezime;
    private String mobitel;
    private String vozackaDozvola;

    public Vozac(String ime, String prezime, String mobitel, String vozackaDozvola) {
        this.ime = ime;
        this.prezime = prezime;
        this.mobitel = mobitel;
        this.vozackaDozvola = vozackaDozvola;
    }

    public int getiDVozac() {
        return iDVozac;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMobitel() {
        return mobitel;
    }


    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public String getVozackDozvola() {
        return vozackaDozvola;
    }

    public void setVozackDozvola(String vozackaDozvola) {
        this.vozackaDozvola = vozackaDozvola;
    }
    
    @Override
    public String toString() {
        return "Vozac{" + "ime=" + ime + ", prezime=" + prezime + ", mobitel=" + mobitel + ", vozackDozvola=" + vozackaDozvola + '}';
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ime);
        hash = 97 * hash + Objects.hashCode(this.prezime);
        hash = 97 * hash + Objects.hashCode(this.vozackaDozvola);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vozac other = (Vozac) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.vozackaDozvola, other.vozackaDozvola)) {
            return false;
        }
        return true;
    }
}
