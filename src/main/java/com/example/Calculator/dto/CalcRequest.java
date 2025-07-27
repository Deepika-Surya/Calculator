package com.example.Calculator.dto;

import jakarta.validation.constraints.NotNull;

public class CalcRequest {

    private int a;
    private int b;

    public CalcRequest() {}

    public CalcRequest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "CalcRequest{a=" + a + ", b=" + b + "}";
    }
}
