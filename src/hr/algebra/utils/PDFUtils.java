/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.utils;

import hr.algebra.dao.SqlHandler;
import hr.algebra.dao.entity.PutniNalogEnt;
import hr.algebra.model.enums.PutniNalogStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.cfg.Environment;

/**
 *
 * @author TomoNova
 */
public class PDFUtils {

    private static final String naslovTeksta = "PUTNI NALOG - BORG GRUPA d.d.";

    public static String KreirajPDF(int putniNalogID, EntityManagerFactory emf) {
        String fileName = "Putni Nalog - " + putniNalogID + ".pdf";
        try (PDDocument pdfDocument = new PDDocument()) {
            PDPage page = new PDPage();
            pdfDocument.addPage(page);
            try (PDPageContentStream content = new PDPageContentStream(pdfDocument, page)) {
                PutniNalogEnt pn = SqlHandler.GetPutniNalog(putniNalogID, emf);
                PostaviNaslov(content);
                PostaviTekst(content, pn);
            }
            pdfDocument.save(fileName);
            pdfDocument.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return System.getProperty("user.dir") + "\\" + fileName;
    }

    private static String GenerirajPutniNalogTekst(PutniNalogEnt pn) {
        StringBuilder sb = new StringBuilder();
        sb.append("IDENTIFIKATOR NALOGA: " + pn.getIDNalog());
//        sb.append(System.lineSeparator());
        sb.append("STATUS NALOGA: " + PutniNalogStatus.values()[(pn.getStatusNaloga() - 1)]);
//        sb.append(System.lineSeparator());
        sb.append("Datum početka putovanja: " + pn.getOtvaranje());
//        sb.append(System.lineSeparator());
        sb.append("Datum kraja putovanja: " + pn.getZatvaranje());
//        sb.append(System.lineSeparator());
        sb.append(pn.getVoziloID());
//        sb.append(System.lineSeparator());
        sb.append(pn.getVozacID());
//        sb.append(System.lineSeparator());
        sb.append("Polazište: " + pn.getMjestoStartID());
//        sb.append(System.lineSeparator());
        sb.append("Odredište: " + pn.getMjestoCiljID());
        return sb.toString();
    }

    private static void PostaviNaslov(PDPageContentStream content) throws IOException {
        content.setFont(PDType1Font.HELVETICA_BOLD, 22);
        content.beginText();
        content.newLineAtOffset(130, 700);
        content.showText(naslovTeksta);
        content.endText();
    }

    private static void PostaviTekst(PDPageContentStream content, PutniNalogEnt pn) throws IOException {
        content.setFont(PDType1Font.COURIER, 14);
        content.beginText();
        List<String> tekstZaPdf = new ArrayList<>();
        content.newLineAtOffset(50, 600);
        String line1 = "IDENTIFIKATOR NALOGA: " + pn.getIDNalog();
        String line2 = "STATUS NALOGA: " + PutniNalogStatus.values()[(pn.getStatusNaloga() - 1)];
        String line3 = "Datum pocetka putovanja: " + pn.getOtvaranje().toString();
        String line4 = "Datum kraja putovanja: " + pn.getZatvaranje();
        String line5 = pn.getVoziloID().toString();
        String line6 = pn.getVozacID().toString();
        String line7 = "Polaziste: " + pn.getMjestoStartID();
        String line8 = "Odrediste: " + pn.getMjestoCiljID();
        tekstZaPdf.add(line1);
        tekstZaPdf.add(line2);
        tekstZaPdf.add(line3);
        tekstZaPdf.add(line4);
        tekstZaPdf.add(line5);
        tekstZaPdf.add(line6);
        tekstZaPdf.add(line7);
        tekstZaPdf.add(line8);
        List<String> uredanTekst = UrediTekst(tekstZaPdf);
        for (String line : uredanTekst) {
            content.showText(line);
            content.newLineAtOffset(0, -25);
        }
        content.endText();
    }

    private static List<String> UrediTekst(List<String> tekstZaPdf) {
        List<String> uredanTekst = new ArrayList<>();
        for (String line : tekstZaPdf) {
            line = line.replaceAll("\\n", "");
            line = line.replaceAll("\\r", "");
            line = line.replaceAll("ć", "c");
            line = line.replaceAll("č", "c");
            line = line.replaceAll("š", "s");
            line = line.replaceAll("đ", "dj");
            line = line.replaceAll("ž", "z");
            line = line.replaceAll("Ć", "C");
            line = line.replaceAll("Č", "C");
            line = line.replaceAll("Š", "S");
            line = line.replaceAll("Đ", "Dj");
            line = line.replaceAll("Ž", "Z");
            uredanTekst.add(line);
        }
        return uredanTekst;
    }
}
