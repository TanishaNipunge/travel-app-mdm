package com.travifai.preferences_service.controller;

import com.travifai.preferences_service.model.Preference;
import com.travifai.preferences_service.service.PreferredService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Preferences Management")
@RestController
@RequestMapping("/api/preferences")
public class PreferencesController {
    private final PreferredService preferredService;

    public PreferencesController(PreferredService preferredService) {
        this.preferredService = preferredService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Preference Type Service!";
    }

    // Fetch all preferences
    @GetMapping
    public List<Preference> getAllPreferences() {
        return preferredService.getAllPreferences();
    }

    // Fetch a preference by ID
    @GetMapping("/{id}")
    public Preference getPreferenceById(@PathVariable String id) {
        return preferredService.getPreferenceById(id);
    }

    // Add a new preference (Mood Preferences)
    @PostMapping
    public Preference addPreference(@RequestBody Preference preference) {
        return preferredService.addPreference(preference);
    }

    // Update preferences dynamically (Add/Delete moods)
    @PatchMapping("/{id}")
    public Preference updatePreference(@PathVariable String id, @RequestBody Map<String, Boolean> updates) {
        return preferredService.updatePreference(id, updates);
    }

    // Delete a preference by ID
    @DeleteMapping("/{id}")
    public void deletePreference(@PathVariable String id) {
        preferredService.deletePreference(id);
    }
}
