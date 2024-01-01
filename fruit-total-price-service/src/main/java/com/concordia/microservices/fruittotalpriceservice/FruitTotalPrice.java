package com.concordia.microservices.fruittotalpriceservice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// Specifies the order of properties in JSON serialization
@JsonPropertyOrder({"id", "fruitName", "month", "fmp", "quantity", "totalPrice", "environment"})
public class FruitTotalPrice {

    // Unique identifier for the fruit total price
    private Long id;

    // Name of the fruit
    private String fruitName;

    // Month of the price data
    private String month;

    // Fruit price for the specified month
    private double fmp;

    // Environment details, e.g., server port, where the data is retrieved
    private String environment;

    // Total price calculated based on the fruit price and quantity
    private double totalPrice;

    // Quantity of the fruit
    private double quantity;

    // Default constructor for deserialization
    public FruitTotalPrice() {
    }

    // Parameterized constructor to create FruitTotalPrice object with provided data
    public FruitTotalPrice(Long id, String fruitName, String month, double fmp, Double totalPrice, Double quantity, String environment) {
        this.id = id;
        this.fruitName = fruitName;
        this.month = month;
        this.fmp = fmp;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
