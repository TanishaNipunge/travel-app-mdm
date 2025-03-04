package com.travifai.preferences_ui2.repository;

import com.travifai.preferences_ui2.model.PreferenceUI2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PreferencesRepositoryUI2 extends MongoRepository<PreferenceUI2, String> {

    // Find preferences by location
    List<PreferenceUI2> findByLocation(String location);

    // Custom search query (Handles null values better)
    @Query("{ : [ " +
            " { 'location': { : ?0 } }, " +
            " { 'persons': { : ?1 } }, " +
            " { 'checkInDate': { : ?2 } }, " +
            " { 'checkOutDate': { : ?3 } }, " +
            " { 'nights': { : ?4 } }, " +
            " { 'rooms': { : ?5 } } " +
            "] }")
    List<PreferenceUI2> searchPreferences(String location, Integer persons, String checkInDate, String checkOutDate, Integer nights, Integer rooms);

    // ✅ Corrected method signatures
    boolean existsById(long id);

    void deleteById(long id);

    Optional<PreferenceUI2> findById(Long id);
}
