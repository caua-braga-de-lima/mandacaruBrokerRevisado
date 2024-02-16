package com.mandacarubroker.domain.stock;

public class Stock {

    private String id;
    private String symbol;
    private String companyName;
    private Double price;

    public Stock(RequestStockDTO requestStockDTO) {
        this.symbol = requestStockDTO.getSymbol();
        this.companyName = requestStockDTO.getCompanyName();
        this.price = requestStockDTO.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double changePrice(Double amount, boolean increase) {
        if (increase) {
            if (amount < this.price) {
                return increasePrice(amount);
            } else {
                return decreasePrice(amount);
            }
        } else {
            if (amount > this.price) {
                return increasePrice(amount);
            } else {
                return decreasePrice(amount);
            }
        }
    }

    private Double increasePrice(Double amount) {
        return this.price + amount;
    }

    private Double decreasePrice(Double amount) {
        return this.price - amount;
    }
}
