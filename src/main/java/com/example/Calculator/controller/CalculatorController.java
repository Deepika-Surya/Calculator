package com.example.Calculator.controller;

import com.example.Calculator.dto.CalcRequest;
import com.example.Calculator.dto.CalcResponse;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    private static final Logger log = LogManager.getLogger(CalculatorController.class);

    @Value("${app.message.success}")
    private String successMessage;

    @Value("${app.message.division.error}")
    private String divisionErrorMessage;

    // Handle POST request to /add
    @PostMapping("/add")
    public ResponseEntity<CalcResponse> add(@RequestBody @Valid CalcRequest request) {
        double result = request.getA() + request.getB();
        CalcResponse response = new CalcResponse("Addition", result, successMessage);
        log.info("Request: {}", request);
        log.info("Response: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalcResponse> subtract(@RequestBody @Valid CalcRequest request) {
        double result = request.getA() - request.getB();
        CalcResponse response = new CalcResponse("Subtraction", result, successMessage);
        log.info("Request: {}", request);
        log.info("Response: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalcResponse> multiply(@RequestBody @Valid CalcRequest request) {
        double result = request.getA() * request.getB();
        CalcResponse response = new CalcResponse("Multiplication", result, successMessage);
        log.info("Request: {}", request);
        log.info("Response: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalcResponse> divide(@RequestBody @Valid CalcRequest request) {
        if (request.getB() == 0) {
            log.warn("Division by zero attempt: {}", request);
            CalcResponse errorResponse = new CalcResponse("Division", 0, divisionErrorMessage);
            return ResponseEntity.status(400).body(errorResponse);
        }

        double result = request.getA() / request.getB();
        CalcResponse response = new CalcResponse("Division", result, successMessage);
        log.info("Request: {}", request);
        log.info("Response: {}", response);
        return ResponseEntity.ok(response);
    }
}
