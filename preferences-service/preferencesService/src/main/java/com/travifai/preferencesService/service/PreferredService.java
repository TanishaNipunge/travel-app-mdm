package com.travifai.preferencesService.service;
import com.travifai.preferencesService.model.Preference;

import org.springframework.stereotype.Service;

import com.travifai.preferencesService.controller.PreferencesController;
import com.travifai.preferencesService.repository.PreferencesRepository;
import java.util.*;

@Service
public class PreferredService {
    private final PreferencesRepository preferencesRepository;

    public PreferredService(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    // Get all preferences
    public List<Preference> getAllPreferences() {
        return preferencesRepository.findAll();
    }

    // Get preferences by name
    public List<Preference> getPreferencesByName(String name) {
        return preferencesRepository.findByName(name);
    }

    // Add a new preference
    public Preference addPreference(Preference preference) {
        return preferencesRepository.save(preference);
    }

    // Get preference by ID
    public Optional<Preference> getPreferenceById(String id) {
        return preferencesRepository.findById(id);
    }

    // Delete preference by ID
    public void deletePreference(String id) {
        preferencesRepository.deleteById(id);
    }
}
