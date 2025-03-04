package com.travifai.preferences_ui2.service;

import com.travifai.preferences_ui2.model.PreferenceUI2;
import com.travifai.preferences_ui2.repository.PreferencesRepositoryUI2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferredServiceUI2 {
    private final PreferencesRepositoryUI2 preferencesRepository;

    public PreferredServiceUI2(PreferencesRepositoryUI2 preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    // ✅ Search preferences with filters
    public List<PreferenceUI2> searchPreferences(String location, Integer persons, String checkInDate, String checkOutDate, Integer nights, Integer rooms) {
        return preferencesRepository.searchPreferences(location, persons, checkInDate, checkOutDate, nights, rooms);
    }

    // ✅ Add a new preference
    public PreferenceUI2 addPreference(PreferenceUI2 preference) {
        return preferencesRepository.save(preference);
    }

    // ✅ Update an existing preference
    public PreferenceUI2 updatePreference(Long id, PreferenceUI2 preference) {
        Optional<PreferenceUI2> existingPreference = preferencesRepository.findById(id);
        if (existingPreference.isPresent()) {
            PreferenceUI2 updatedPreference = existingPreference.get();
            updatedPreference.setLocation(preference.getLocation());
            updatedPreference.setPersons(preference.getPersons());
            updatedPreference.setCheckInDate(preference.getCheckInDate());
            updatedPreference.setCheckOutDate(preference.getCheckOutDate());
            updatedPreference.setNights(preference.getNights());
            updatedPreference.setRooms(preference.getRooms());
            return preferencesRepository.save(updatedPreference);
        } else {
            throw new RuntimeException("Preference with ID " + id + " not found");
        }
    }

    // ✅ Delete a preference
    public String deletePreference(Long id) {
        if (preferencesRepository.existsById(id)) {
            preferencesRepository.deleteById(id);
            return "Preference with ID " + id + " deleted successfully!";
        } else {
            throw new RuntimeException("Preference with ID " + id + " not found");
        }
    }
}
