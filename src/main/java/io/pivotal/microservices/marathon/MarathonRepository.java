package io.pivotal.microservices.marathon;

import io.pivotal.microservices.marathon.model.TimingstationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarathonRepository extends MongoRepository<TimingstationData, String> {
    TimingstationData findByTimingstationID(String timingstationID);
    List<TimingstationData> findBySectionID(String sectionparkID);
    List<TimingstationData> findByPartyID(String partyID);
}
