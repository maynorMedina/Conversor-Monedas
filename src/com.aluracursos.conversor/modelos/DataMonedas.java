package com.aluracursos.conversor.modelos;

import com.google.gson.annotations.SerializedName;
public class DataMonedas {
    private String monedaBase;
    private String monedaDestino;
    @SerializedName("conversion_rate")
    private double tasaConversion;
    private double resultado;

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "DataMonedas{" +
                "monedaBase='" + monedaBase + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                "tasaConversion=" + tasaConversion +
                ", resultado=" + resultado +
                '}';
    }

}
