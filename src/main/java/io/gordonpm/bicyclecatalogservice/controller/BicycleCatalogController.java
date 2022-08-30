package io.gordonpm.bicyclecatalogservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.gordonpm.bicyclecatalogservice.models.Bicycle;
import io.gordonpm.bicyclecatalogservice.models.CatalogItem;
import io.gordonpm.bicyclecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BicycleCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String CATALOG_SERVICE = "catalogService";

    @RequestMapping("/{userId}")
    @CircuitBreaker(name = CATALOG_SERVICE, fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://bicycle-ratings-service/bicycleratings/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Bicycle bicycle = restTemplate.getForObject("http://bicycle-management-service/bicycles/" + rating.getBicycleId(), Bicycle.class);
            if (bicycle != null) {
                return new CatalogItem(bicycle.getName(), bicycle.getVendor(), rating.getRating());
            } else {
                return null;
            }
        }).collect(Collectors.toList());
    }

    public List<CatalogItem> getFallbackCatalog(Exception e) {
        return Arrays.asList(new CatalogItem("No Bicycle", "", 0));
    }
}