package com.travifai.preferences_service.controller;

import com.travifai.preferences_service.model.Preference;
import com.travifai.preferences_service.service.PreferredService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferencesController {
    private final PreferredService preferredService;

    public PreferencesController(PreferredService preferredService) {
        this.preferredService = preferredService;
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to Prefrence Type Service!";
    }
    // ✅ Fetch all preferences
    @GetMapping
    public List<Preference> getAllPreferences() {
        return preferredService.getAllPreferences();
    }

    // ✅ Fetch preferences by location
    @GetMapping("/location/{location}")
    public List<Preference> getPreferencesByLocation(@PathVariable String location) {
        return preferredService.getPreferencesByLocation(location);
    }

    // ✅ Add a new preference with all attributes
    @PostMapping
    public Preference addPreference(@RequestBody Preference preference) {
        // Auto-calculate number of nights
        preference.calculateNumberOfNights();
        return preferredService.addPreference(preference);
    }

    // ✅ Delete a preference by ID
    @DeleteMapping("/{id}")
    public void deletePreference(@PathVariable String id) {
        preferredService.deletePreference(id);
    }
}
