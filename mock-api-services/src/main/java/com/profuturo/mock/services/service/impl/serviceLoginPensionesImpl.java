package com.profuturo.mock.services.service.impl;

import com.profuturo.mock.services.controladores.LoginPensionesControlador;
import com.profuturo.mock.services.dto.entrada.*;
import com.profuturo.mock.services.dto.entrada.buscarpoliza.Beneficiario;
import com.profuturo.mock.services.dto.entrada.buscarpoliza.Titular;
import com.profuturo.mock.services.dto.entrada.buscarpoliza.responseBuscarPoliza;
import com.profuturo.mock.services.dto.entrada.buscarpoliza.responseErrorBuscarPoliza;
import com.profuturo.mock.services.dto.salida.CuentaConRegistro;
import com.profuturo.mock.services.dto.salida.error.ErrorRecurso;
import com.profuturo.mock.services.dto.salida.error.Error400;
import com.profuturo.mock.services.dto.salida.pensiones.*;
import com.profuturo.mock.services.dto.salida.responseBuscarCurpPensiones;
import com.profuturo.mock.services.dto.salida.responseErrorBuscarCurpPensiones;
import com.profuturo.mock.services.service.serviceLoginPensiones;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                    responseValidarAutenticacion.idUserOk="00uoobnpfvY3RSBlE697";
                    return responseValidarAutenticacion;

                }
            } catch (Exception e) {

            }


        }
        return responseValidarAutenticacionSinUderId;
    }

    @Override
    public Object cambiarContrasena(requestCambiarContrasena request) {
       if(request.correo.equals("")){
           Error400 error400response=new Error400();
           error400response.status=400;
           error400response.resultado=false;
           ErrorRecurso errorRecurso=new ErrorRecurso();
           errorRecurso.codigo="400";
           errorRecurso.descripcion="Correo y contraseña no pueden ser nulos";
           error400response.error=errorRecurso;
           return error400response;
        }else{
            if(request.correo.equals("luisramon2099@hotmail.com")){
                responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
                responseCambiarContrasena.resultado=true;
                responseCambiarContrasena.status=200;
                return responseCambiarContrasena;
            }
            if(request.correo.equals("alfred.perez.yed@hotmail.com")){
                responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
                responseErrorCambiarContrasena.resultado=false;
                responseErrorCambiarContrasena.status=200;
                responseErrorCambiarContrasena.descripcionError="Fallo Cambio Contraseña";
                return responseErrorCambiarContrasena;
           }
           if(request.correo.equals("alfredo.perez@hotmail.com")){
               responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
               responseErrorCambiarContrasena.resultado=false;
               responseErrorCambiarContrasena.status=200;
               responseErrorCambiarContrasena.descripcionError="Fallo Busqueda";
               return responseErrorCambiarContrasena;
           }
           else {
               responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
               responseCambiarContrasena.resultado=true;
               responseCambiarContrasena.status=200;
               return responseCambiarContrasena;
           }
       }

    }

    @Override
    public Object recuperarContrasena(requestRecuperarContrasena request) {
        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            if(request.rqt.curp.equals("PEAL950202HDFRRL00")){
                responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
                responseCambiarContrasena.resultado=true;
                responseCambiarContrasena.status=200;
                return responseCambiarContrasena;
            }
            if(request.rqt.curp.equals("PEAL950202HDFRRL01")){
                responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
                responseErrorCambiarContrasena.resultado=false;
                responseErrorCambiarContrasena.status=200;
                responseErrorCambiarContrasena.descripcionError="Fallo Reinicio Contraseña";
                return responseErrorCambiarContrasena;
            }
            if(request.rqt.curp.equals("PEAL950202HDFRRL02")){
                responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
                responseErrorCambiarContrasena.resultado=false;
                responseErrorCambiarContrasena.status=200;
                responseErrorCambiarContrasena.descripcionError="Fallo Busqueda";
                return responseErrorCambiarContrasena;
            }
            else {
                responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
                responseCambiarContrasena.resultado=true;
                responseCambiarContrasena.status=200;
                return responseCambiarContrasena;
            }
        }

    }

    @Override
    public Object actualizarPassword(rqtActualizarPassword request) {
        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            if(request.rqt.curp.equals("GACL900726HDFRRS02")){
                responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
                responseCambiarContrasena.resultado=true;
                responseCambiarContrasena.status=200;
                return responseCambiarContrasena;
            }
            if(request.rqt.curp.equals("GACL900726HDFRRS00")){
                responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
                responseErrorCambiarContrasena.resultado=false;
                responseErrorCambiarContrasena.status=200;
                responseErrorCambiarContrasena.descripcionError="Fallo Cambio de Contraseña";
                return responseErrorCambiarContrasena;
            }
            if(request.rqt.curp.equals("GACL900726HDFRRS03")){
                responseErrorCambiarContrasena responseErrorCambiarContrasena=new responseErrorCambiarContrasena();
                responseErrorCambiarContrasena.resultado=false;
                responseErrorCambiarContrasena.status=200;
                responseErrorCambiarContrasena.descripcionError="Fallo Busqueda";
                return responseErrorCambiarContrasena;
            }
            else {
                responseCambiarContrasena responseCambiarContrasena=new responseCambiarContrasena();
                responseCambiarContrasena.resultado=true;
                responseCambiarContrasena.status=200;
                return responseCambiarContrasena;
            }
        }
    }

    @Override
    public Object autenticaUsuarioPensiones(rqtautenticaUsuarioPensiones request) {
        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            responseAutenticaUsuarioPensiones responseAutenticaUsuarioPensiones=new responseAutenticaUsuarioPensiones();
            if(request.rqt.curp.equals("GACL900726HDFRRS02")){
                responseAutenticaUsuarioPensiones.resultado=true;
                responseAutenticaUsuarioPensiones.idCliente= 5648932153L;
                responseAutenticaUsuarioPensiones.poliza=17000215358L;
                responseAutenticaUsuarioPensiones.status=200;
                responseAutenticaUsuarioPensiones.curp="GACL900726HDFRRS02";
                return responseAutenticaUsuarioPensiones;
            }
            if(request.rqt.curp.equals("GACL900726HDFRRS00")){
                responseErrorAutenticaUsuarioPensiones responseErrorAutenticaUsuarioPensiones=new responseErrorAutenticaUsuarioPensiones();
                responseErrorAutenticaUsuarioPensiones.resultado=false;
                responseErrorAutenticaUsuarioPensiones.status=404;
                responseErrorAutenticaUsuarioPensiones.statusText="Unauthorized";
                return responseAutenticaUsuarioPensiones;
            }
            else {
                responseAutenticaUsuarioPensiones.resultado=true;
                // Generar números aleatorios
                Random random = new Random();
                responseAutenticaUsuarioPensiones.idCliente = 5000000000L + (Math.abs(random.nextLong()) % 1000000000L);
                // Generar poliza en el rango 17000000000 - 17999999999
                responseAutenticaUsuarioPensiones.poliza = 17000000000L + (Math.abs(random.nextLong()) % 1000000000L);
                responseAutenticaUsuarioPensiones.status=200;
                return responseAutenticaUsuarioPensiones;
            }

        }
    }

    @Override
    public Object enviarfoliosmsuniv(rqtenviarFolioSmsUniv request) {
        responseEnviarFolioSmsUniv responseEnviarFolioSmsUniv=new responseEnviarFolioSmsUniv();
        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            if(request.rqt.curp.equals("GACL900726HDFRRS02")){
                responseEnviarFolioSmsUniv.resultado=true;
                responseEnviarFolioSmsUniv.status="200";
                return responseEnviarFolioSmsUniv;
            }

            else {
                responseEnviarFolioSmsUniv.resultado=false;
                responseEnviarFolioSmsUniv.status="400";
                return responseEnviarFolioSmsUniv;
            }
        }

    }

    @Override
    public Object validarFolioSmsUniv(rqtValidarFolioSmsUniv request) {

        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else {
            if (request.rqt.curp.equals("GACL900726HDFRRS02")) {
                responseValidarFolioSmsUniv responseValidarFolioSmsUniv = new responseValidarFolioSmsUniv();
                responseValidarFolioSmsUniv.resultado = true;
                responseValidarFolioSmsUniv.status = "200";
                return responseValidarFolioSmsUniv;
            } else {
                responseErrorValidarFolioSmsUniv responseValidarFolioSmsUniv = new responseErrorValidarFolioSmsUniv();
                responseValidarFolioSmsUniv.resultado = false;
                responseValidarFolioSmsUniv.status = "401";
                responseValidarFolioSmsUniv.statusText = "Folio expirado";
                return responseValidarFolioSmsUniv;
            }
        }
    }

    @Override
    public Object registrarUsuarioPensiones(rqtRegistrarUsuarioPensiones request) {

        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            if(request.rqt.curp.equals("GACL900726HDFRRS02")){
                responseRegistrarUsuarioPensiones responseRegistrarUsuarioPensiones=new responseRegistrarUsuarioPensiones();
                responseRegistrarUsuarioPensiones.resultado=true;
                responseRegistrarUsuarioPensiones.status=200;
                responseRegistrarUsuarioPensiones.idClienteUnico= "151426247";
                responseRegistrarUsuarioPensiones.poliza=17000215358L;
                responseRegistrarUsuarioPensiones.curp="GACL900726HDFRRS02";
                return responseRegistrarUsuarioPensiones;
            }else {
                responseRegistrarUsuarioPensiones responseRegistrarUsuarioPensiones=new responseRegistrarUsuarioPensiones();
                responseRegistrarUsuarioPensiones.resultado=true;
                responseRegistrarUsuarioPensiones.status=200;
                responseRegistrarUsuarioPensiones.idClienteUnico= "151426247";
                Random random = new Random();
                responseRegistrarUsuarioPensiones.poliza = 17000000000L + (Math.abs(random.nextLong()) % 1000000000L);
                responseRegistrarUsuarioPensiones.curp=request.rqt.curp;
                return responseRegistrarUsuarioPensiones;
            }
        }

    }

    @Override
    public Object buscarPolizaPensiones(rqtbuscarPolizaPensiones request) {
        if(request.rqt.poliza==0L){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Poliza no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else{
            if(request.rqt.poliza==17000215358L) {
                responseBuscarPoliza responseBuscarPolizaPensiones = new responseBuscarPoliza();
                // Crear titular
                Titular titular = new Titular();
                titular.nombre = "LUIS RAMON";
                titular.apellidoPaterno = "GARCIA";
                titular.apellidoMaterno = "DE LA CRUZ";
                titular.idClienteUnico = "151426247";
                titular.correo = "luisramon2099@hotmail.com";
                titular.curp = "GACL900726HDFRRS02";
                titular.poliza = 17000215358L;
                titular.celular = 5554038329L;

                // Crear beneficiarios
                List<Beneficiario> beneficiarios = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    Beneficiario beneficiario = new Beneficiario();
                    beneficiario.nombre = "LUIS RAMON";
                    beneficiario.apellidoPaterno = "GARCIA";
                    beneficiario.apellidoMaterno = "DE LA CRUZ";
                    beneficiario.idClienteUnico = "151426247";
                    beneficiario.correo = "luisramon2099@hotmail.com";
                    beneficiario.curp = "GACL900726HDFRRS02";
                    beneficiario.poliza = 17000215358L;
                    beneficiario.celular = 5554038329L;
                    beneficiarios.add(beneficiario);
                }

                // Crear la respuesta Root
                responseBuscarPoliza response = new responseBuscarPoliza();
                response.resultado = true;
                response.status = 200;
                response.tramiteEnProceso = false;
                response.titular = titular;
                response.beneficiarios = new ArrayList<>(beneficiarios);
                return response;
            }else{
                responseErrorBuscarPoliza responseErrorBuscarPoliza=new responseErrorBuscarPoliza();
                responseErrorBuscarPoliza.resultado=false;
                responseErrorBuscarPoliza.descripcionError="No se encontro la poliza";
                responseErrorBuscarPoliza.status=404;

            }
        }
        return null;
    }

    @Override
    public Object buscarCurpPensiones(rqtbuscarCurpPensiones request) {
        if(request.rqt.curp.equals("")||request.rqt.curp==null){
            Error400 error400response = new Error400();
            error400response.status = 400;
            error400response.resultado = false;
            ErrorRecurso errorRecurso = new ErrorRecurso();
            errorRecurso.codigo = "400";
            errorRecurso.descripcion = "Curp no puede ser nulo";
            error400response.error = errorRecurso;
            return error400response;
        }else {
            if(request.rqt.curp.equals("GACL900726HDFRRS02")){
                // Crear cuentaConRegistro
                CuentaConRegistro cuenta = new CuentaConRegistro();
                cuenta.nombre = "LUIS RAMON";
                cuenta.apellidoPaterno = "GARCIA";
                cuenta.apellidoMaterno = "DE LA CRUZ";
                cuenta.idClienteUnico = "151426247";
                cuenta.correo = "luisramon2099@hotmail.com";
                cuenta.curp = "GACL900726HDFRRS02";
                cuenta.poliza = 17000215358L;
                cuenta.celular = 5554038329L;

                // Crear la respuesta Root
                responseBuscarCurpPensiones response = new responseBuscarCurpPensiones();
                response.resultado = true;
                response.status = 200;
                response.tramiteEnProceso = false;
                response.permitirRegistro = false;
                response.cuentaConRegistro = cuenta;

                return response;

            }else {
                responseErrorBuscarCurpPensiones responseErrorBuscarCurpPensiones=new responseErrorBuscarCurpPensiones();
                responseErrorBuscarCurpPensiones.resultado=false;
                responseErrorBuscarCurpPensiones.descripcionError="No se encontraron coincidencias.";
                responseErrorBuscarCurpPensiones.status=404;
            }

        }
        return null;
    }
}
