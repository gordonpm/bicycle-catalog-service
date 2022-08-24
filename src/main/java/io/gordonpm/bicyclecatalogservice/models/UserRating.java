package io.gordonpm.bicyclecatalogservice.models;

import java.util.List;

public class UserRating {

    // needed when restTemplate marshalls the response to an object
    public UserRating() {
    }

    private List<BicycleRating> userRating;

    public List<BicycleRating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<BicycleRating> userRating) {
        this.userRating = userRating;
    }
}
