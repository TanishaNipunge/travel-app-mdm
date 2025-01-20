package com.travifai.preferencesService.repository;
import com.travifai.preferencesService.model.Preference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface PreferencesRepository extends MongoRepository<Preference, String> {
    List<Preference> findByName(String name); // Custom query to find preferences by name
}
