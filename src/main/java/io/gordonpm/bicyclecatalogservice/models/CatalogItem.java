package io.gordonpm.bicyclecatalogservice.models;

public class CatalogItem {

    private String name;
    private String vendor;
    private int rating;

    public CatalogItem(String name, String vendor, int rating) {
        this.name = name;
        this.vendor = vendor;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
