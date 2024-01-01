package com.concordia.microservices.fruittotalpriceservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class FruitTotalPriceController {

    // Mapping for the root path ("/")
    @GetMapping("/")
    public String handleRootPath() {
        return "Welcome to the Fruit Total Price service!";
    }

    // Mapping for valid URLs ("/fruit-total-price/fruit/{fruit}/month/{month}/quantity/{quantityStr}")
    @GetMapping("/fruit-total-price/fruit/{fruit}/month/{month}/quantity/{quantityStr}")
    public FruitTotalPrice retrieveValue(@PathVariable String fruit, @PathVariable String month, @PathVariable String quantityStr) {
        // Validate and parse the quantity
        Double quantity;
        try {
            quantity = Double.parseDouble(quantityStr);
            if (quantity <= 0) {
                return getDummyFruitTotalPrice();
            }
        } catch (NumberFormatException ex) {
            return getDummyFruitTotalPrice();
        }

        // Prepare the URI variables for the external API call
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fruit", fruit);
        uriVariables.put("month", month);

        // Make a GET request to the external API to get fruit data for the specified fruit and month
        ResponseEntity<FruitTotalPrice> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/fruit-month-price/fruit/{fruit}/month/{month}",
                FruitTotalPrice.class,
                uriVariables
        );

        // Get the response body from the API call
        FruitTotalPrice fruitTotalPrice = responseEntity.getBody();

        // If the response is null, it means no data was found for the given fruit and month
        if (fruitTotalPrice == null) {
            throw new RuntimeException("Unable to fetch fruit data");
        }

        // Calculate the total price based on the fruit price and quantity
        fruitTotalPrice.setTotalPrice(fruitTotalPrice.getFmp() * quantity);

        // Return the calculated FruitTotalPrice object with the updated total price
        return new FruitTotalPrice(
                fruitTotalPrice.getId(),
                fruitTotalPrice.getFruitName(),
                fruitTotalPrice.getMonth(),
                fruitTotalPrice.getFmp(),
                fruitTotalPrice.getTotalPrice(),
                quantity,
                fruitTotalPrice.getEnvironment()
        );
    }
    // Dummy fruit total price for invalid inputs
    private static FruitTotalPrice getDummyFruitTotalPrice() {
        return new FruitTotalPrice(0L, "Invalid Input", "Invalid Input", 0.0, 0.0, 0.0, "Invalid Input");
    }

    // Default mapping for all other invalid URLs
    @RequestMapping("/**")
    public String handleInvalidUrls() {
        return "Invalid URL. No such page exists!!! Please enter a valid URL and try again.";
    }

}
