package com.profuturo.mock.services.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profuturo.mock.services.controladores.LoginPensionesControlador;
import com.profuturo.mock.services.dto.buscarcliente.mensajeError;
import com.profuturo.mock.services.dto.buscarcliente.responseCliente;
import com.profuturo.mock.services.dto.buscarcliente.rqtBuscarCliente;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public Object buscarCliente(rqtBuscarCliente request) {
        if (request.rqt.curp == null) {
            mensajeError errorresponse=new mensajeError();
            errorresponse.mensajeError="No se ha encontrado el Cliente con la información ingresada";
            return errorresponse;

        }
        else{
            if(request.rqt.curp.equals("MIBB990507XMCGRR08") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 168328663,\n" +
                        "            \"idContrato\": 14381225,\n" +
                        "            \"numeroCuenta\": \"6442138991\",\n" +
                        "            \"nss\": \"40169950694\",\n" +
                        "            \"curp\": \"MIBB990507XMCGRR08\",\n" +
                        "            \"rfc\": \"MIBB990507\",\n" +
                        "            \"nombre\": \"BERENICE\",\n" +
                        "            \"apellidoPaterno\": \"MIGUEL\",\n" +
                        "            \"apellidoMaterno\": \"BORJA\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"28-11-2022\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("OOGA970928XDFSTL06") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 162796409,\n" +
                        "            \"idContrato\": 10379222,\n" +
                        "            \"numeroCuenta\": \"3300295524\",\n" +
                        "            \"nss\": \"02179734898\",\n" +
                        "            \"curp\": \"OOGA970928XDFSTL06\",\n" +
                        "            \"rfc\": \"OOGA970928\",\n" +
                        "            \"nombre\": \"ALEXANDER\",\n" +
                        "            \"apellidoPaterno\": \"DEL OSO\",\n" +
                        "            \"apellidoMaterno\": \"GUTIERREZ\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"07-06-2019\",\n" +
                        "            \"indicadorMDBasica\": false,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("HEJL971023XDFRLS03") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 165637203,\n" +
                        "            \"idContrato\": 12779318,\n" +
                        "            \"numeroCuenta\": \"6442020594\",\n" +
                        "            \"nss\": \"39139733669\",\n" +
                        "            \"curp\": \"HEJL971023XDFRLS03\",\n" +
                        "            \"rfc\": \"HEJL971023UG1\",\n" +
                        "            \"nombre\": \"JOSE LUIS\",\n" +
                        "            \"apellidoPaterno\": \"HERRERA\",\n" +
                        "            \"apellidoMaterno\": \"JULIAN\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"17-08-2021\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("PAFA880415MMCLRL05") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 164903206,\n" +
                        "            \"idContrato\": 12336397,\n" +
                        "            \"numeroCuenta\": \"3201008254\",\n" +
                        "            \"nss\": \"04118801978\",\n" +
                        "            \"curp\": \"PAFA880415MMCLRL05\",\n" +
                        "            \"rfc\": \"PAFA880415P20\",\n" +
                        "            \"nombre\": \"ALEJANDRA\",\n" +
                        "            \"apellidoPaterno\": \"PALACIOS\",\n" +
                        "            \"apellidoMaterno\": \"FRAGOSO\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"29-03-2021\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("NARE000922XMCVYMA3") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 174640162,\n" +
                        "            \"idContrato\": 17407197,\n" +
                        "            \"numeroCuenta\": \"6448010028\",\n" +
                        "            \"nss\": \"05210054846\",\n" +
                        "            \"curp\": \"NARE000922XMCVYMA3\",\n" +
                        "            \"rfc\": \"0\",\n" +
                        "            \"nombre\": \"EMILIO ABRAHAM\",\n" +
                        "            \"apellidoPaterno\": \"NAVARRO\",\n" +
                        "            \"apellidoMaterno\": \"REY\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO (ESTE CLIENTE NO SE ENCUENTRA EN INTEGRITY SOLO EN BUC)\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"10-08-2021\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"idCliente\": 165640419,\n" +
                        "            \"idContrato\": 12781774,\n" +
                        "            \"numeroCuenta\": \"3300581248\",\n" +
                        "            \"nss\": \"05210054846\",\n" +
                        "            \"curp\": \"NARE000922XMCVYMA3\",\n" +
                        "            \"rfc\": \"NARE000922GR2\",\n" +
                        "            \"nombre\": \"EMILIO ABRAHAM\",\n" +
                        "            \"apellidoPaterno\": \"NAVARRO\",\n" +
                        "            \"apellidoMaterno\": \"REY\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"10-08-2021\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("AUCK930113XGTGHR08") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 160916590,\n" +
                        "            \"idContrato\": 9428362,\n" +
                        "            \"numeroCuenta\": \"3300061180\",\n" +
                        "            \"nss\": \"20119306627\",\n" +
                        "            \"curp\": \"AUCK930113XGTGHR08\",\n" +
                        "            \"rfc\": \"AUCK930113QC0\",\n" +
                        "            \"nombre\": \"KARLA MARAI\",\n" +
                        "            \"apellidoPaterno\": \"AGUILAR\",\n" +
                        "            \"apellidoMaterno\": \"CHAVEZ\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": true,\n" +
                        "            \"fechaExpedIdentificacion\": \"18-09-2017\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": true,\n" +
                        "            \"indicadorMDCompCert\": true,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else if(request.rqt.curp.equals("GAZF740213XDFRML04") ){
                String json = "{\n" +
                        "    \"clientes\": [\n" +
                        "        {\n" +
                        "            \"idCliente\": 34878551,\n" +
                        "            \"idContrato\": 4068148,\n" +
                        "            \"numeroCuenta\": \"1700006586\",\n" +
                        "            \"nss\": \"37927430654\",\n" +
                        "            \"curp\": \"GAZF740213XDFRML04\",\n" +
                        "            \"rfc\": \"GAZF7402138Q2\",\n" +
                        "            \"nombre\": \"FELIPE DE JESUS\",\n" +
                        "            \"apellidoPaterno\": \"GARCIA\",\n" +
                        "            \"apellidoMaterno\": \"ZAMORA\",\n" +
                        "            \"codigoEdoAfil\": 10,\n" +
                        "            \"estadoAfil\": \"CERTIFICADO ACTIVO\",\n" +
                        "            \"indicadorExpIdentificacion\": true,\n" +
                        "            \"indicadorEnrolamientoBiometrico\": false,\n" +
                        "            \"fechaExpedIdentificacion\": \"16-02-2016\",\n" +
                        "            \"indicadorMDBasica\": true,\n" +
                        "            \"indicadorMDComp\": false,\n" +
                        "            \"indicadorMDCompCert\": false,\n" +
                        "            \"indicadorExpIdTransito\": false,\n" +
                        "            \"indicadorEnrolamientoTransito\": false\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}";

                responseCliente response = convertirJsonAObjeto(json);
                return response;
            }
            else{
                mensajeError errorresponse=new mensajeError();
                errorresponse.mensajeError="No se ha encontrado el Cliente con la información ingresada";
                return errorresponse;
            }
        }
    }

    public static responseCliente convertirJsonAObjeto(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, responseCliente.class);
        } catch (Exception e) {
            return null;
        }
    }
}
