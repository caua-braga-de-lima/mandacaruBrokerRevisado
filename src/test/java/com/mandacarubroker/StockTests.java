package com.mandacarubroker;

import static org.junit.Assert.assertEquals;
import com.mandacarubroker.domain.stock.RequestStockDTO;
import com.mandacarubroker.domain.stock.Stock;
import org.junit.Before;
import org.junit.Test;

public class StockTests {

    private RequestStockDTO requestStockDTO;
    private Stock stock;

    @Before
    public void setUp() {
        requestStockDTO = new RequestStockDTO("ABC123", "Company Name", 10.5);
        stock = new Stock(requestStockDTO);
    }

    @Test
    public void testGetters() {
        assertEquals("ABC123", stock.getSymbol());
        assertEquals("Company Name", stock.getCompanyName());
        assertEquals(10.5, stock.getPrice(), 0.001);
    }

    @Test
    public void testChangePrice() {
        double newPrice = stock.changePrice(5.0, true);
        assertEquals(15.5, newPrice, 0.001);
    }
}

