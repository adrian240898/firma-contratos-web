package com.proyecto.firmacontratos;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrato")
public class ContratoFirmaController {

    @PostMapping("/firmar")
    public ResponseEntity<String> firmarContrato(@RequestBody FirmaDTO firma) {
        if (firma.getFirmaJson() == null || firma.getIdContrato() == null) {
            return ResponseEntity.badRequest().body("Falta firma o ID de contrato");
        }
        // Simula guardar la firma y generar PDF firmado
        return ResponseEntity.ok("Contrato firmado correctamente");
    }
}
