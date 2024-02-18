package com.mandacarubroker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mandacarubroker.controller.StockController;
import com.mandacarubroker.domain.stock.RequestStockDTO;
import com.mandacarubroker.domain.stock.Stock;
import com.mandacarubroker.service.StockService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StockControllerTests {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        when(stockService.getAllStocks()).thenReturn(stocks);
        assertEquals(stocks, stockController.getAllStocks());
    }

    @Test
    public void testGetStockById() {
        String id = "1";
        Stock stock = new Stock(new RequestStockDTO("ABC123", "Company Name", 10.5));
        when(stockService.getStockById(id)).thenReturn(Optional.of(stock));
        assertEquals(stock, stockController.getStockById(id).getBody());
    }

}
