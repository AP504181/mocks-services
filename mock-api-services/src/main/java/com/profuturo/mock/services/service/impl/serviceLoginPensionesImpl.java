package com.profuturo.mock.services.service.impl;

import com.profuturo.mock.services.controladores.LoginPensionesControlador;
import com.profuturo.mock.services.dto.entrada.requestValidarAutenticacionPension;
import com.profuturo.mock.services.dto.salida.error.ErrorRecurso;
import com.profuturo.mock.services.dto.salida.error.Error400;
import com.profuturo.mock.services.dto.salida.pensiones.responseValidarAutenticacion;
import com.profuturo.mock.services.dto.salida.pensiones.responseValidarAutenticacionSinUderId;
import com.profuturo.mock.services.service.serviceLoginPensiones;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class serviceLoginPensionesImpl implements serviceLoginPensiones {
    Logger logger = LogManager.getLogger(LoginPensionesControlador.class);

    @Override
    public Object validarAutenticacionPension(requestValidarAutenticacionPension request) {
        responseValidarAutenticacionSinUderId responseValidarAutenticacionSinUderId=new responseValidarAutenticacionSinUderId();
        responseValidarAutenticacionSinUderId.resultado=false;
        responseValidarAutenticacionSinUderId.status=200;

        if (request.getCorreo() == null || request.getPassword() == null) {
            Error400 error400response=new Error400();
            error400response.status=400;
            error400response.resultado=false;
            ErrorRecurso errorRecurso=new ErrorRecurso();
            errorRecurso.codigo="400";
            errorRecurso.descripcion="Correo y contraseña no pueden ser nulos";
            error400response.error=errorRecurso;
            return error400response;
        } else {
            try {
                if(request.getCorreo().equals("alfred.perez.yed@hotmail.com")){
                    return responseValidarAutenticacionSinUderId;
                }else{
                    responseValidarAutenticacion responseValidarAutenticacion=new responseValidarAutenticacion();
                    responseValidarAutenticacion.resultado=true;
                    responseValidarAutenticacion.status=200;
                    responseValidarAutenticacion.idUserOk="123456";
                    return responseValidarAutenticacion;

                }
            } catch (Exception e) {

            }


        }
        return responseValidarAutenticacionSinUderId;
    }
}
