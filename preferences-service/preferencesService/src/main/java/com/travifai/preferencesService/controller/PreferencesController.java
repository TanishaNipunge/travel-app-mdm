package com.travifai.preferencesService.controller;
import com.travifai.preferencesService.repository.PreferencesRepository;
import com.travifai.preferencesService.service.PreferredService;
import com.travifai.preferencesService.model.Preference;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prefrences")
public class PreferencesController {
    private final PreferredService preferredService;

    public PreferencesController(PreferredService preferredService) {
        this.preferredService = preferredService;
    }

    // Fetch all preferences
    @GetMapping
    public List<Preference> getAllPreferences() {
        return preferredService.getAllPreferences();
    }

    // Fetch preferences by name
    @GetMapping("/{name}")
    public List<Preference> getPreferenceByName(@PathVariable String name) {
        return preferredService.getPreferencesByName(name);
    }

    // Add a new preference
    @PostMapping
    public Preference addPreference(@RequestBody Preference preference) {
        return preferredService.addPreference(preference);
    }

    // Delete a preference by ID
    @DeleteMapping("/{id}")
    public void deletePreference(@PathVariable String id) {
        preferredService.deletePreference(id);
    }
}
