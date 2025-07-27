package com.example.Calculator;

import com.example.Calculator.controller.CalculatorController;
import com.example.Calculator.dto.CalcRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
@TestPropertySource(properties = {
		"app.message.success=Operation successful",
		"app.message.division.error=Division by zero is not allowed"
})
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${app.message.success}")
	private String successMessage;

	@Value("${app.message.division.error}")
	private String divisionErrorMessage;

	@Test
	@DisplayName("Test addition endpoint")
	void testAddition() throws Exception {
		CalcRequest request = new CalcRequest(5, 3);
		mockMvc.perform(post("/api/calc/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.operation").value("Addition"))
				.andExpect(jsonPath("$.result").value(8))
				.andExpect(jsonPath("$.message").value(successMessage));
	}

	@Test
	@DisplayName("Test subtraction endpoint")
	void testSubtraction() throws Exception {
		CalcRequest request = new CalcRequest(10, 4);
		mockMvc.perform(post("/api/calc/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.operation").value("Subtraction"))
				.andExpect(jsonPath("$.result").value(6))
				.andExpect(jsonPath("$.message").value(successMessage));
	}

	@Test
	@DisplayName("Test multiplication endpoint")
	void testMultiplication() throws Exception {
		CalcRequest request = new CalcRequest(2, 7);
		mockMvc.perform(post("/api/calc/multiply")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.operation").value("Multiplication"))
				.andExpect(jsonPath("$.result").value(14))
				.andExpect(jsonPath("$.message").value(successMessage));
	}

	@Test
	@DisplayName("Test division endpoint")
	void testDivision() throws Exception {
		CalcRequest request = new CalcRequest(20, 4);
		mockMvc.perform(post("/api/calc/divide")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.operation").value("Division"))
				.andExpect(jsonPath("$.result").value(5))
				.andExpect(jsonPath("$.message").value(successMessage));
	}

	@Test
	@DisplayName("Test division by zero")
	void testDivisionByZero() throws Exception {
		CalcRequest request = new CalcRequest(10, 0);
		mockMvc.perform(post("/api/calc/divide")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.operation").value("Division"))
				.andExpect(jsonPath("$.result").value(0))
				.andExpect(jsonPath("$.message").value(divisionErrorMessage));
	}
}
