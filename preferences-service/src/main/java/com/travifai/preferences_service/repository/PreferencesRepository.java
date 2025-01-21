package com.travifai.preferences_service.repository;

import com.travifai.preferences_service.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PreferencesRepository extends MongoRepository<Preference, String> {
    List<Preference> findByLocation(String location);
}
