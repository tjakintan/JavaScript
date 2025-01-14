package edu.psu.matchwarketplace.model;

public record Watch(Long id, String brand, String make, Double price) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String brand() {
        return brand;
    }

    @Override
    public String make() {
        return make;
    }

    @Override
    public Double price() {
        return price;
    }
}
