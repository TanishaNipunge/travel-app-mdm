package com.travifai.preferences_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "preferences")
public class Preference {
    @Id
    private String id;
    
    private Map<String, Boolean> moodPreferences; // Key-Value storage for preferences
    private List<String> moods; // ✅ Added a List of moods

    // ✅ Constructor
    public Preference() {}

    // ✅ Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Map<String, Boolean> getMoodPreferences() { return moodPreferences; }
    public void setMoodPreferences(Map<String, Boolean> moodPreferences) { this.moodPreferences = moodPreferences; }

    // ✅ New Getter and Setter for moods
    public List<String> getMoods() { return moods; }
    public void setMoods(List<String> moods) { this.moods = moods; }
}
