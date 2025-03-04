package com.travifai.preferences_service.repository;

import com.travifai.preferences_service.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PreferencesRepository extends MongoRepository<Preference, String> {
    // ✅ Find all preferences where moods contain the given mood
    List<Preference> findByMoodsContaining(String mood);
}