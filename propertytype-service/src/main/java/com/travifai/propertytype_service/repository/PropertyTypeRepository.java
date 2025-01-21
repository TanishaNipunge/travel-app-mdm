package com.travifai.propertytype_service.repository;

import com.travifai.propertytype_service.model.PropertyType;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PropertyTypeRepository extends MongoRepository<PropertyType, String> {

    // Find by property type name
    List<PropertyType> findByName(String name);
    
    // Find by location
    List<PropertyType> findByLocation(String location);

    // Find by star rating
    List<PropertyType> findByStarRating(int starRating);
    
    // Find properties with price less than a given amount
    List<PropertyType> findByStartingPricePerNightLessThan(double price);
}
