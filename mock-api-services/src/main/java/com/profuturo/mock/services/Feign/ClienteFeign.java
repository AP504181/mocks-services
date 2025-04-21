package com.profuturo.mock.services.Feign;


import com.profuturo.mock.services.dto.buscarcliente.rqtBuscarCliente;
import com.profuturo.mock.services.dto.consultaInfoCliente.responseConsultaInformacionCliente;
import com.profuturo.mock.services.dto.consultaInfoCliente.rqtrequestconsultarInformacionCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "clienteFeign",
        url = "https://www.proinversion.mx:2143/mb/appMovil/rest/cuo",
        configuration = FeignClientConfig.class
)
public interface ClienteFeign {

    @PostMapping("/consultarInformacionCliente")
    responseConsultaInformacionCliente consultarInformacionCliente(
            @RequestBody rqtrequestconsultarInformacionCliente request
    );


    @PostMapping("/buscarCliente")
    String buscarCliente(
            @RequestBody rqtBuscarCliente request
    );

}