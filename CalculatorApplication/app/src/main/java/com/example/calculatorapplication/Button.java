package com.example.calculatorapplication;

public class Button {

    private Integer id;
    private String symbol;
    private Integer value;

    public Button(Integer id, String symbol, Integer value) {
        this.id = id;
        this.symbol = symbol;
        this.value = value;
    }

    public Button(Integer id, String symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

