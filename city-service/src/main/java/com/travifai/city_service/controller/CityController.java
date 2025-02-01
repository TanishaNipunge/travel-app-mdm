package com.travifai.city_service.controller;

import com.travifai.city_service.model.City;
import com.travifai.city_service.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name="City Management")
@RestController
@RequestMapping("/api/cities")
@Api(tags = "City Controller", description = "Operations related to city management")
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "Get all cities", response = List.class)
    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @ApiOperation(value = "Get home message")
    @GetMapping("/")
    public String home() {
        return "Welcome to City Type Service!";
    }

    @ApiOperation(value = "Get city by ID", response = City.class)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> getCityById(
        @ApiParam(value = "ID of the city to retrieve", required = true)
        @PathVariable String id) {
        
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Add a new city", response = City.class)
    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City createdCity = cityService.addCity(city);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete city by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        boolean isDeleted = cityService.deleteCity(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Update an existing city", response = City.class)
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(
        @ApiParam(value = "ID of the city to update", required = true) @PathVariable String id,
        @RequestBody City city) {
        
        Optional<City> existingCity = cityService.getCityById(id);
        
        if (existingCity.isPresent()) {
            City updatedCity = existingCity.get();
            updatedCity.setName(city.getName());
            updatedCity.setCountry(city.getCountry());
            updatedCity.setPopulation(city.getPopulation());
            City savedCity = cityService.addCity(updatedCity); // Save the updated city
            return new ResponseEntity<>(savedCity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
