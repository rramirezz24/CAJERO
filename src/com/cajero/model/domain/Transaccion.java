package com.cajero.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Transaccion {

    private int id;
    private String tipo;
    private double monto;
    private String fecha;
    private Cuenta cuenta;


    // Historial de movimientos de la cuenta
    private static List<String> historial = new ArrayList<>();
    private static int contadorId = 1;

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaccion(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.fecha = LocalDateTime.now().format(FORMATO_FECHA);
        this.id = contadorId++;
    }

    //retira el monto de la cuenta
    public void retirar() {

    }

    //consigna un monto a la cuenta asociada
    public void consignar() {

    }
        //transfiere el monto a otra cuenta

    public void transferir() {

    }

    //imprime todos los movimientos registrados
    public void consultarMovimientos() {

    }

    // ─── Método Auxiliar

    private void registrarMovimiento(String tipo, double monto) {

    }

    // Getters
    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
    public Cuenta getCuenta() { return cuenta; }
    public List<String> getHistorial() { return historial; }
}
