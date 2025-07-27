package com.example.Calculator.dto;

import jakarta.validation.constraints.NotNull;

public class CalcRequest {

    @NotNull(message = "Parameter 'a' is required")
    private Double a;

    @NotNull(message = "Parameter 'b' is required")
    private Double b;

    public CalcRequest() {}

    public CalcRequest(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "CalcRequest{a=" + a + ", b=" + b + "}";
    }
}
