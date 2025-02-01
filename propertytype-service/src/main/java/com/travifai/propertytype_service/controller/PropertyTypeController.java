package com.travifai.propertytype_service.controller;

import java.util.List;
import java.util.Optional;

import com.travifai.propertytype_service.model.PropertyType;
import com.travifai.propertytype_service.service.PropertyTypeService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
@Tag(name="Property Type Management")
@RestController
@RequestMapping("/property-types")
public class PropertyTypeController {

    private final PropertyTypeService propertyTypeService;

    public PropertyTypeController(PropertyTypeService propertyTypeService) {
        this.propertyTypeService = propertyTypeService;
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to Property Type Service!";
    }
    // Fetch all property types
    @GetMapping
    public List<PropertyType> getAllPropertyTypes() {
        return propertyTypeService.getAllPropertyTypes();
    }

    // Fetch property type by name
    @GetMapping("/name/{name}")
    public List<PropertyType> getPropertyTypeByName(@PathVariable String name) {
        return propertyTypeService.getPropertyTypeByName(name);
    }

    // Fetch property type by location (Newly added)
    @GetMapping("/location/{location}")
    public List<PropertyType> getPropertyTypeByLocation(@PathVariable String location) {
        return propertyTypeService.getPropertyTypeByLocation(location);
    }

    // Fetch property type by star rating
    @GetMapping("/star/{starRating}")
    public List<PropertyType> getPropertyTypeByStarRating(@PathVariable int starRating) {
        return propertyTypeService.getPropertyTypeByStarRating(starRating);
    }

    // Fetch property types under a certain price
    @GetMapping("/price/{price}")
    public List<PropertyType> getPropertyTypeByPrice(@PathVariable double price) {
        return propertyTypeService.getPropertyTypeByPrice(price);
    }

    // Fetch property type by ID
    @GetMapping("/{id}")
    public Optional<PropertyType> getPropertyTypeById(@PathVariable String id) {
        return propertyTypeService.getPropertyTypeById(id);
    }

    // Add a new property type
    @PostMapping
    public PropertyType addPropertyType(@RequestBody PropertyType propertyType) {
        return propertyTypeService.addPropertyType(propertyType);
    }

    // Update a property type (Added PUT method)
    @PutMapping("/{id}")
    public PropertyType updatePropertyType(@PathVariable String id, @RequestBody PropertyType propertyType) {
        return propertyTypeService.updatePropertyType(id, propertyType);
    }

    // Delete a property type by ID
    @DeleteMapping("/{id}")
    public void deletePropertyType(@PathVariable String id) {
        propertyTypeService.deletePropertyType(id);
    }
}
