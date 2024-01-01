# Fruit Price and Total Price Microservices

## Overview

This repository hosts two microservices: `fruit-price-service` and `fruit-total-price-service`. These microservices collaborate to provide information about the cost of individual fruits and calculate the total price based on the quantity specified by the user.

## Project Structure

### 1. fruit-price-service

The `fruit-price-service` microservice provides the cost of individual fruits.

### 2. fruit-total-price-service

The `fruit-total-price-service` microservice interacts with `fruit-price-service` to calculate the total price based on the quantity specified by the user.

## How It Works

1. **fruit-price-service:**
   - Exposes endpoints to retrieve the cost of individual fruits.
   - Examples:
     - `/fruit-price/apple` returns the cost of an apple.
     - `/fruit-price/banana` returns the cost of a banana.

2. **fruit-total-price-service:**
   - Communicates with `fruit-price-service` to get the cost of each fruit.
   - Exposes an endpoint to calculate the total price based on the quantity of each fruit specified by the user.
   - Example:
     - `/total-price?apple=3&banana=5` returns the total price for 3 apples and 5 bananas.

## How to Use

1. **Run `fruit-price-service`:**
   - Configure individual fruit prices in the properties file.
   - Build and run the microservice.

2. **Run `fruit-total-price-service`:**
   - Ensure `fruit-price-service` is running.
   - Build and run the microservice.
   - Access the total price endpoint with the desired fruit quantities.

```bash
# Example steps
1. Clone the repository
2. Configure fruit prices in `fruit-price-service/application.properties`
3. Build and run `fruit-price-service`
4. Build and run `fruit-total-price-service`
5. Access the total price endpoint: http://localhost:8081/total-price?apple=3&banana=5
