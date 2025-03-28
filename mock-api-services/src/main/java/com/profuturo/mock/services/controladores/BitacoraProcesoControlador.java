package com.profuturo.mock.services.controladores;

import com.profuturo.mock.services.dto.buscarcliente.rqtBuscarCliente;
import com.profuturo.mock.services.service.serviceLoginPensiones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/mb")
public class BitacoraProcesoControlador {

	Logger logger = LogManager.getLogger(BitacoraProcesoControlador.class);
	private final serviceLoginPensiones serviceloginpensiones;

	public BitacoraProcesoControlador(serviceLoginPensiones serviceloginpensiones) {
		this.serviceloginpensiones = serviceloginpensiones;
	}


	@PostMapping("/consultaexpediente0103")
	public ResponseEntity<Map<String, Object>> getMockResponse(@RequestBody(required = false) Map<String, Object> request) {
		if (request == null) {
			request = new HashMap<>(); // Evita null pointer exception
		}
		Map<String, Object> response = new HashMap<>();
		// Datos generales del mock
		response.put("cveAfore", 534);
		response.put("curpAsesor", "TECD960723MMCNLN07");
		response.put("cveServicio", "0103");
		response.put("curpTrabajador", "GOPJ640628HDFDRN09");
		response.put("nss", "75846419879");
		response.put("rol", "01");
		response.put("indicaImg", "0");
		response.put("indicaDatos", "1");
		response.put("selloVerificacionBiometrica", "62337760233332");
		response.put("resultadoOperacion", "01");
		response.put("diagnostico", "");
		response.put("folioConsulta", "53401030000000008463765");

		// Datos operativos cuenta
		Map<String, Object> datosOperativosCuenta = new HashMap<>();
		datosOperativosCuenta.put("relacionAfore", "01");
		datosOperativosCuenta.put("duplicidadCurp", 0);
		datosOperativosCuenta.put("detalleCurpDuplicada", new ArrayList<>());

		// Marca operativa
		Map<String, Object> marcaOperativa = new HashMap<>();
		marcaOperativa.put("marca", "9201");
		marcaOperativa.put("proceconvive", "A001");
		marcaOperativa.put("convivencia", 1);
		datosOperativosCuenta.put("marcaOperativa", List.of(marcaOperativa));
		response.put("datosOperativosCuenta", datosOperativosCuenta);

		// Detalle expediente
		Map<String, Object> detalleExpediente = new HashMap<>();
		detalleExpediente.put("tipoExpe", "01");
		detalleExpediente.put("vinculacionHib", "");
		detalleExpediente.put("estatusExpe", "01");
		detalleExpediente.put("fchFinVigenExp", "");
		detalleExpediente.put("fchConformaExp", "");
		detalleExpediente.put("fchActualizaExp", "");
		response.put("detalleExpediente", List.of(detalleExpediente));

		// Detalle de imágenes
		Map<String, Object> detalleImage = new HashMap<>();
		detalleImage.put("tipoExpe", "01");
		detalleImage.put("cveDoc", "");
		detalleImage.put("fchFinVigenciaDoc", "");
		detalleImage.put("fchActualizaDoc", "");
		response.put("detalleImage", List.of(detalleImage));

		// Detalle de enrolamiento
		Map<String, Object> enrolamiento1 = new HashMap<>();
		enrolamiento1.put("tipoEnrolamiento", "01");
		enrolamiento1.put("estatusEnrolamiento", "05");
		enrolamiento1.put("aforeEnroladora", 534);
		enrolamiento1.put("fechaEnrolamiento", "04/01/2024");
		enrolamiento1.put("biomCalidad", 1);

		Map<String, Object> enrolamiento2 = new HashMap<>();
		enrolamiento2.put("tipoEnrolamiento", "02");
		enrolamiento2.put("estatusEnrolamiento", "00");
		enrolamiento2.put("aforeEnroladora", 0);
		enrolamiento2.put("fechaEnrolamiento", "");
		enrolamiento2.put("biomCalidad", 0);

		response.put("detalleEnrolamiento", List.of(enrolamiento1, enrolamiento2));

		// Datos generales
		Map<String, Object> datosGenerales = new HashMap<>();
		datosGenerales.put("rolDatos", "01");
		datosGenerales.put("curp", "GOPJ640628HDFDRN09");
		datosGenerales.put("nss", "");
		datosGenerales.put("rfcTitular", "");
		datosGenerales.put("apellidoPaterno", "");
		datosGenerales.put("apellidoMaterno", "");
		datosGenerales.put("nombre", "");

		// Género
		Map<String, String> sexo = new HashMap<>();
		sexo.put("descripcionGenero", "");
		datosGenerales.put("sexo", sexo);

		// Entidad nacimiento
		Map<String, String> entidadNacimiento = new HashMap<>();
		entidadNacimiento.put("cveEntidadFederativa", "00");
		entidadNacimiento.put("descripcionCveFede", "");
		entidadNacimiento.put("cveCorta", "");
		datosGenerales.put("entidadNacimiento", entidadNacimiento);

		// País
		Map<String, String> pais = new HashMap<>();
		pais.put("clavePais", "");
		pais.put("descripcionPais", "");
		datosGenerales.put("pais", pais);

		datosGenerales.put("nacionalidad", "");
		datosGenerales.put("claveGiro", "");
		datosGenerales.put("gradoEstudios", "");
		datosGenerales.put("ocupacion", "");
		datosGenerales.put("telefono", new ArrayList<>());
		datosGenerales.put("domicilio", new ArrayList<>());

		// Beneficiarios
		Map<String, Object> beneficiarios = new HashMap<>();
		beneficiarios.put("indicadorDesignacion", 0);
		beneficiarios.put("indicadorReforma", 2);
		beneficiarios.put("fechaModificacionBeneficiario", "");
		beneficiarios.put("listaBeneficiarios", new ArrayList<>());
		datosGenerales.put("beneficiarios", beneficiarios);

		response.put("datosGenerales", datosGenerales);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/appMovil/rest/cuo/buscarCliente")
	public ResponseEntity<?> getMockBuscarCliente(@RequestBody rqtBuscarCliente request)  {
		Map<String, Object> response = new HashMap<>();
		try {
			Object  responsebuscarcliente= serviceloginpensiones.buscarCliente(request);
			return ResponseEntity.ok(responsebuscarcliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al al validar autenticacion: " + e.getMessage());
		}
	}
}

