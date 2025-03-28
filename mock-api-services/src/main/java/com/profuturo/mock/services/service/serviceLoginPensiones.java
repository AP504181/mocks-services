package com.profuturo.mock.services.service;

import com.profuturo.mock.services.dto.buscarcliente.rqtBuscarCliente;
import com.profuturo.mock.services.dto.entrada.*;
import com.profuturo.mock.services.dto.salida.pensiones.rqtRegistrarUsuarioPensiones;

public interface serviceLoginPensiones {
    Object  validarAutenticacionPension(requestValidarAutenticacionPension request);
    Object  cambiarContrasena(requestCambiarContrasena request);
    Object  recuperarContrasena(requestRecuperarContrasena request);
    Object  actualizarPassword(rqtActualizarPassword request);
    Object  autenticaUsuarioPensiones(rqtautenticaUsuarioPensiones request);
    Object  enviarfoliosmsuniv(rqtenviarFolioSmsUniv request);
    Object validarFolioSmsUniv(rqtValidarFolioSmsUniv request);
    Object  registrarUsuarioPensiones(rqtRegistrarUsuarioPensiones request);
    Object  buscarPolizaPensiones(rqtbuscarPolizaPensiones request);
    Object  buscarCurpPensiones(rqtbuscarCurpPensiones request);

    ////
    Object  buscarCliente(rqtBuscarCliente request);
}
