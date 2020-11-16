package hr.algebra.model;

import java.time.LocalDate;
import java.util.Objects;


public class Vozilo {
    private int iDVozilo;
    private String Marka;
    private String Model;
    private LocalDate godinaProizvodnje;
    private LocalDate godinaUnosa;
    private int inincijalniKM;

    public int getiDVozilo() {
        return iDVozilo;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String Marka) {
        this.Marka = Marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public LocalDate getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(LocalDate godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public LocalDate getGodinaUnosa() {
        return godinaUnosa;
    }

    public void setGodinaUnosa(LocalDate godinaUnosa) {
        this.godinaUnosa = godinaUnosa;
    }

    public int getInincijalniKM() {
        return inincijalniKM;
    }

    public void setInincijalniKM(int inincijalniKM) {
        this.inincijalniKM = inincijalniKM;
    }

    public Vozilo(String Marka, String Model, LocalDate godinaProizvodnje, LocalDate godinaUnosa, int inincijalniKM) {
        this.Marka = Marka;
        this.Model = Model;
        this.godinaProizvodnje = godinaProizvodnje;
        this.godinaUnosa = godinaUnosa;
        this.inincijalniKM = inincijalniKM;
    }

    @Override
    public String toString() {
        return "Vozilo{" + "Marka=" + Marka + ", Model=" + Model + ", godinaProizvodnje=" + godinaProizvodnje + ", godinaUnosa=" + godinaUnosa + ", inincijalniKM=" + inincijalniKM + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.Marka);
        hash = 71 * hash + Objects.hashCode(this.Model);
        hash = 71 * hash + Objects.hashCode(this.godinaProizvodnje);
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
        final Vozilo other = (Vozilo) obj;
        if (!Objects.equals(this.Marka, other.Marka)) {
            return false;
        }
        if (!Objects.equals(this.Model, other.Model)) {
            return false;
        }
        if (!Objects.equals(this.godinaProizvodnje, other.godinaProizvodnje)) {
            return false;
        }
        return true;
    }
    
    
}
