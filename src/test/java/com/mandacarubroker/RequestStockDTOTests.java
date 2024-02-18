package com.mandacarubroker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.mandacarubroker.domain.stock.RequestStockDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class RequestStockDTOTests {

    private Validator validator;

    @Before
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testValidRequestStockDTO() {
        RequestStockDTO requestStockDTO = new RequestStockDTO("ABC123", "Company Name", 10.5);
        Set<ConstraintViolation<RequestStockDTO>> violations = validator.validate(requestStockDTO);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidSymbol() {
        RequestStockDTO requestStockDTO = new RequestStockDTO("ABCD", "Company Name", 10.5);
        Set<ConstraintViolation<RequestStockDTO>> violations = validator.validate(requestStockDTO);
        assertFalse(violations.isEmpty());
    }

}