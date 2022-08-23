package io.gordonpm.bicyclecatalogservice.controller;

import io.gordonpm.bicyclecatalogservice.models.Bicycle;
import io.gordonpm.bicyclecatalogservice.models.BicycleRating;
import io.gordonpm.bicyclecatalogservice.models.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BicycleCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<BicycleRating> ratings = Arrays.asList(
                new BicycleRating("100", 4),
                new BicycleRating("200", 3)
        );

        return ratings.stream().map(rating -> {
            Bicycle bicycle = restTemplate.getForObject("http://localhost:8081/bicycles/" + rating.getBicycleId(), Bicycle.class);
            if (bicycle != null) {
                return new CatalogItem(bicycle.getName(), bicycle.getVendor(), rating.getRating());
            } else {
                return null;
            }
        }).collect(Collectors.toList());
    }

}
