package com.profuturo.mock.services.dto.consultaInfoCliente;

import java.util.ArrayList;

public class Beneficiario {
    public int idPersonaBuc;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String nombre;
    public String curp;
    public String idParentesco;
    public ArrayList<Subcuenta> subcuentas;
    public ArrayList<Object> domicilios;
    public ArrayList<Object> telefonos;
    public ArrayList<Object> correos;
}
