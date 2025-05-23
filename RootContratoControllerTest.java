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
public class RootContratoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testListarContratos() throws Exception {
        mockMvc.perform(get("/root/contratos"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testVerContratoFirmado() throws Exception {
        mockMvc.perform(get("/root/contrato/1"))
            .andExpect(status().isOk())
            .andExpect(content().string("Contrato_firmado_1.pdf"));
    }

    @Test
    void testEditarContrato() throws Exception {
        String json = "{\"nombre\":\"Ana\",\"apellidos\":\"Gómez\",\"dni\":\"98765432B\",\"email\":\"ana@example.com\",\"telefono\":\"700987654\"}";

        mockMvc.perform(put("/root/contrato/edit")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(content().string("Metadatos actualizados"));
    }
}
