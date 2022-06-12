package io.pivotal.microservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarathonDataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MarathonDataNotFoundException(String timingStation) {
        super("No such timingstation: " + timingStation);
    }

}
