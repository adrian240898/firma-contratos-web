
public class Formulario {
    public boolean validarFormulario(String nombre, String email) {
        return nombre != null && !nombre.isEmpty() && email != null && email.contains("@");
    }
}
