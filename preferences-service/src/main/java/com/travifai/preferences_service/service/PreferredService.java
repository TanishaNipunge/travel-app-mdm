package com.travifai.preferences_service.service;

import com.travifai.preferences_service.model.Preference;
import com.travifai.preferences_service.repository.PreferencesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class PreferredService {
    private final PreferencesRepository preferencesRepository;

    public PreferredService(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    // ✅ Fetch all preferences
    public List<Preference> getAllPreferences() {
    List<Preference> preferences = preferencesRepository.findAll();
    
    // Ensure no preference has null moods
    preferences.forEach(pref -> {
        if (pref.getMoods() == null) {
            pref.setMoods(new ArrayList<>()); // ✅ Set empty list instead of null
        }
    });

    return preferences;
}


    // ✅ Fetch preferences by Mood
    public List<Preference> getPreferencesByMood(String mood) {
        return preferencesRepository.findByMoodsContaining(mood);
    }

    // ✅ Add a new preference
    public Preference addPreference(Preference preference) {
        return preferencesRepository.save(preference);
    }

    // ✅ Fetch a preference by ID
    public Preference getPreferenceById(String id) {
        return preferencesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preference not found"));
    }

    // ✅ Update moods (Replace moods list)
    public Preference updatePreference(String id, List<String> moods) {
        Optional<Preference> optionalPreference = preferencesRepository.findById(id);
    
        if (optionalPreference.isPresent()) {
            Preference preference = optionalPreference.get();
            preference.setMoods(moods);  // ✅ Update moods list
            return preferencesRepository.save(preference);
        } else {
            throw new RuntimeException("Preference not found");
        }
    }

    // ✅ Delete a preference by ID
    public void deletePreference(String id) {
        preferencesRepository.deleteById(id);
    }
}