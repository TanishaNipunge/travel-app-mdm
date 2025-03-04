package com.travifai.preferences_ui2.controller;

import com.travifai.preferences_ui2.model.PreferenceUI2;
import com.travifai.preferences_ui2.service.PreferredServiceUI2;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Preferences Management UI2")
@RestController
@RequestMapping("/api/preferences")
public class PreferencesControllerUI2 {
    private final PreferredServiceUI2 preferredService;

    public PreferencesControllerUI2(PreferredServiceUI2 preferredService) {
        this.preferredService = preferredService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Preference UI2 Type Service!";
    }

    // ✅ Search preferences based on filters
    @GetMapping("/search")
    public List<PreferenceUI2> searchPreferences(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer persons,
            @RequestParam(required = false) String checkInDate,
            @RequestParam(required = false) String checkOutDate,
            @RequestParam(required = false) Integer nights,
            @RequestParam(required = false) Integer rooms
    ) {
        return preferredService.searchPreferences(location, persons, checkInDate, checkOutDate, nights, rooms);
    }

    // ✅ Add a new preference
    @PostMapping("/add")
    public PreferenceUI2 addPreference(@RequestBody PreferenceUI2 preference) {
        return preferredService.addPreference(preference);
    }

    // ✅ Update an existing preference
    @PutMapping("/update/{id}")
    public PreferenceUI2 updatePreference(@PathVariable Long id, @RequestBody PreferenceUI2 preference) {
        return preferredService.updatePreference(id, preference);
    }

    // ✅ Delete a preference by ID
    @DeleteMapping("/delete/{id}")
    public String deletePreference(@PathVariable Long id) {
        return preferredService.deletePreference(id);
    }
}
