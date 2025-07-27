package com.example.Calculator.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalcResponse {
    private static final Logger log = LogManager.getLogger(CalcResponse.class);
    private String operation;
    private int result;   // changed from double to int
    private String message;

    public CalcResponse() {}

    public CalcResponse(String operation, int result, String message) {
        this.operation = operation;
        this.result = result;
        this.message = message;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
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
