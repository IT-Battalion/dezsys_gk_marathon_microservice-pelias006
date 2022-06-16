package io.pivotal.microservices.marathon.model;

import io.pivotal.microservices.marathon.model.CompetitionData;
import io.pivotal.microservices.marathon.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
@Document(collection = "tdata")
public class TimingstationData {
    @Id private String id;
    private String timingstationID;
    private String timestamp;

    private double distance;
    private String unitDistance;

    private double altitude;
    private String unitAltitude;
    private WeatherData weatherData;
    private CompetitionData competitionData;

    /**
     * Constructor
     */
    public TimingstationData() {

        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.unitDistance = "m";
        this.unitAltitude = "hm";
    }

    public TimingstationData(String timingstationID, String timestamp, double distance, String unitDistance, double altitude, String unitAltitude, WeatherData weatherData, CompetitionData competitionData) {
        this.timingstationID = timingstationID;
        this.timestamp = timestamp;
        this.distance = distance;
        this.unitDistance = unitDistance;
        this.altitude = altitude;
        this.unitAltitude = unitAltitude;
        this.weatherData = weatherData;
        this.competitionData = competitionData;
    }

    /**
     * Setter and Getter Methods
     */
    public String getTimingstationID() {
        return timingstationID;
    }

    public void setTimingstationID(String timingstationID) {
        this.timingstationID = timingstationID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getUnitDistance() {
        return unitDistance;
    }

    public void setUnitDistance(String unitDistance) {
        this.unitDistance = unitDistance;
    }

    public String getUnitAltitude() {
        return unitAltitude;
    }

    public void setUnitAltitude(String unitAltitude) {
        this.unitAltitude = unitAltitude;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public CompetitionData getCompetitionData() {
        return competitionData;
    }

    public void setCompetitionData(CompetitionData competitionData) {
        this.competitionData = competitionData;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Methods
     */
    @Override
    public String toString() {
        String info = String.format("Timing Station Info: ID = %s, timestamp = %s, distance = %d",
                timingstationID, timestamp, distance);
        return info;
    }
}
