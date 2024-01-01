package com.concordia.microservices.fruitpriceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitPriceController {

    // Injecting Environment to access application properties
    @Autowired
    private Environment environment;

    // Injecting FruitPriceRepository to access data from the database
    @Autowired
    private FruitPriceRepository fruitPriceRepository;

    // Mapping for the root path ("/")
    @GetMapping("/")
    public String handleRootPath() {
        return "Welcome to the Fruit Month Price service!";
    }

    // Mapping to retrieve the fruit cost for a specific fruit and month
    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitCost retrieveValue(@PathVariable String fruit, @PathVariable String month) {
        // Find the fruit price for the given fruit and month
        Double fpm = fruitPriceRepository.findFruitPriceByFruitNameAndMonth(fruit, month);

        // Find the unique identifier (id) for the given fruit
        Long id = fruitPriceRepository.findIdByFruitName(fruit);

        // Get the server port from the application properties to include in the response
        String port = environment.getProperty("local.server.port");

        // If either fpm or id is null, it means no data was found for the given fruit and month.
        // In this case, return dummy data with "Invalid Input" values.
        if (fpm == null || id == null) {
            fruit = "Invalid Input";
            month = "Invalid Input";
            fpm = 0.0;
            id = 0L;
            port = "Invalid Input";
        }



        // Create a FruitCost object with the retrieved data and server port
        FruitCost fruitCost = new FruitCost(id, fruit, month, fpm, port);

        // Return the FruitCost object
        return fruitCost;
    }

    // Default mapping for all other invalid URLs
    @RequestMapping("/**")
    public String handleInvalidUrls() {
        return "Invalid URL. No such page exists!!! Please enter a valid URL and try again.";
    }
}
