package com.travifai.city_service.service;
import com.travifai.city_service.model.City;
import com.travifai.city_service.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    /**
     * Retrieve all cities from the database.
     *
     * @return List of all cities
     */
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    /**
     * Retrieve a city by its ID.
     *
     * @param id City ID
     * @return Optional containing the city if found, or empty if not
     */
    public Optional<City> getCityById(String id) {
        return cityRepository.findById(id);
    }

    /**
     * Add a new city or update an existing one.
     *
     * @param city City object
     * @return Saved City object
     */
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    /**
     * Delete a city by its ID.
     *
     * @param id City ID
     * @return true if the city was deleted, false if the city does not exist
     */
    public boolean deleteCity(String id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
