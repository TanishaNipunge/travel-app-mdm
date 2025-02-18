package com.travifai.preferences_service.service;

import com.travifai.preferences_service.model.Preference;
import com.travifai.preferences_service.repository.PreferencesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PreferredService {
    private final PreferencesRepository preferencesRepository;

    public PreferredService(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    // Fetch all preferences
    public List<Preference> getAllPreferences() {
        return preferencesRepository.findAll();
    }

    // Fetch preferences by location
    public List<Preference> getPreferencesByLocation(String location) {
        return preferencesRepository.findByLocation(location);
    }

    // Add a new preference
    public Preference addPreference(Preference preference) {
        return preferencesRepository.save(preference);
    }

    // Delete a preference by ID
    public void deletePreference(String id) {
        preferencesRepository.deleteById(id);
    }

    // Fetch a preference by ID
    public Preference getPreferenceById(String id) {
        Optional<Preference> preference = preferencesRepository.findById(id);
        return preference.orElseThrow(() -> new RuntimeException("Preference not found"));
    }

    // Update preferences dynamically (Add/Delete moods)
    public Preference updatePreference(String id, Map<String, Boolean> updates) {
        Optional<Preference> optionalPreference = preferencesRepository.findById(id);
        
        if (optionalPreference.isPresent()) {
            Preference preference = optionalPreference.get();
            // Update the mood preferences map with the new values
            updates.forEach(preference.getMoodPreferences()::put);
            return preferencesRepository.save(preference);
        } else {
            throw new RuntimeException("Preference not found");
        }
    }
}
