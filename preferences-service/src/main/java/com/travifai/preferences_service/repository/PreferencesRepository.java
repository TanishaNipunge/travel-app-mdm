package com.travifai.preferences_service.repository;

import com.travifai.preferences_service.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PreferencesRepository extends MongoRepository<Preference, String> {
     // Find preferences by location (existing query)
    List<Preference> findByLocation(String location);

    // Custom query to find preferences containing a specific mood (useful for dynamic updates)
    @Query("{'moods.?0': { $exists: true }}")
    List<Preference> findByMood(String mood);
}   