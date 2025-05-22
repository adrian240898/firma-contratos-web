
public class FormularioTest {
    public static void main(String[] args) {
        Formulario formulario = new Formulario();

        assert formulario.validarFormulario("Juan", "juan@example.com") : "Test 1 falló";
        assert !formulario.validarFormulario("", "juan@example.com") : "Test 2 falló";
        assert !formulario.validarFormulario("Juan", "juanexample.com") : "Test 3 falló";
        assert !formulario.validarFormulario(null, "juan@example.com") : "Test 4 falló";
        assert !formulario.validarFormulario("Juan", null) : "Test 5 falló";

        System.out.println("Todos los tests pasaron correctamente.");
    }
}
