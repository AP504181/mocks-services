package com.profuturo.mock.services.controladores;

import com.profuturo.mock.services.dto.entrada.requestCambiarContrasena;
import com.profuturo.mock.services.dto.entrada.requestRecuperarContrasena;
import com.profuturo.mock.services.dto.entrada.requestValidarAutenticacionPension;
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
@RequestMapping("/autenticacion-usuarios-pensiones/api/v1/acciones")
public class LoginPensionesControlador {

	Logger logger = LogManager.getLogger(LoginPensionesControlador.class);
	private final serviceLoginPensiones serviceloginpensiones;

	public LoginPensionesControlador(serviceLoginPensiones serviceloginpensiones) {
		this.serviceloginpensiones = serviceloginpensiones;
	}

	@PostMapping("/validar-autenticacion")
	public ResponseEntity<?> validadautenticacion(@RequestBody requestValidarAutenticacionPension request) {
		Map<String, Object> response = new HashMap<>();
		try {
			Object  responseautenticar = serviceloginpensiones.validarAutenticacionPension(request);
			return ResponseEntity.ok(responseautenticar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
		}
	}


	@PostMapping("/cambiar-contrasena")
	public ResponseEntity<?> cambiarcontrasena(@RequestBody requestCambiarContrasena request) {
		Map<String, Object> response = new HashMap<>();
		try {
			Object  responseautenticar = serviceloginpensiones.cambiarContrasena(request);
			return ResponseEntity.ok(responseautenticar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
		}
	}

	@PostMapping("/recuperarPassword")
	public ResponseEntity<?> recuperarPassword (@RequestBody requestRecuperarContrasena request) {
		Map<String, Object> response = new HashMap<>();
		try {
			Object  responseautenticar = serviceloginpensiones.recuperarContrasena(request);
			return ResponseEntity.ok(responseautenticar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
		}
	}

	@PostMapping("/actualizarPassword")
	public ResponseEntity<?> actualizarPassword (@RequestBody requestRecuperarContrasena request) {
		Map<String, Object> response = new HashMap<>();
		try {
			Object  responseautenticar = serviceloginpensiones.recuperarContrasena(request);
			return ResponseEntity.ok(responseautenticar);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
		}
	}
}

