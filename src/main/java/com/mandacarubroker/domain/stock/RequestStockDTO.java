package com.mandacarubroker.domain.stock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RequestStockDTO {

        @Pattern(regexp = "[A-Za-z]{2}//d", message = "Symbol must be 3 letters followed by 1 number")
        private String symbol;

        @NotBlank(message = "Company name cannot be blank")
        private String companyName;

        @NotNull(message = "Price cannot be null")
        private Double price;

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
}
