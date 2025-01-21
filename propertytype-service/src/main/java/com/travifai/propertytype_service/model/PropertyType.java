package com.travifai.propertytype_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="propertyType")
public class PropertyType {

    @Id
    private String id;
    private String name;
    private String location;
    private int starRating;
    private boolean breakfastIncluded;
    private boolean freeCancellation;
    private double rating;
    private double startingPricePerNight;

    public PropertyType() {}

    public PropertyType(String name, String location, int starRating, boolean breakfastIncluded, 
                        boolean freeCancellation, double rating, double startingPricePerNight) {
        this.name = name;
        this.location = location;
        this.starRating = starRating;
        this.breakfastIncluded = breakfastIncluded;
        this.freeCancellation = freeCancellation;
        this.rating = rating;
        this.startingPricePerNight = startingPricePerNight;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getStarRating() { return starRating; }
    public void setStarRating(int starRating) { this.starRating = starRating; }

    public boolean isBreakfastIncluded() { return breakfastIncluded; }
    public void setBreakfastIncluded(boolean breakfastIncluded) { this.breakfastIncluded = breakfastIncluded; }

    public boolean isFreeCancellation() { return freeCancellation; }
    public void setFreeCancellation(boolean freeCancellation) { this.freeCancellation = freeCancellation; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public double getStartingPricePerNight() { return startingPricePerNight; }
    public void setStartingPricePerNight(double startingPricePerNight) { this.startingPricePerNight = startingPricePerNight; }
}
