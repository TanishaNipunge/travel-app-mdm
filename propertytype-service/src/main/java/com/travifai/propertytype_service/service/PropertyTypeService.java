package com.travifai.propertytype_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travifai.propertytype_service.model.PropertyType;
import com.travifai.propertytype_service.repository.PropertyTypeRepository;

@Service
public class PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;

    public PropertyTypeService(PropertyTypeRepository propertyTypeRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
    }

    // Fetch all property types
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeRepository.findAll();
    }

    // Fetch property type by name
    public List<PropertyType> getPropertyTypeByName(String name) {
        return propertyTypeRepository.findByName(name);
    }

    // Fetch property type by location (Added this method)
    public List<PropertyType> getPropertyTypeByLocation(String location) {
        return propertyTypeRepository.findByLocation(location);
    }

    // Fetch property type by star rating
    public List<PropertyType> getPropertyTypeByStarRating(int starRating) {
        return propertyTypeRepository.findByStarRating(starRating);
    }

    // Fetch property types with price below a certain amount
    public List<PropertyType> getPropertyTypeByPrice(double price) {
        return propertyTypeRepository.findByStartingPricePerNightLessThan(price);
    }

    // Add a new property type
    public PropertyType addPropertyType(PropertyType propertyType) {
        return propertyTypeRepository.save(propertyType);
    }

    // Fetch property type by ID
    public Optional<PropertyType> getPropertyTypeById(String id) {
        return propertyTypeRepository.findById(id);
    }

    // Update property type
    public PropertyType updatePropertyType(String id, PropertyType updatedPropertyType) {
        Optional<PropertyType> existingPropertyType = propertyTypeRepository.findById(id);
        if (existingPropertyType.isPresent()) {
            PropertyType propertyType = existingPropertyType.get();
            propertyType.setName(updatedPropertyType.getName());
            propertyType.setLocation(updatedPropertyType.getLocation());
            propertyType.setStarRating(updatedPropertyType.getStarRating());
            propertyType.setStartingPricePerNight(updatedPropertyType.getStartingPricePerNight());
            return propertyTypeRepository.save(propertyType);
        } else {
            return null; // Handle not found case properly
        }
    }

    // Delete a property type by ID
    public void deletePropertyType(String id) {
        propertyTypeRepository.deleteById(id);
    }
}
