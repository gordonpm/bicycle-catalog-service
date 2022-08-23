package io.gordonpm.bicyclecatalogservice.models;

public class Bicycle {
    private String id;
    private String vendor;
    private String name;

    public Bicycle() {
    }

    public Bicycle(String id, String vendor, String name) {
        this.id = id;
        this.vendor = vendor;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
