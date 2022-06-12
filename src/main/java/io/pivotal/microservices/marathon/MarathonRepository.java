package io.pivotal.microservices.marathon;

import java.util.List;

public interface MarathonRepository {
    TimingstationData findByTimingstationID(String timingstationID);
    List<TimingstationData> findBySectionParkID(String sectionparkID);
    List<TimingstationData> findByPartyID(String partyID);
}
