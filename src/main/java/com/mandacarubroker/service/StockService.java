package com.mandacarubroker.service;

import com.mandacarubroker.domain.stock.RequestStockDTO;
import com.mandacarubroker.domain.stock.Stock;
import com.mandacarubroker.domain.stock.StockRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(String id) {
        return stockRepository.findById(id);
    }

    public Stock createStock(RequestStockDTO data) {
        validateRequestStockDTO(data);
        Stock newStock = new Stock(data);
        return stockRepository.save(newStock);
    }

    public Stock updateStock(String id, RequestStockDTO data) {
        validateRequestStockDTO(data);
        Optional<Stock> existingStockOptional = stockRepository.findById(id);
        if (existingStockOptional.isEmpty()) {
            throw new IllegalArgumentException("Stock with ID " + id + " not found");
        }
        Stock existingStock = existingStockOptional.get();
        existingStock.setSymbol(data.getSymbol());
        existingStock.setCompanyName(data.getCompanyName());
        existingStock.setPrice(data.getPrice());
        return stockRepository.save(existingStock);
    }

    public void deleteStock(String id) {
        stockRepository.deleteById(id);
    }

    private void validateRequestStockDTO(RequestStockDTO data) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<RequestStockDTO>> violations = validator.validate(data);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation failed. Details: ");
            for (ConstraintViolation<RequestStockDTO> violation : violations) {
                errorMessage.append(String.format("[%s: %s], ", violation.getPropertyPath(), violation.getMessage()));
            }
            errorMessage.delete(errorMessage.length() - 2, errorMessage.length());
            throw new ConstraintViolationException(errorMessage.toString(), violations);
        }
    }

    public static class RequestStockDTOTests {

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
}
