package hr.algebra.utils;

import hr.algebra.model.Grad;
import hr.algebra.model.Vozac;
import hr.algebra.model.Vozilo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    private static final String DELIMITER = ",";

    public static List<Vozilo> ParseVozila(String filePath) {
        List<Vozilo> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String lajna = null;
            while ((lajna = br.readLine()) != null) {
                String[] vozilaString = lajna.split(DELIMITER);
                Vozilo vozilo = new Vozilo(vozilaString[0],
                        vozilaString[1],
                        LocalDate.parse(vozilaString[2]),
                        LocalDate.parse(vozilaString[3]),
                        Integer.parseInt(vozilaString[4]));
                lista.add(vozilo);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return lista;
    }

    public static List<Grad> ParseGradovi(String filePath) {
        List<Grad> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String lajna = null;
            while ((lajna = br.readLine()) != null) {
                String[] gradoviString = lajna.split(DELIMITER);
                Grad grad = new Grad(gradoviString[0],
                        Double.parseDouble(gradoviString[1]),
                        Double.parseDouble(gradoviString[2]),
                        Integer.parseInt(gradoviString[3]));
                lista.add(grad);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);;
        } catch (IOException ex) {
            System.err.println(ex);;
        }
        return lista;
    }
    public static List<Vozac> ParseVozaci(String filePath) {
        List<Vozac> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String lajna = null;
            while ((lajna = br.readLine()) != null) {
                String[] vozaciString = lajna.split(DELIMITER);
                Vozac vozac = new Vozac(vozaciString[0],
                vozaciString[1],
                vozaciString[2],
                vozaciString[3]);
                lista.add(vozac);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);;
        } catch (IOException ex) {
            System.err.println(ex);;
        }
        return lista;
    }
}
