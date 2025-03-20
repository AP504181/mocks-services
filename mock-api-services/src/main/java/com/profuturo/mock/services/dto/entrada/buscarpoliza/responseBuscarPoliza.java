package com.profuturo.mock.services.dto.entrada.buscarpoliza;

import java.util.ArrayList;

public class responseBuscarPoliza {
    public boolean resultado;
    public int status;
    public boolean tramiteEnProceso;
    public Titular titular;
    public ArrayList<Beneficiario> beneficiarios;
}
