package io.pivotal.microservices.marathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.logging.Logger;

@ComponentScan
@EntityScan("io.pivotal.microservices.marathon")
@PropertySource("classpath:nosql-db.properties")
@EnableMongoRepositories("io.pivotal.microservices.marathon")
@EnableMongoAuditing
public class MarathonConfiguration {
    protected Logger logger;

    @Autowired
    MongoTemplate mongoTemplate;

    public MarathonConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
