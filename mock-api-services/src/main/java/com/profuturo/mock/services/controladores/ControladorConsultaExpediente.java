package com.profuturo.mock.services.controladores;

import com.profuturo.mock.services.dto.consultaexpediente.requestConsultaExpediente0103;
import com.profuturo.mock.services.service.serviceLoginPensiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ControladorConsultaExpediente {
    Logger logger = LogManager.getLogger(LoginPensionesControlador.class);
    private final serviceLoginPensiones serviceloginpensiones;

    public ControladorConsultaExpediente(serviceLoginPensiones serviceloginpensiones) {
        this.serviceloginpensiones = serviceloginpensiones;
    }

    @PostMapping("/expediente-integral/procesar/consultaExpediente")
    public ResponseEntity<?> consultarconsultaExpediente(@RequestBody requestConsultaExpediente0103 request)  {
        Map<String, Object> response = new HashMap<>();
        try {
            Object  responseconsultarconsultaExpediente= serviceloginpensiones.consultarconsultaExpediente(request);
            return ResponseEntity.ok(responseconsultarconsultaExpediente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
        }
    }
}
