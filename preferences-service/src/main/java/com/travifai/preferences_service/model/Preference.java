package com.travifai.preferences_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "preferences")
public class Preference {
    @Id
    private String id;
    private String location;
    private Map<String, Boolean> moodPreferences; // Key-Value storage for preferences

    // ✅ Constructor
    public Preference() {}

    // ✅ Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Map<String, Boolean> getMoodPreferences() { return moodPreferences; }
    public void setMoodPreferences(Map<String, Boolean> moodPreferences) { this.moodPreferences = moodPreferences; }
}
