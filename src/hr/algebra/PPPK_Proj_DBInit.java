package hr.algebra;

import hr.algebra.dao.SqlHandler;
import hr.algebra.dao.entity.GradEnt;
import hr.algebra.dao.entity.PutniNalogEnt;
import hr.algebra.model.Grad;
import hr.algebra.model.Vozac;
import hr.algebra.model.Vozilo;
import hr.algebra.utils.CSVParser;
import hr.algebra.utils.PDFUtils;
import hr.algebra.utils.ScannerUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PPPK_Proj_DBInit {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\hr\\algebra\\resources\\";
        String gradoviFileName = "gradovi.csv";
        String vozilaFileName = "auti.csv";
        String vozaciFileName = "vozaci.csv";

        List<Grad> gradoviLista = CSVParser.ParseGradovi(path + gradoviFileName);
        List<Vozilo> vozilaLista = CSVParser.ParseVozila(path + vozilaFileName);
        List<Vozac> vozaciLista = CSVParser.ParseVozaci(path + vozaciFileName);

        //SqlHandler.insertDrzava("Rvacka");
        //SqlHandler.insertGradovi(gradoviLista, 0, 50);
        //SqlHandler.insertVozaci(vozaciLista,50);
        //SqlHandler.insertVozila(vozilaLista,50);
        HibernateDemo();
        
    }

    private static Boolean PotvrdiDaNalogPostoji(int putniNalogID, List<PutniNalogEnt> lista) {
        for (PutniNalogEnt putniNalogEnt : lista) {
            if (putniNalogID == putniNalogEnt.getIDNalog()) {
                return true;
            }
        }
        return false;
    }

    private static void HibernateDemo() {
        EntityManagerFactory emf = null;
        List<PutniNalogEnt> lista = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            emf = Persistence.createEntityManagerFactory("PPPK_Proj_JavaPU");
            char again;
            do {
                System.out.println("Popis putnih naloga:");
                lista = SqlHandler.DohvatiPutneNaloge(emf);
                lista.forEach(System.out::println);
                int putniNalogID = ScannerUtils.readInt("Odaberite ID putnog naloga kojeg želite pretvoriti u PDF: ", scanner);
                if (!PotvrdiDaNalogPostoji(putniNalogID, lista)) {
                    System.out.println("Niste unjeli ispravan ID putnog naloga!!");
                }else{
                    String pdfKreiranje=PDFUtils.KreirajPDF(putniNalogID,emf);
                    System.out.println("PDF je spremljen u: "+pdfKreiranje);
                }
                again = ScannerUtils.readChar("Želite ponovno? (d/n): ", scanner);
            } while (again == 'd');

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
    }
}
