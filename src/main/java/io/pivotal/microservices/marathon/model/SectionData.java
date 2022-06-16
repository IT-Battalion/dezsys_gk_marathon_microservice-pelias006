package io.pivotal.microservices.marathon.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class SectionData {
    @Id
    private int id;
    private int sectionID;
    private int timingstationID;
    private TimingstationData data;
    private Date timestamp;

    public int getSectionID() {
        return sectionID;
    }

    public int getTimingstationID() {
        return timingstationID;
    }

    public TimingstationData getData() {
        return data;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
