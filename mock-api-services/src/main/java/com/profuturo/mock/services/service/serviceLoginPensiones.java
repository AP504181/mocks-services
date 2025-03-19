package com.profuturo.mock.services.service;

import com.profuturo.mock.services.dto.entrada.requestCambiarContrasena;
import com.profuturo.mock.services.dto.entrada.requestRecuperarContrasena;
import com.profuturo.mock.services.dto.entrada.requestValidarAutenticacionPension;

public interface serviceLoginPensiones {
    Object  validarAutenticacionPension(requestValidarAutenticacionPension request);
    Object  cambiarContrasena(requestCambiarContrasena request);
    Object  recuperarContrasena(requestRecuperarContrasena request);
}
