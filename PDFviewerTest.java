package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

public class PdfViewerSmokeTest {

    @Test
    void loadValidPdf() throws Exception {
        // Generamos un PDF simple en tiempo de test
        Path temp = Files.createTempFile("test", ".pdf");
        // uso de PDFBox para crear un doc vacío
        try (var doc = new org.apache.pdfbox.pdmodel.PDDocument()) {
            doc.addPage(new org.apache.pdfbox.pdmodel.PDPage());
            doc.save(temp.toFile());
        }
        PdfViewer viewer = new PdfViewer();
        assertTrue(viewer.loadPdf(temp.toString()), "Debería cargar un PDF con al menos una página");
        Files.delete(temp);
    }

    @Test
    void loadNonexistentPdf() {
        PdfViewer viewer = new PdfViewer();
        assertFalse(viewer.loadPdf("no_existe.pdf"), "Debería fallar al cargar un PDF inexistente");
    }
}
