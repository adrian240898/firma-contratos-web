import java.security.*;
import java.util.Base64;

public class FirmaApp {

    public static void main(String[] args) {
        try {
            // Generar par de claves
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            // Texto a firmar
            String texto = "Este es un mensaje de prueba";

            // Firmar
            Signature firma = Signature.getInstance("SHA256withRSA");
            firma.initSign(pair.getPrivate());
            firma.update(texto.getBytes());
            byte[] firmaBytes = firma.sign();

            // Mostrar resultado
            System.out.println("Texto original: " + texto);
            System.out.println("Firma digital (Base64): " + Base64.getEncoder().encodeToString(firmaBytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
