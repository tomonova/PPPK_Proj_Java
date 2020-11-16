package hr.algebra;

import hr.algebra.dao.SqlHandler;
import hr.algebra.model.Grad;
import hr.algebra.model.Vozac;
import hr.algebra.model.Vozilo;
import hr.algebra.utils.CSVParser;
import java.util.List;

public class PPPK_Proj_DBInit {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\hr\\algebra\\resources\\";
        String gradoviFileName = "gradovi.csv";
        String vozilaFileName = "auti.csv";
        String vozaciFileName = "vozaci.csv";

        List<Grad> gradoviLista = CSVParser.ParseGradovi(path + gradoviFileName);
        List<Vozilo> vozilaLista = CSVParser.ParseVozila(path + vozilaFileName);
        List<Vozac> vozaciLista = CSVParser.ParseVozaci(path + vozaciFileName);
        
        SqlHandler.insertDrzava("Rvacka");
        SqlHandler.insertGradovi(gradoviLista, 0, 50);
        SqlHandler.insertVozaci(vozaciLista,50);
        SqlHandler.insertVozila(vozilaLista,50);
    }
}
