package com.proyecto.firmacontratos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ContratoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testVerContratoPDF() throws Exception {
        mockMvc.perform(get("/contrato/view/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_PDF))
            .andExpect(header().string("Content-Disposition", "inline; filename=contrato.pdf"));
    }

    @Test
    void testGuardarDatosClienteOk() throws Exception {
        String json = "{\"nombre\":\"Juan\",\"apellidos\":\"Pérez\",\"dni\":\"12345678A\",\"email\":\"juan@example.com\",\"telefono\":\"600123456\"}";

        mockMvc.perform(post("/contrato/datos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().string("Datos guardados"));
    }

    @Test
    void testGuardarDatosClienteFaltanCampos() throws Exception {
        String json = "{\"apellidos\":\"Pérez\",\"email\":\"juan@example.com\"}";

        mockMvc.perform(post("/contrato/datos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isBadRequest())
            .andExpect(content().string("Campos obligatorios"));
    }
}
