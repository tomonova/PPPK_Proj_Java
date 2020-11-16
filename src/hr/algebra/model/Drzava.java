package hr.algebra.model;

public class Drzava {
    private int iDDrzava;
    private String Naziv;

    public Drzava(int iDDrzava, String Naziv) {
        this.iDDrzava = iDDrzava;
        this.Naziv = Naziv;
    }

    public Drzava(String Naziv) {
        this.Naziv = Naziv;
    }

    public int getiDDrzava() {
        return iDDrzava;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    @Override
    public String toString() {
        return "Drzava{" + "iDDrzava=" + iDDrzava + ", Naziv=" + Naziv + '}';
    }
}
