package com.travifai.city_service.repository;

import com.travifai.city_service.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
