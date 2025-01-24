package com.travifai.city_service.controller;

import com.travifai.city_service.model.City;
import com.travifai.city_service.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
      @GetMapping("/")
    public String home() {
        return "Welcome to City Type Service!";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>> getCityById(@PathVariable String id) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City createdCity = cityService.addCity(city);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        boolean isDeleted = cityService.deleteCity(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable String id, @RequestBody City city) {
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
