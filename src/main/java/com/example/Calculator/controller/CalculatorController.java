package com.example.Calculator.controller;

import com.example.Calculator.dto.CalcRequest;
import com.example.Calculator.dto.CalcResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @Value("${app.message.success}")
    private String successMessage;

    @Value("${app.message.division.error}")
    private String divisionErrorMessage;

    @PostMapping("/add")
    public ResponseEntity<CalcResponse> add(@RequestBody @Valid CalcRequest request) {
        int result = request.getA() + request.getB();
        CalcResponse response = new CalcResponse("Addition", result, successMessage);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalcResponse> subtract(@RequestBody @Valid CalcRequest request) {
        int result = request.getA() - request.getB();
        CalcResponse response = new CalcResponse("Subtraction", result, successMessage);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalcResponse> multiply(@RequestBody @Valid CalcRequest request) {
        int result = request.getA() * request.getB();
        CalcResponse response = new CalcResponse("Multiplication", result, successMessage);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalcResponse> divide(@RequestBody @Valid CalcRequest request) {
        try {
            int result = request.getA() / request.getB();  // may throw ArithmeticException on divide by zero
            CalcResponse response = new CalcResponse("Division", result, successMessage);
            return ResponseEntity.ok(response);
        } catch (ArithmeticException e) {
            CalcResponse errorResponse = new CalcResponse("Division", 0, divisionErrorMessage);
            return ResponseEntity.status(400).body(errorResponse);
        }
    }
}
