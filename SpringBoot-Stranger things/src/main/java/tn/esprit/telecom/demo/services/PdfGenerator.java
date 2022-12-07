package tn.esprit.telecom.demo.services;

import com.lowagie.text.Document;

import com.lowagie.text.DocumentException;

import com.lowagie.text.Font;

import com.lowagie.text.FontFactory;

import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;

import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.CMYKColor;

import com.lowagie.text.pdf.PdfPCell;

import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.telecom.demo.entites.Equipe;
import tn.esprit.telecom.demo.entites.Etudiant;
import tn.esprit.telecom.demo.repositories.IDepartementRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PdfGenerator {
    @Autowired
    IDepartementRepository departementRepository;
    public void generateToEtudiant(List<Etudiant> etudiants, HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document

        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter

        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it

        document.open();

        // Creating font

        // Setting font style and size

        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        fontTiltle.setSize(20);

        // Creating paragraph

        Paragraph paragraph1 = new Paragraph("La liste des etudiants", fontTiltle);

        // Aligning the paragraph in the document

        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in the document

        document.add(paragraph1);

        // Creating a table of the 4 columns

        PdfPTable table = new PdfPTable(4);

        // Setting width of the table, its columns and spacing

        table.setWidthPercentage(100f);

        table.setWidths(new int[] {3,3,3,3});

        table.setSpacingBefore(5);

        // Create Table Cells for the table header

        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding of the table cell

        cell.setBackgroundColor(CMYKColor.BLUE);

        cell.setPadding(5);

        // Creating font

        // Setting font style and size

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell or  header

        // Adding Cell to table

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom et Prenom", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Option", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Departement", font));

        table.addCell(cell);

        // Iterating the list of students

        for (Etudiant etudiant: etudiants) {


            table.addCell(String.valueOf(etudiant.getIdetudiant()));


            table.addCell(etudiant.getNomE().concat(" ").concat(etudiant.getPrenomE()));


            table.addCell(String.valueOf(etudiant.getOption()));


            table.addCell(etudiant.getDepartement().getNomDepart());

        }

        // Adding the created table to the document

        document.add(table);

        // Closing the document

        document.close();

    }
    public void generateToEquipe(List<Equipe> equipes, HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document

        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter

        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it

        document.open();

        // Creating font

        // Setting font style and size

        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        fontTiltle.setSize(20);

        // Creating paragraph

        Paragraph paragraph1 = new Paragraph("La liste des equipes", fontTiltle);

        // Aligning the paragraph in the document

        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in the document

        document.add(paragraph1);

        // Creating a table of the 4 columns

        PdfPTable table = new PdfPTable(4);

        // Setting width of the table, its columns and spacing

        table.setWidthPercentage(100f);

        table.setWidths(new int[] {3,3,3,3});

        table.setSpacingBefore(5);

        // Create Table Cells for the table header

        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding of the table cell

        cell.setBackgroundColor(CMYKColor.BLUE);

        cell.setPadding(5);

        // Creating font

        // Setting font style and size

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);

        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell or  header

        // Adding Cell to table

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom d equipe", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Niveau", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Detail d equipe", font));

        table.addCell(cell);

        // Iterating the list of students

        for (Equipe equipe: equipes) {


            table.addCell(String.valueOf(equipe.getIdEquipe()));


            table.addCell(equipe.getNomEquipe());


            table.addCell(String.valueOf(equipe.getNiveau()));

            table.addCell(String.valueOf(equipe.getDetailEquipe()));


        }

        // Adding the created table to the document

        document.add(table);

        // Closing the document

        document.close();

    }
}
