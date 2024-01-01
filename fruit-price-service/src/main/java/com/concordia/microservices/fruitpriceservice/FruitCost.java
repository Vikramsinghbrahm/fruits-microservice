package com.concordia.microservices.fruitpriceservice;

public class FruitCost {

    // Unique identifier for the fruit cost
    private Long id;

    // Name of the fruit
    private String fruitName;

    // Month for which the fruit cost is applicable
    private String month;

    // Fruit price for the specified month
    private double fmp;

    // Environment details, e.g., server port, where the data is retrieved
    private String environment;

    // Default constructor for deserialization
    public FruitCost() {
    }

    // Parameterized constructor to create FruitCost object with provided data
    public FruitCost(Long id, String fruitName, String month, double fmp, String environment) {
        this.id = id;
        this.fruitName = fruitName;
        this.month = month;
        this.fmp = fmp;
        this.environment = environment;
    }

    // Getters and Setters for the private fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getFmp() {
        return fmp;
    }

    public void setFmp(double fmp) {
        this.fmp = fmp;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
