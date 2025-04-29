package com.profuturo.mock.services.Feign;


import com.profuturo.mock.services.dto.consultaInfoCliente.responseConsultaInformacionCliente;
import com.profuturo.mock.services.dto.consultaInfoCliente.rqtrequestconsultarInformacionCliente;
import com.profuturo.mock.services.dto.consultaexpediente.requestConsultaExpediente0103;
import com.profuturo.mock.services.dto.consultaexpediente.responseConsultaExpediente0103;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "ClientConsultaExpediente",
        url = "https://www.proinversion.mx:2093/expediente-integral",
        configuration = FeignClientConfig.class
)
public interface ClientConsultaExpediente {

    @PostMapping("/procesar/consultaExpediente")
    responseConsultaExpediente0103 consultaExpediente0103(
            @RequestBody requestConsultaExpediente0103 request
    );
}
