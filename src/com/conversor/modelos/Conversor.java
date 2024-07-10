package com.conversor.modelos;

import com.google.gson.annotations.SerializedName;

public class Conversor {
    @SerializedName("base_code")
    private String moneda1;
    @SerializedName("target_code")
    private String moneda2;
    private int monto;
    @SerializedName("conversion_result")
    private String montoFinal;

    public Conversor(String moneda1, String moneda2) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
    }

    public String getMoneda1() {
        return moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "El valor "+ monto + " [" + moneda1 + "]" + " corresponde al valor final de =>> " + montoFinal +
                " [" + moneda2 + "]";
    }
}
