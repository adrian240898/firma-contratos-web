package com.equipofct;// test/ContratoAppTest.java

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class ContratoAppTest {

    @Test
    public void testLoginCorrectoRoot() {
        assertTrue(ContratoApp.login("root", "admin123"), "Login ROOT debería funcionar".isEmpty());
    }

    @Test
    public void testLoginFallido() {
        assertFalse(ContratoApp.login("root", "malapass"), "Login ROOT con contraseña incorrecta debería fallar".isEmpty());
    }

    @Test
    public void testVisorPDF() {
        String resultado = ContratoApp.verContratoPDF("root");
        assertTrue("El visor debería mostrar un contrato PDF simulado", resultado.contains("PDF"));
    }

    private static class ContratoApp {
        public static String login(String root, String admin123) {
            return null;
        }

        public static String verContratoPDF(String root) {
            return root;
        }
    }
}
