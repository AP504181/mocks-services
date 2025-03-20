package com.profuturo.mock.services.controladores;

import com.profuturo.mock.services.dto.entrada.rqtbuscarCurpPensiones;
import com.profuturo.mock.services.dto.salida.pensiones.rqtRegistrarUsuarioPensiones;
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
@RequestMapping("/gestion-usuarios-pensiones/api/v1/acciones")
public class GestionUsuariosPensiones {

    Logger logger = LogManager.getLogger(LoginPensionesControlador.class);
    private final serviceLoginPensiones serviceloginpensiones;


    public GestionUsuariosPensiones(serviceLoginPensiones serviceloginpensiones) {
        this.serviceloginpensiones = serviceloginpensiones;
    }

    @PostMapping("/registrarUsuarioPensiones")
    public ResponseEntity<?> registrarUsuarioPensiones(@RequestBody rqtRegistrarUsuarioPensiones request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Object  responseautenticar = serviceloginpensiones.registrarUsuarioPensiones(request);
            return ResponseEntity.ok(responseautenticar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
        }
    }

    @PostMapping("/buscar-curp-pensiones")
    public ResponseEntity<?> buscarCurpPensiones(@RequestBody rqtbuscarCurpPensiones request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Object  responseautenticar = serviceloginpensiones.buscarCurpPensiones(request);
            return ResponseEntity.ok(responseautenticar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
        }
    }
}
