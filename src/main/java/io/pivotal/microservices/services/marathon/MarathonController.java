package io.pivotal.microservices.services.marathon;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MarathonController {
    protected Logger logger = Logger.getLogger(MarathonController.class
            .getName());

    @RequestMapping("/marathon/{timingStationID}")
    public void byTimingStationID(@PathVariable("timingStationID") String timingStationID) {
        logger.info("marathon-service byTimingStationID() invoked: " + timingStationID);
    }

    @RequestMapping("/marathon/{sectionParkID}")
    public void bySectionParkID(@PathVariable("sectionParkID") String sectionParkID) {
        logger.info("marathon-service bySectionParkID() invoked: " + sectionParkID);
    }

    @RequestMapping("/marathon/{partyID}")
    public void byPartyID(@PathVariable("partyID") String partyID) {
        logger.info("marathon-service byPartyID() invoked: " + partyID);
    }
}
