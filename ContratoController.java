package com.proyecto.firmacontratos;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @GetMapping("/view/{id}")
    public ResponseEntity<byte[]> verContrato(@PathVariable Long id) {
        byte[] pdfData = "Fake PDF content".getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("contrato.pdf").build());
        return new ResponseEntity<>(pdfData, headers, HttpStatus.OK);
    }

    @PostMapping("/datos")
    public ResponseEntity<String> guardarDatosCliente(@RequestBody ClienteDTO cliente) {
        if (cliente.getNombre() == null || cliente.getDni() == null) {
            return ResponseEntity.badRequest().body("Campos obligatorios");
        }
        return ResponseEntity.ok("Datos guardados");
    }
}
