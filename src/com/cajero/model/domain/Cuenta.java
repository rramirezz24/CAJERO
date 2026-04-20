package com.cajero.model.domain;

public class Cuenta {

    private int numeroCuenta;
    private double saldo;

    //constructor que genera un numero de cuenta aleatorio e inicializa el saldo en 0
    public Cuenta() {
        this.numeroCuenta = (int) (Math.random() * 900000) + 100000;
        this.saldo = 0;
    }

    //constructor para modificar cuenta ya existente
    public Cuenta(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Getters y Setters
    public int getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(int numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
}
