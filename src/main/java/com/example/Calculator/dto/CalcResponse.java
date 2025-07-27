package com.example.Calculator.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalcResponse {
    private static final Logger log = LogManager.getLogger(CalcResponse.class);
    private String operation;
    private double result;
    private String message;

    public CalcResponse(){}

    public CalcResponse(String operation, double result, String message){
        this.operation=operation;
        this.result=result;
        this.message=message;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CalcResponse{" +
                "operation='" + operation + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}
