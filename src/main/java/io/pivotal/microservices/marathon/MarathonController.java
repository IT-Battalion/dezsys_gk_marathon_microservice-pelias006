package io.pivotal.microservices.marathon;

import io.pivotal.microservices.exceptions.MarathonDataNotFoundException;
import io.pivotal.microservices.marathon.model.TimingstationData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
@RestController
public class MarathonController {
    protected Logger logger = Logger.getLogger(MarathonController.class
            .getName());

    protected MarathonRepository marathonRepository;

    public MarathonController(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
        logger.info("Marathon service alive.");
    }

    @RequestMapping("/marathon/{timingStationID}")
    public TimingstationData byTimingStationID(@PathVariable("timingStationID") String timingStationID) {
        logger.info("marathon-service byTimingStationID() invoked: " + timingStationID);
        TimingstationData data = this.marathonRepository.findByTimingstationID(timingStationID);
        logger.info("marathon-service byTimingStationID() invoked: " + data.getId());

        if (data == null) {
            throw new MarathonDataNotFoundException(timingStationID);
        } else {
            return data;
        }
    }

    @RequestMapping("/marathon/{sectionParkID}")
    public List<TimingstationData> bySectionParkID(@PathVariable("sectionParkID") String sectionParkID) {
        logger.info("marathon-service bySectionParkID() invoked: " + sectionParkID);
        List<TimingstationData> data = this.marathonRepository.findBySectionID(sectionParkID);
        logger.info("marathon-service bySectionParkID() found: " + data);

        if (data == null || data.size() == 0) {
            throw new MarathonDataNotFoundException(sectionParkID);
        } else {
            return data;
        }
    }

    @RequestMapping("/marathon/{partyID}")
    public List<TimingstationData> byPartyID(@PathVariable("partyID") String partyID) {
        logger.info("marathon-service byPartyID() invoked: " + partyID);
        List<TimingstationData> data = this.marathonRepository.findByPartyID(partyID);
        logger.info("marathon-service bySectionParkID() found: " + data);

        if (data == null || data.size() == 0) {
            throw new MarathonDataNotFoundException(partyID);
        } else {
            return data;
        }
    }
}
