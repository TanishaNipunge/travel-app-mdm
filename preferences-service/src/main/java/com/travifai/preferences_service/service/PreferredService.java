package com.travifai.preferences_service.service;

import com.travifai.preferences_service.model.Preference;
import com.travifai.preferences_service.repository.PreferencesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PreferredService {
    private final PreferencesRepository preferencesRepository;

    public PreferredService(PreferencesRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    public List<Preference> getAllPreferences() {
        return preferencesRepository.findAll();
    }

    public List<Preference> getPreferencesByLocation(String location) {
        return preferencesRepository.findByLocation(location);
    }

    public Preference addPreference(Preference preference) {
        return preferencesRepository.save(preference);
    }

    public void deletePreference(String id) {
        preferencesRepository.deleteById(id);
    }
}
