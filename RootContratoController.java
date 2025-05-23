package com.proyecto.firmacontratos;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/root")
public class RootContratoController {

    @GetMapping("/contratos")
    public ResponseEntity<List<String>> listarContratos(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String fecha) {
        return ResponseEntity.ok(List.of("Contrato1.pdf", "Contrato2.pdf"));
    }

    @GetMapping("/contrato/{id}")
    public ResponseEntity<String> verContratoFirmado(@PathVariable Long id) {
        return ResponseEntity.ok("Contrato_firmado_" + id + ".pdf");
    }

    @PutMapping("/contrato/edit")
    public ResponseEntity<String> editarContrato(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok("Metadatos actualizados");
    }
}
